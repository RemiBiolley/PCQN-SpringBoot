package com.pcqn.demo.web.controller;

import com.pcqn.demo.Game;
import com.pcqn.demo.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/game/{id}")
    public String displayGamePage(@PathVariable Integer id){
        Game game = gameRepository.findGameById(id);
        String name = game.getName();
        return "game/" + name;
    }

}
