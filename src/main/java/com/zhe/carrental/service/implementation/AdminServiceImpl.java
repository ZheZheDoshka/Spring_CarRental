package com.zhe.carrental.service.implementation;

import com.zhe.carrental.model.entity.User;
import com.zhe.carrental.repository.UserRepository;
import com.zhe.carrental.service.AdminService;

import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    @Override
    public List<User> findAll() {
        List<User> users = UserRepository.findAll();
        return users;
    }
}
