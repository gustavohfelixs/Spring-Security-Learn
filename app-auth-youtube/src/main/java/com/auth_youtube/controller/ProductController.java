package com.auth_youtube.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    

    @GetMapping("/")
    public String list() {
        return "Listando produtos";
    }

    @PostMapping("/") 
    public String create() {
        return "cadastrando produtos";
    }
}
