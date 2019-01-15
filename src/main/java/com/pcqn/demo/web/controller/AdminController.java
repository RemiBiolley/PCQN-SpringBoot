package com.pcqn.demo.web.controller;

import com.pcqn.demo.*;
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
public class AdminController {
    @Autowired
    GameRepository gameRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserTypeRepository userTypeRepository;

    @GetMapping("/adminPage")
    public String displayAdminPage(HttpServletRequest request, Model model) {
        List<Game> momentGames = gameRepository.findGameByMomentGame(1);
        model.addAttribute("momentGame1", momentGames.get(0));
        model.addAttribute("momentGame2", momentGames.get(1));

        if (request.getSession(false) != null) {
            User user = (User) request.getSession(false).getAttribute("user");
            if (user != null) {
                if(user.getUserType().getId()==2  || user.getUserType().getId()==3){
                    List<User> users = userRepository.findAll();
                    List<Game> games = gameRepository.findAll();
                    List<String> availableGames = gameRepository.findGamesNames();

                    model.addAttribute("avatar", user.getAvatar());
                    model.addAttribute("user", user);
                    model.addAttribute("isConnected", "Profil");
                    model.addAttribute("destination", "/profil");
                    model.addAttribute("users", users);
                    model.addAttribute("games", games);
                    model.addAttribute("availableGames", availableGames);

                    return "adminPage";
                }
                else{
                    return "redirect:/accueil";
                }

            } else {
                return "redirect:/connection";
            }
        } else {
            return "redirect:/connection";
        }
    }

    @PostMapping("/changeMomentGame")
    @ResponseBody
    public void changeFavoriteGame(@RequestParam String newGameName, @RequestParam String removedGameName){
        Game removedGame = gameRepository.findGameByGameName(removedGameName);
        Game newGame = gameRepository.findGameByGameName(newGameName);

        removedGame.setMomentGame(0);
        newGame.setMomentGame(1);

        gameRepository.save(removedGame);
        gameRepository.save(newGame);
    }

    @PostMapping("/promote")
    @ResponseBody
    public void promote(@RequestParam String promotedUserName){
        User promotedUser = userRepository.findUserByUserName(promotedUserName);
        UserType adminType = userTypeRepository.findUserTypeById(2);

        promotedUser.setUserType(adminType);
        userRepository.save(promotedUser);
    }

    @PostMapping("/removeUser")
    @ResponseBody
    public void removeUser(@RequestParam String removedUserName){
        User removedUser = userRepository.findUserByUserName(removedUserName);
        userRepository.delete(removedUser);
    }

}
