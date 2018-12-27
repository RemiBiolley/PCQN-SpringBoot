package com.pcqn.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Integer> {
    Game findGameById(Integer id);
    List<Game> findAll();
    List<Game> findGameByMomentGame(int momentGame);
}
