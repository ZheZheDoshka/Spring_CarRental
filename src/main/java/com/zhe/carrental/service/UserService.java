package com.zhe.carrental.service;

import com.zhe.carrental.model.entity.Car;
import com.zhe.carrental.model.entity.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    List<Car> findAllCars();

    List<Car> findAllCars(String sort);

}
