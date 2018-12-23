package com.pcqn.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {
    @GetMapping("/accueil")
    public String displayAccueil(Model model){
        return "accueil";
    }
}
