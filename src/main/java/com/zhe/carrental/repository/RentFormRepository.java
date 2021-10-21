package com.zhe.carrental.repository;

import com.zhe.carrental.model.entity.RentForm;
import com.zhe.carrental.model.enums.ReviewStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RentFormRepository extends JpaRepository<RentForm, Long> {
    @Modifying
    @Query(value = "UPDATE RentForm u SET u.status = :status where u.id = :id")
    void changeFormStatus(@Param("id") Long id, @Param("status") ReviewStatus status);

}
