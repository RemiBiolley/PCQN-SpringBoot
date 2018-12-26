package com.pcqn.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccueilController {
    @GetMapping("/accueil")
    public String displayAccueil(Model model, HttpServletRequest request){
        if(request.getSession(false)!=null){
            model.addAttribute("isConnected", "Profil");
            model.addAttribute("destination", "/profil");
        }
        else{
            model.addAttribute("isConnected", "Connexion / Inscription");
            model.addAttribute("destination", "/connection");
        }
        return "accueil";
    }

    @GetMapping("/profil")
    public String displayProfile(Model model, HttpServletRequest request){
        if(request.getSession(false)!=null){
            return "profil";
        }
        else{
            return "connection";
        }

    }
}
