package com.zhe.carrental.service;

import com.zhe.carrental.model.entity.User;
import com.zhe.carrental.model.enums.ReviewStatus;

public interface ManagerService {

    void save(User user);

    User findByUsername(String username);

    void changeFormStatus(Long id, ReviewStatus status);
}
