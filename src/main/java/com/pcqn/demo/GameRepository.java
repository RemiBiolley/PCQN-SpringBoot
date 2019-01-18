package com.pcqn.demo;

import com.pcqn.demo.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Integer> {
    Game findGameById(Integer id);
    List<Game> findAll();
    List<Game> findGameByMomentGame(int momentGame);

    @Query(value = "SELECT g.name FROM Game g")
    List<String> findGamesNames();

    @Query(value="SELECT g FROM Game g WHERE g.name = ?1")
    Game findGameByGameName(@Param("name") String gameName);
}
