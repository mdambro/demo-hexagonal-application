package com.mdambro.demo.application.repository;

import com.mdambro.demo.domain.User;

public interface UserRepository {

    User saveNewUser(User user);

    User findUserByEmail(String id);

}
