package com.adu21.ddd.service;

import com.adu21.ddd.domain.User;

public interface UserService {

    boolean userExist(User user);

    boolean saveUser(User user);
}