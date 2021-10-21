package com.zhe.carrental.service;

import com.zhe.carrental.model.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CarService {

    void save(Car car);

    List<Car> findAllCars();

    List<Car> findAllCars(String sort);

    void changeCarStatus(Long Id, String status);
}
