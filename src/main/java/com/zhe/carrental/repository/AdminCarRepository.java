package com.zhe.carrental.repository;

import com.zhe.carrental.model.entity.Car;
import com.zhe.carrental.model.enums.CarClass;
import com.zhe.carrental.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminCarRepository extends JpaRepository<Car, Long> {
}
