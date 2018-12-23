package com.pcqn.demo.web.controller;

import com.pcqn.demo.Connection;
import com.pcqn.demo.UserRepository;
import com.pcqn.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConnectionController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/connection")
    public String connectionForm(Model model) {
        model.addAttribute("connection", new Connection());
        return "connection";
    }

    @PostMapping("/connection")
    public String connectionSubmit(@ModelAttribute Connection connection, Model model) {
        
        if(userRepository.existsUserByEmailAndPassword(connection.getEmail(), connection.getPassword())){
            User user = userRepository.findUserByEmailAndPassword(connection.getEmail(), connection.getPassword());
            model.addAttribute("name", user.getUserName());
            model.addAttribute("email", user.getEmail());
            return "profil";
        }
        else{
            return "connection";
        }
    }

}