package com.pcqn.demo;

import com.pcqn.demo.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note,Integer> {
    @Query(value = "SELECT note FROM note n WHERE n.user_id= ?1 AND n.game_id= ?2", nativeQuery = true)
    String findNoteByUserAndGame(Integer userId, Integer gameId);

    @Query(value = "SELECT id FROM note n WHERE n.user_id= ?1 AND n.game_id= ?2", nativeQuery = true)
    Integer findIdNoteByUserAndGame(Integer userId, Integer gameId);

    /*@Transactional
    @Query(value = "UPDATE note n SET n.note = ?1 WHERE n.id= ?2", nativeQuery = true)
    void updateNote(float newNote, Integer noteId);*/

    @Query(value = "SELECT AVG(note) FROM note n WHERE n.game_id= ?1", nativeQuery = true)
    float calculateNewGameMean(Integer gameId);

    Note findNoteById(Integer id);
}
