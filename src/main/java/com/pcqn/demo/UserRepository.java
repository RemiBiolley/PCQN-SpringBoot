package com.pcqn.demo;

import org.springframework.data.repository.CrudRepository;

import com.pcqn.demo.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
