package com.zhe.carrental.repository;

import com.zhe.carrental.model.entity.User;
import com.zhe.carrental.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminUserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query(value = "UPDATE User u SET u.status = :status where u.id = :id")
    void changeUserStatus(@Param("id") Long id, @Param("status") Status status);


}
