package com.pcqn.demo.web.controller;

import com.pcqn.demo.Connection;
import com.pcqn.demo.Game;
import com.pcqn.demo.GameRepository;
import com.pcqn.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AccueilController {
    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/accueil")
    public String displayAccueil(Model model, HttpServletRequest request){
        if(request.getSession(false).getAttribute("user")!=null){
            model.addAttribute("isConnected", "Profil");
            model.addAttribute("destination", "/profil");
        }
        else{
            model.addAttribute("isConnected", "Connexion / Inscription");
            model.addAttribute("destination", "/connection");
        }

        List<Game> momentGames = gameRepository.findGameByMomentGame(1);
        model.addAttribute("momentGame1", momentGames.get(0));
        model.addAttribute("momentGame2", momentGames.get(1));
        return "accueil";
    }

    @GetMapping("/profil")
    public String displayProfile(Model model, HttpServletRequest request){
        List<Game> momentGames = gameRepository.findGameByMomentGame(1);
        model.addAttribute("momentGame1", momentGames.get(0));
        model.addAttribute("momentGame2", momentGames.get(1));

        if(request.getSession(false).getAttribute("user")!=null){
            User user = (User) request.getSession().getAttribute("user");
            model.addAttribute("name", user.getUserName());
            model.addAttribute("email", user.getEmail());
            return "profil";
        }
        else{
            model.addAttribute("connection", new Connection());
            return "connection";
        }

    }
}
