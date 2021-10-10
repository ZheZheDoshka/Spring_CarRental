package com.zhe.carrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RentalController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "mainpage");
        return "home";
    }
}
