package com.pcqn.demo;

import org.springframework.data.repository.CrudRepository;

import com.pcqn.demo.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    Boolean existsUserByEmailAndPassword(String email, String password);
    User findUserByEmailAndPassword(String email, String password);
    User findUserById(Integer id);
}
