package com.gustavohnsv.clients.controller;

import com.gustavohnsv.clients.exception.*;
import com.gustavohnsv.clients.model.Message;
import com.gustavohnsv.clients.model.Product;
import com.gustavohnsv.clients.model.ProductInfo;
import com.gustavohnsv.clients.model.ShoppingCart;
import com.gustavohnsv.clients.repository.ClientRepository;
import com.gustavohnsv.clients.repository.ShoppingCartsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/carts/")
public class ShoppingCartsController {

    private final ShoppingCartsRepository shoppingCartsRepository;
    private final ClientRepository clientRepository;

    public ShoppingCartsController(ShoppingCartsRepository shoppingCartsRepository, ClientRepository clientRepository) {
        this.shoppingCartsRepository = shoppingCartsRepository;
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public Iterable<ShoppingCart> getShoppingCarts() {
        return shoppingCartsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ShoppingCart getShoppingCart(@PathVariable String id) {
        return shoppingCartsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Shopping cart not found with id: " + id));
    }

    @PostMapping("/")
    public ShoppingCart createShoppingCart(@RequestParam String id) {
        clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));
        for (ShoppingCart shoppingCart: getShoppingCarts()) {
            if (shoppingCart.getOwner_id().equals(id)) {
                throw new ResourceAlreadyExistsException("Shopping cart already exists with id: " + id);
            }
        }
        ShoppingCart shoppingCart = new ShoppingCart(id, 0, 0, new ArrayList<>());
        return shoppingCartsRepository.save(shoppingCart);
    }

    @DeleteMapping("/")
    public Message deleteShoppingCart(@RequestParam String id) {
        ShoppingCart shoppingCart = shoppingCartsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Shopping cart not found with id: " + id));
        shoppingCartsRepository.delete(shoppingCart);
        return new Message("success", "Shopping cart deleted with success!");
    }

    @PutMapping("/{cartID}/")
    public ShoppingCart addItemToCart(@PathVariable String cartID, @RequestBody Map<String, Object> request) {
        ShoppingCart cart = shoppingCartsRepository.findById(cartID).orElseThrow(() -> new ResourceNotFoundException("Shopping cart not found with id: " + cartID));
        if (!request.containsKey("name") || !request.containsKey("amount") || !request.containsKey("price")) {
            throw new TooFewArgumentsException("Too few arguments with cart ID: " + cartID);
        } else if (Objects.equals(request.get("name"), "") || (double) request.get("price") <= 0 || (int) request.get("amount") <= 0) {
            throw new WrongArgumentsException("Wrong arguments with cart ID: " + cartID);
        } else {
            Product product = new Product((double) request.get("price"), (int) request.get("amount"), (String) request.get("name"));
            cart.setAmount(cart.getAmount() + product.amount());
            cart.setValue(cart.getValue() + product.value() * product.amount());
            cart.addItem(new ProductInfo(product.value(), product.name()), product.amount());
            return shoppingCartsRepository.save(cart);
        }
    }

    @DeleteMapping("/{cartID}/")
    public ShoppingCart deleteItemFromCart(@PathVariable String cartID, @RequestBody Map<String, Object> request) {
        ShoppingCart cart = shoppingCartsRepository.findById(cartID).orElseThrow(() -> new ResourceNotFoundException("Shopping cart not found with id: " + cartID));
        if (!request.containsKey("name") || !request.containsKey("amount")) {
            throw new TooFewArgumentsException("Too few arguments with cart ID: " + cartID);
        } else if (Objects.equals(request.get("name"), "") || (int) request.get("amount") <= 0) {
            throw new WrongArgumentsException("Wrong arguments with cart ID: " + cartID);
        } else {
            double itemValue = cart.getItemValue((String) request.get("name"));
            int amountToRemove = (int) request.get("amount");
            ProductInfo productInfo = new ProductInfo(itemValue, (String) request.get("name"));
            cart.setAmount(cart.getAmount() - amountToRemove);
            double residueCartValue = cart.getValue() - (productInfo.price() * amountToRemove);
            if (residueCartValue < 0) {
                cart.setValue(0);
            } else {
                cart.setValue(residueCartValue);
            }
            if (cart.removeItem(new ProductInfo(itemValue, productInfo.name()), amountToRemove)) {
                return shoppingCartsRepository.save(cart);
            } else {
                throw new WrongArgumentsException("Insufficient item or items to remove from cart with id: " + cartID);
            }
        }
    }

    @PostMapping("/{cartID}/")
    public ShoppingCart clearItemsFromCart(@PathVariable String cartID) {
        ShoppingCart cart = shoppingCartsRepository.findById(cartID).orElseThrow(() -> new ResourceNotFoundException("Shopping cart not found with id: " + cartID));
        if (!cart.getItems().isEmpty()) {
            cart.setValue(0);
            cart.setAmount(0);
            cart.getItems().clear();
        }
        return shoppingCartsRepository.save(cart);
    }

}