package com.zhe.carrental.service;

import com.zhe.carrental.model.entity.User;

public interface ManagerService {

    void save(User user);

    User findByUsername(String username);
}
