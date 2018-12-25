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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ConnectionController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/connection")
    public String connectionForm(Model model, HttpServletRequest request) {
        String destination;
        if(request.getSession(false)!=null){
            System.out.println("1");
            User user = (User) request.getSession().getAttribute("user");
            model.addAttribute("name", user.getUserName());
            model.addAttribute("email", user.getEmail());
            destination="profil";
        }
        else{
            System.out.println("2");
            model.addAttribute("connection", new Connection());
            destination="connection";
        }
        return destination;
    }

    @PostMapping("/connection")
    public String connectionSubmit(@ModelAttribute Connection connection, Model model, HttpServletRequest request) {
        
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

}