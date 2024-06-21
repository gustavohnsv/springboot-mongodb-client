package com.gustavohnsv.clients.controller;

import com.gustavohnsv.clients.model.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    public HomeController() {}

    @GetMapping("/api/")
    public Message home() {
        return new Message("success", "Connection established successfully!");
    }

}
