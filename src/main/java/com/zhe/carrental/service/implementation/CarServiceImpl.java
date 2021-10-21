package com.zhe.carrental.service.implementation;

import com.zhe.carrental.model.entity.Car;
import com.zhe.carrental.repository.CarRepository;
import com.zhe.carrental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void save(Car car) {
        car.setStatus("AVAILABLE");
        carRepository.save(car);
    }

    @Override
    public List<Car> findAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    @Override
    public List<Car> findAllCars(String sort) {
        if(sort != null){
            return carRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, sort));
        }
        return findAllCars();
    }

    @Override
    @Transactional
    public void changeCarStatus(Long Id, String status) {
        carRepository.changeCarStatus(Id, status);
    }
}
