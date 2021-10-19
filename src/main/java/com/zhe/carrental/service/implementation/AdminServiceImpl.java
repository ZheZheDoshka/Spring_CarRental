package com.zhe.carrental.service.implementation;

import com.zhe.carrental.model.entity.Car;
import com.zhe.carrental.model.entity.User;
import com.zhe.carrental.model.enums.CarClass;
import com.zhe.carrental.model.enums.Status;
import com.zhe.carrental.repository.AdminCarRepository;
import com.zhe.carrental.repository.AdminUserRepository;
import com.zhe.carrental.repository.UserRepository;
import com.zhe.carrental.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AdminUserRepository adminUserRepository;

    @Autowired
    AdminCarRepository adminCarRepository;

    @Override
    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public void deleteCarById(Long id) {
        adminCarRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateStatus(Long id, Status status) {
        adminUserRepository.changeUserStatus(id ,status);
    }

    @Override
    @Transactional
    public void updateCar(Long id, String model, String brand, CarClass class_, String price) {
        adminCarRepository.changeUserStatus(id, model, brand, class_, price);
    }
}
