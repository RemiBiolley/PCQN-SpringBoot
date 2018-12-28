package com.pcqn.demo.web.controller;

import com.pcqn.demo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private NoteRepository noteRepository;

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
        model.addAttribute("gameId", game.getId());
        model.addAttribute("momentGame1", momentGames.get(0));
        model.addAttribute("momentGame2", momentGames.get(1));
        return "game/" + name;
    }

    @PostMapping("/note")
    @ResponseBody
    public void changeNote(@RequestParam String note,@RequestParam String gameId, HttpServletRequest request){
        if(request.getSession(false)==null){
            // Afficher message sur la page (js ?????)
            System.out.println("oupsi1");
        }
        else{
            System.out.println(note);
            System.out.println(gameId);
            User user = (User) request.getSession().getAttribute("user");
            System.out.println(noteRepository.findNoteByUserAndGame(user.getId(), Integer.parseInt(gameId)));
            if(noteRepository.findNoteByUserAndGame(user.getId(), Integer.parseInt(gameId))==null){
                Note noteSQL = new Note();
                Game game = gameRepository.findGameById(Integer.parseInt(gameId));

                noteSQL.setNote(Float.parseFloat(note));
                noteSQL.setUser(user);
                noteSQL.setGame(game);
                noteRepository.save(noteSQL);
            }
            else{
                Integer noteId = noteRepository.findIdNoteByUserAndGame(user.getId(), Integer.parseInt(gameId));
                Note changedNote = noteRepository.findNoteById(noteId);
                System.out.println("final :" + Float.parseFloat(note));
                changedNote.setNote(Float.parseFloat(note));
                noteRepository.save(changedNote);

            }
        }

    }

}
