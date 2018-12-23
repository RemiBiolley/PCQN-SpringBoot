package com.pcqn.demo;

import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {
    Game findGameById(Integer id);
}
