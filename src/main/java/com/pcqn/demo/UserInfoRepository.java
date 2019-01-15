package com.pcqn.demo;

import com.pcqn.demo.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {
    UserInfo findAllByUserId(Integer userId);
}
