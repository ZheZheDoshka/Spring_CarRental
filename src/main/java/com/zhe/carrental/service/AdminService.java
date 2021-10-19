package com.zhe.carrental.service;

import com.zhe.carrental.model.entity.Car;
import com.zhe.carrental.model.entity.User;
import com.zhe.carrental.model.enums.CarClass;
import com.zhe.carrental.model.enums.Status;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService {

    void deleteCarById(Long id);

    List<User> findAllUsers();

    void updateStatus(Long id, Status status);

    void updateCar(Long id, String model, String brand, CarClass class_, String price);
}
