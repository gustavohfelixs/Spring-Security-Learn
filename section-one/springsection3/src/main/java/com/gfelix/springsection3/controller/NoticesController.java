package com.gfelix.springsection3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {
    
    @GetMapping("/notices")
    public String findNotices() {
        return "Here are the notices from DB";
    }

}
