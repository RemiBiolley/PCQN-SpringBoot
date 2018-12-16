package com.pcqn.demo.web.controller;

import com.pcqn.demo.Connection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConnectionController {

    @GetMapping("/connection")
    public String connectionForm(Model model) {
        model.addAttribute("connection", new Connection());
        return "connection";
    }

    @PostMapping("/connection")
    public String connectionSubmit(@ModelAttribute Connection connection) {
        if(connection.connectVerif("password", "id")){
            return "result";
        }
        else{
            return "connection";
        }
    }

}