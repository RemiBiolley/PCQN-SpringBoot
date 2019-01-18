package com.pcqn.demo;

import com.pcqn.demo.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    @Query(value = "SELECT * FROM comment c WHERE c.game_id = :gameId AND c.comment_id IS NULL", nativeQuery = true)
    List<Comment> findAllByGameId(@Param("gameId") Integer gameId);

    Comment findCommentById(Integer id);

    ArrayList<Comment> findCommentByParentComment(Comment parentComment);
}
