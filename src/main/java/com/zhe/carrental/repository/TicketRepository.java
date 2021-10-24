package com.zhe.carrental.repository;

import com.zhe.carrental.model.entity.RentForm;
import com.zhe.carrental.model.entity.Ticket;
import com.zhe.carrental.model.enums.ReviewStatus;
import com.zhe.carrental.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Modifying
    @Query(value = "UPDATE Ticket u SET u.status = :status where u.id = :id")
    void changeTicket(@Param("id") Long id, @Param("status") Status status);
}
