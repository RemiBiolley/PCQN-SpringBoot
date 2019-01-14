package com.pcqn.demo;

import org.springframework.data.repository.CrudRepository;

import com.pcqn.demo.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    Boolean existsUserByEmailAndPassword(String email, String password);
    User findUserByEmailAndPassword(String email, String password);
    User findUserByEmail(String email);
    User findUserByUserName(String userName);
    User findUserById(Integer id);
    List<User> findAll();

    void delete(User user);
}
