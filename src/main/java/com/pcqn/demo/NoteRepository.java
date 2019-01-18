package com.pcqn.demo;

import com.pcqn.demo.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface NoteRepository extends CrudRepository<Note,Integer> {
    @Query(value = "SELECT note FROM note n WHERE n.user_id= ?1 AND n.game_id= ?2", nativeQuery = true)
    String findNoteByUserAndGame(@Param("user_id") Integer userId, @Param("game_id") Integer gameId);

    @Query(value = "SELECT id FROM note n WHERE n.user_id= ?1 AND n.game_id= ?2", nativeQuery = true)
    Integer findIdNoteByUserAndGame(@Param("user_id") Integer userId, @Param("game_id") Integer gameId);

    @Query(value = "SELECT AVG(note) FROM note n WHERE n.game_id= ?1", nativeQuery = true)
    float calculateNewGameMean(@Param("game_id") Integer gameId);

    Note findNoteById(Integer id);
}
