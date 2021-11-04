package com.zhe.carrental.service;

import com.zhe.carrental.model.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CarService {

    void save(Car car);

    List<Car> findAllCars();

    List<Car> findAllCars(String sort);

    Page<Car> findAllCars(String sort, Pageable pageable);

    void changeCarStatus(Long Id, String status);
}
