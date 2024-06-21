package com.gustavohnsv.clients.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Data
@Document(collection = "shopping-carts")
public class ShoppingCart {

    @Id
    private String id;
    private final String owner_id;
    private double value;
    private int amount;
    private final List<ProductInfo> items;

    public ShoppingCart(String owner_id, double value, int amount, List<ProductInfo> items) {
        this.owner_id = owner_id;
        this.value = value;
        this.amount = amount;
        this.items = items;
    }

    public void addItem(ProductInfo item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(item);
        }
    }

    public boolean removeItem(ProductInfo item, int quantity) {
        boolean found = false;
        for (int i = 0; i < quantity; i++) {
            found = items.remove(item);
        }
        return found;
    }

    public double getItemValue(String name){
        for (ProductInfo item: items) {
            if (Objects.equals(item.name(), name)) {
                return item.price();
            }
        }
        return 0;
    }
    
}
