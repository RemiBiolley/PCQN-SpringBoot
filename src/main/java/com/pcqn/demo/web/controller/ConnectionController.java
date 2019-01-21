package com.pcqn.demo.web.controller;

import com.pcqn.demo.*;
import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class ConnectionController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @GetMapping("/connection")
    public String connectionForm(Model model, HttpServletRequest request) {
        String destination;
        if(request.getSession(false)!=null){
            if(request.getSession(false).getAttribute("user")!=null){
                User user = (User) request.getSession().getAttribute("user");
                model.addAttribute("avatar", user.getAvatar());
                model.addAttribute("user", user);
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
    @ResponseBody
    public String connectionSubmit(@RequestParam String email, @RequestParam String password, HttpServletRequest request) {

        if(userRepository.existsUserByEmailAndPassword(email, password)){
            User user = userRepository.findUserByEmailAndPassword(email, password);
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("avatar",user.getAvatar());

            return "success";
        }
        else{
            return "fail";
        }
    }

    /*@PostMapping("/inscription")
    public String addNewUser(@ModelAttribute Connection connection, HttpServletRequest request){
        User n = new User();

        n.setUserName(connection.getUsername());
        n.setPassword(connection.getPassword());
        n.setRandomAvatar();
        n.setEmail(connection.getEmail());
        userRepository.save(n);
        request.getSession().setAttribute("user", n);
        request.getSession().setAttribute("avatar", n.getAvatar());

        UserInfo userInfo = new UserInfo(n);
        userInfoRepository.save(userInfo);


        return "redirect:/profil";
    }*/

    @PostMapping("/inscription")
    @ResponseBody
    public String addNewUser(@RequestParam String password, @RequestParam String passwordV, @RequestParam String email, @RequestParam String userName, HttpServletRequest request){

        final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        boolean isMailCorrect = VALID_EMAIL_ADDRESS_REGEX.matcher(email).matches();

        String result;

        if(isMailCorrect && userRepository.findUserByEmail(email) == null){
            if(password.equals(passwordV)){
                if(userRepository.findUserByUserName(userName)==null && userName.length()<16){
                    User n = new User();
                    UserType nType = userTypeRepository.findUserTypeById(1);

                    n.setUserName(userName);
                    n.setPassword(password);
                    n.setRandomAvatar();
                    n.setEmail(email);
                    n.setUserType(nType);
                    userRepository.save(n);

                    request.getSession().setAttribute("user", n);
                    request.getSession().setAttribute("avatar", n.getAvatar());

                    UserInfo userInfo = new UserInfo(n);
                    userInfoRepository.save(userInfo);
                    result ="done";
                }
                else{
                    result="userName";
                }
            }
            else{
                result = "password";
            }
        }
        else{
            result="mail";
        }
    return result;
    }

    @GetMapping(path="/disconnect")
    public String disconnect(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/accueil";
    }

}