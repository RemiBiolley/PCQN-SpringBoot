package com.pcqn.demo;

import com.pcqn.demo.UserType;
import org.springframework.data.repository.CrudRepository;

public interface UserTypeRepository extends CrudRepository<UserType, Integer> {
    UserType findUserTypeById(Integer id);
}
