package com.pcqn.demo.web.controller;

import com.pcqn.demo.Comment;
import com.pcqn.demo.Game;
import com.pcqn.demo.Note;
import com.pcqn.demo.User;
import com.pcqn.demo.CommentRepository;
import com.pcqn.demo.GameRepository;
import com.pcqn.demo.NoteRepository;
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

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/game")
    public String displayGameList(HttpServletRequest request, Model model){
        if(request.getSession(false)!=null){
            if(request.getSession(false).getAttribute("user")!=null){
                model.addAttribute("isConnected", "Profil");
                model.addAttribute("destination", "/profil");
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
        List<Game> games = gameRepository.findAll();

        model.addAttribute("momentGame1", momentGames.get(0));
        model.addAttribute("momentGame2", momentGames.get(1));
        model.addAttribute("games", games);
        return "gameList";
    }

    @GetMapping("/game/{id}")
    public String displayGamePage(@PathVariable Integer id, HttpServletRequest request, Model model){
        if(request.getSession(false)!=null){
            if(request.getSession(false).getAttribute("user")!=null){
                model.addAttribute("isConnected", "Profil");
                model.addAttribute("destination", "/profil");
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
        Game game = gameRepository.findGameById(id);

        String name = game.getName();

        List<Comment> comments = commentRepository.findAllByGameId(id);

        model.addAttribute("comments", comments);
        model.addAttribute("game", game);
        model.addAttribute("momentGame1", momentGames.get(0));
        model.addAttribute("momentGame2", momentGames.get(1));
        return "game/" + name;
    }

    @PostMapping("/note")
    @ResponseBody
    public void changeNote(@RequestParam float note,@RequestParam int gameId, HttpServletRequest request){
        if(request.getSession(false)==null){
            System.out.println("pas log");
        }
        else{
            if(request.getSession(false).getAttribute("user")==null){
                System.out.println("pas log");
            }

            else {
                System.out.println(note);
                System.out.println(gameId);
                User user = (User) request.getSession().getAttribute("user");
                System.out.println(noteRepository.findNoteByUserAndGame(user.getId(), gameId));
                Game game = gameRepository.findGameById(gameId);

                if (noteRepository.findNoteByUserAndGame(user.getId(), gameId) == null) {
                    Note noteSQL = new Note();

                    noteSQL.setNote(note);
                    noteSQL.setUser(user);
                    noteSQL.setGame(game);
                    noteRepository.save(noteSQL);

                    game.increaseNoteCounter();
                } else {
                    Integer noteId = noteRepository.findIdNoteByUserAndGame(user.getId(), gameId);
                    Note changedNote = noteRepository.findNoteById(noteId);
                    System.out.println("final :" + note);
                    changedNote.setNote(note);
                    noteRepository.save(changedNote);
                }

                float newGameMean = noteRepository.calculateNewGameMean(gameId);
                game.setNote(newGameMean);
                gameRepository.save(game);
            }
        }
    }
}
