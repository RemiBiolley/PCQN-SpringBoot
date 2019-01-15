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

    @Autowired
    UserRepository userRepository;

    @PostMapping("/comment")
    @ResponseBody
    public void addComment(@RequestParam String commentContent, @RequestParam Integer gameId, HttpServletRequest request){
        Comment comment = new Comment();

        comment.setContent(commentContent);

        User commentUser = (User) request.getSession().getAttribute("user");
        User userDB = userRepository.findUserById(commentUser.getId());
        comment.setUser(userDB);

        Game commentGame = gameRepository.findGameById(gameId);
        comment.setGame(commentGame);

        comment.setDate(LocalDateTime.now());

        commentRepository.save(comment);

        userDB.setPoints(userDB.getPoints()+2);
        userDB.checkRank();

        userRepository.save(userDB);

        request.getSession().setAttribute("user", userDB);
    }

    @PostMapping("/response")
    @ResponseBody
    public void addResponse(@RequestParam String responseContent, @RequestParam Integer gameId, @RequestParam Integer respondedCommentId, HttpServletRequest request){
        Comment response = new Comment();
        response.setContent(responseContent);

        User commentUser = (User) request.getSession().getAttribute("user");
        User userDB = userRepository.findUserById(commentUser.getId());
        response.setUser(userDB);

        Game commentGame = gameRepository.findGameById(gameId);
        response.setGame(commentGame);

        response.setDate(LocalDateTime.now());

        response.setParentComment(commentRepository.findCommentById(respondedCommentId));

        commentRepository.save(response);

        userDB.setPoints(userDB.getPoints()+2);
        userDB.checkRank();

        userRepository.save(userDB);

        request.getSession().setAttribute("user", userDB);
    }

    @PostMapping("/eraseComment")
    @ResponseBody
    public void eraseComment(@RequestParam Integer commentId){
        Comment erasedComment = commentRepository.findCommentById(commentId);
        commentRepository.delete(erasedComment);
    }
}
