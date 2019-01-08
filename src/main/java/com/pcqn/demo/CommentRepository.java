package com.pcqn.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    @Query(value = "SELECT * FROM comment c WHERE c.game_id = :gameId AND c.comment_id IS NULL", nativeQuery = true)
    List<Comment> findAllByGameId(Integer gameId);

    Comment findCommentById(Integer id);

    ArrayList<Comment> findCommentByParentComment(Comment parentComment);
}