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
import org.springframework.web.bind.annotation.ResponseBody;

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
            User user = (User) request.getSession().getAttribute("user");
            model.addAttribute("name", user.getUserName());
            model.addAttribute("email", user.getEmail());
            destination="profil";
        }
        else{
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
    public String addNewUser(@ModelAttribute Connection connection, Model model){
        User n = new User();
        n.setUserName(connection.getUsername());
        n.setPassword(connection.getPassword());
        n.setEmail(connection.getEmail());
        userRepository.save(n);

        model.addAttribute("name", n.getUserName());
        model.addAttribute("email", n.getEmail());
        return "profil";
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}