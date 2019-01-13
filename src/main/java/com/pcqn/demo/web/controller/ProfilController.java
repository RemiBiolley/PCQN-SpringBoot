package com.pcqn.demo.web.controller;

import com.pcqn.demo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProfilController {
    @Autowired
    GameRepository gameRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    @GetMapping("/profil")
    public String displayProfile(Model model, HttpServletRequest request){
        List<Game> momentGames = gameRepository.findGameByMomentGame(1);
        model.addAttribute("momentGame1", momentGames.get(0));
        model.addAttribute("momentGame2", momentGames.get(1));

        if(request.getSession(false)!=null){
            if(request.getSession(false).getAttribute("user")!=null){
                User user = (User) request.getSession().getAttribute("user");
                UserInfo userInfo = userInfoRepository.findAllByUserId(user.getId());
                List<String> availableGames = gameRepository.findGamesNames();

                model.addAttribute("avatar", user.getAvatar());
                model.addAttribute("availableGames", availableGames);
                model.addAttribute("userInfo", userInfo);
                model.addAttribute("user", user);
                model.addAttribute("myProfile", "me");
                model.addAttribute("isConnected", "Profil");
                model.addAttribute("destination", "/profil");

                return "profil";
            }
            else{
                model.addAttribute("connection", new Connection());
                model.addAttribute("isConnected", "Connexion / Inscription");
                model.addAttribute("destination", "/connection");
                return "connection";
            }
        }
        else{
            model.addAttribute("connection", new Connection());
            model.addAttribute("isConnected", "Connexion / Inscription");
            model.addAttribute("destination", "/connection");
            return "connection";
        }
    }

    @GetMapping("/profil/{id}")
    public String displayGamePage(@PathVariable Integer id, HttpServletRequest request, Model model){
        User user = null;

        if(request.getSession(false)!=null){
            if(request.getSession(false).getAttribute("user")!=null){
                user = (User) request.getSession().getAttribute("user");
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

        User userProfil = userRepository.findUserById(id);
        UserInfo userInfo = userInfoRepository.findAllByUserId(userProfil.getId());

        model.addAttribute("user", userProfil);
        model.addAttribute("userInfo",userInfo);

        if(user!=null){
            if(!userProfil.getId().equals(user.getId())){
                model.addAttribute("myProfile", "notMe");
            }
            else{
                model.addAttribute("myProfile", "me");
            }
        }
        else{
            model.addAttribute("myProfile", "notMe");
        }


        return "profil";
    }

    @PostMapping("/changeAvatar")
    @ResponseBody
    public void changeAvatar(@RequestParam String avatar, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        user.setAvatar(avatar);
        request.getSession().setAttribute("user", user);
        userRepository.save(user);
    }

    @PostMapping("/changePassword")
    @ResponseBody
    public void changePassword(@RequestParam String password, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        user.setPassword(password);
        userRepository.save(user);
    }

    @PostMapping("/changeName")
    @ResponseBody
    public void changeName(@RequestParam String firstName, String lastName, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");

        UserInfo userInfo = userInfoRepository.findAllByUserId(user.getId());
        userInfo.setFirstName(firstName);
        userInfo.setLastName(lastName);
        userInfoRepository.save(userInfo);
    }

    @PostMapping("/changeTel")
    @ResponseBody
    public void changeTel(@RequestParam String tel, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");

        UserInfo userInfo = userInfoRepository.findAllByUserId(user.getId());
        userInfo.setTelephone(tel);
        userInfoRepository.save(userInfo);
    }

    @PostMapping("/changeFavoriteGame")
    @ResponseBody
    public void changeFavoriteGame(@RequestParam String game, HttpServletRequest request){
        Game favoriteGame = gameRepository.findGameByGameName(game);
        if(favoriteGame!=null) {
            User user = (User) request.getSession().getAttribute("user");

            UserInfo userInfo = userInfoRepository.findAllByUserId(user.getId());
            userInfo.setGame(favoriteGame);
            userInfoRepository.save(userInfo);
        }
    }
}
