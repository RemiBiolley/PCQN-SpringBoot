package com.pcqn.demo.web.controller;

import com.pcqn.demo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    GameRepository gameRepository;

    @PostMapping("/comment")
    @ResponseBody
    public void addComment(@RequestParam String commentContent, @RequestParam Integer gameId, HttpServletRequest request){
        Comment comment = new Comment();

        comment.setContent(commentContent);

        User commentUser = (User) request.getSession().getAttribute("user");
        comment.setUser(commentUser);

        Game commentGame = gameRepository.findGameById(gameId);
        comment.setGame(commentGame);

        comment.setDate(LocalDateTime.now());

        commentRepository.save(comment);
    }
}
