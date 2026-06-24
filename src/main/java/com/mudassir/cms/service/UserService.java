package com.mudassir.cms.service;

import com.mudassir.cms.entity.User;

public interface UserService {

    User registerUser(User user);

    User findByEmail(String email);
}