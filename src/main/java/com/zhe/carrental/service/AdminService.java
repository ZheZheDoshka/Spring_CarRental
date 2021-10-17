package com.zhe.carrental.service;

import com.zhe.carrental.model.entity.Car;
import com.zhe.carrental.model.entity.User;
import com.zhe.carrental.model.enums.Status;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService {

    List<User> findAllUsers();
    void updateStatus(Long id, Status status);
}
