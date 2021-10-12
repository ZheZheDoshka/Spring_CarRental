package com.zhe.carrental.service;

import com.zhe.carrental.model.entity.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    void deleteById(Long id);
}
