package com.pcqn.demo.web.controller;

import com.pcqn.demo.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.pcqn.demo.User;
import com.pcqn.demo.UserRepository;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    /*@PostMapping("/connection")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        User n = new User();
        n.setName(name);
        n.setPassword(password);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    } */

    @PostMapping("/inscription")
    public String addNewUser(@ModelAttribute Connection connection){
        User n = new User();
        n.setUserName(connection.getUsername());
        n.setPassword(connection.getPassword());
        n.setEmail(connection.getEmail());
        userRepository.save(n);
        return "profil";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
