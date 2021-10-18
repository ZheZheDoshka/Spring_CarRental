package com.zhe.carrental.repository;

import com.zhe.carrental.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminCarRepository extends JpaRepository<Car, Long> {
}
