package com.zhe.carrental.repository;

import com.zhe.carrental.model.entity.Car;
import com.zhe.carrental.model.enums.ReviewStatus;
import com.zhe.carrental.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Modifying
    @Query(value = "UPDATE RentForm u SET u.status = :status where u.id = :id")
    void changeFormStatus(@Param("id") Long id, @Param("status") ReviewStatus status);

}
