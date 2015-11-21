package com.luxoft.cantor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String helloMessage(Model model) {
        model.addAttribute("message", "heello on page");
        return "welcome";
    }
}
