package com.pcqn.demo.web.controller;

import com.pcqn.demo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ConnectionController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/connection")
    public String connectionForm(Model model, HttpServletRequest request) {
        String destination="error";
        if(request.getSession(false)!=null){
            if(request.getSession(false).getAttribute("user")!=null){
                User user = (User) request.getSession().getAttribute("user");
                model.addAttribute("name", user.getUserName());
                model.addAttribute("email", user.getEmail());
                destination="profil";
            }
            else{
                model.addAttribute("connection", new Connection());
                destination="connection";
            }
        }
        else{
            model.addAttribute("connection", new Connection());
            destination="connection";
        }

        List<Game> momentGames = gameRepository.findGameByMomentGame(1);
        model.addAttribute("momentGame1", momentGames.get(0));
        model.addAttribute("momentGame2", momentGames.get(1));
        return destination;
    }

    @PostMapping("/connection")
    public String connectionSubmit(@ModelAttribute Connection connection, Model model, HttpServletRequest request) {
        List<Game> momentGames = gameRepository.findGameByMomentGame(1);
        model.addAttribute("momentGame1", momentGames.get(0));
        model.addAttribute("momentGame2", momentGames.get(1));

        if(userRepository.existsUserByEmailAndPassword(connection.getEmail(), connection.getPassword())){
            User user = userRepository.findUserByEmailAndPassword(connection.getEmail(), connection.getPassword());
            request.getSession().setAttribute("user", user);
            model.addAttribute("name", user.getUserName());
            model.addAttribute("email", user.getEmail());
            return "profil";
        }
        else{
            return "connection";
        }
    }

    @PostMapping("/inscription")
    public String addNewUser(@ModelAttribute Connection connection, Model model, HttpServletRequest request){
        User n = new User();
        n.setUserName(connection.getUsername());
        n.setPassword(connection.getPassword());
        n.setEmail(connection.getEmail());
        userRepository.save(n);

        request.getSession().setAttribute("user", n);
        model.addAttribute("name", n.getUserName());
        model.addAttribute("email", n.getEmail());

        List<Game> momentGames = gameRepository.findGameByMomentGame(1);
        model.addAttribute("momentGame1", momentGames.get(0));
        model.addAttribute("momentGame2", momentGames.get(1));
        model.addAttribute("name", n.getUserName());
        model.addAttribute("email", n.getEmail());
        return "profil";
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path="/disconnect")
    public String disconnect(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/accueil";
    }

}