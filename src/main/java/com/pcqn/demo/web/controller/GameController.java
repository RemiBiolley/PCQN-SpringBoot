package com.pcqn.demo.web.controller;

import com.pcqn.demo.Game;
import com.pcqn.demo.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/game/{id}")
    public String displayGamePage(@PathVariable Integer id, HttpServletRequest request, Model model){
        if(request.getSession(false)!=null){
            model.addAttribute("isConnected", "Profil");
            model.addAttribute("destination", "/profil");
        }
        else{
            model.addAttribute("isConnected", "Connexion / Inscription");
            model.addAttribute("destination", "/connection");
        }
        Game game = gameRepository.findGameById(id);
        String name = game.getName();
        return "game/" + name;
    }

}
