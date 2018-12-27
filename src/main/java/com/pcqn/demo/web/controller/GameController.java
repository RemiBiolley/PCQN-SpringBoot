package com.pcqn.demo.web.controller;

import com.pcqn.demo.Game;
import com.pcqn.demo.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/game")
    public String displayGameList(HttpServletRequest request, Model model){
        if(request.getSession(false)!=null){
            model.addAttribute("isConnected", "Profil");
            model.addAttribute("destination", "/profil");
        }
        else{
            model.addAttribute("isConnected", "Connexion / Inscription");
            model.addAttribute("destination", "/connection");
        }
        List<Game> momentGames = gameRepository.findGameByMomentGame(1);
        List<Game> games = gameRepository.findAll();

        model.addAttribute("momentGame1", momentGames.get(0));
        model.addAttribute("momentGame2", momentGames.get(1));
        model.addAttribute("games", games);
        return "gameList";

    }

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
        List<Game> momentGames = gameRepository.findGameByMomentGame(1);
        Game game = gameRepository.findGameById(id);

        String name = game.getName();
        model.addAttribute("momentGame1", momentGames.get(0));
        model.addAttribute("momentGame2", momentGames.get(1));
        return "game/" + name;
    }

}
