package com.pcqn.demo;

import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note,Integer> {
}
