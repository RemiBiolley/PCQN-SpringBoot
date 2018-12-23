package com.pcqn.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pcqn.demo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    Boolean existsUserByEmailAndPassword(String email, String password);
    User findUserByEmailAndPassword(String email, String password);
}
