package com.pcqn.demo.web.controller;

import com.pcqn.demo.Connection;
import com.pcqn.demo.Game;
import com.pcqn.demo.User;
import com.pcqn.demo.GameRepository;
import com.pcqn.demo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AccueilController {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/accueil")
    public String displayAccueil(Model model, HttpServletRequest request){
        if(request.getSession(false)!=null){
            if(request.getSession(false).getAttribute("user")!=null){
                User user = (User) request.getSession().getAttribute("user");
                model.addAttribute("avatar", user.getAvatar());
                model.addAttribute("isConnected", "Profil");
                model.addAttribute("destination", "/profil");
                model.addAttribute("user", user);
            }
            else{
                model.addAttribute("isConnected", "Connexion / Inscription");
                model.addAttribute("destination", "/connection");
            }
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
}
