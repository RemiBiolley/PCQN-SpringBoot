package com.pcqn.demo.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FooterController {
    @GetMapping("/droitsréservés")
    public String displayDroits() {
        return "droitsréservés";
    }
    @GetMapping("/conditions")
    public String displayConditions() {
        return "conditions";
    }
    @GetMapping("/réseaux")
    public String displayReseaux() {
        return "réseaux";
    }
    @GetMapping("/contact")
    public String displayContact() {
        return "contact";
    }

}

