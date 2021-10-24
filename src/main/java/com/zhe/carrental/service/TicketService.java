package com.zhe.carrental.service;

import com.zhe.carrental.model.entity.RentForm;
import com.zhe.carrental.model.entity.Ticket;
import com.zhe.carrental.model.entity.User;
import com.zhe.carrental.model.enums.Status;

import java.util.List;

public interface TicketService {
    void save(Ticket ticket, RentForm form);

    List<Ticket> findTicketsByUsername(String Username);

    void changeTicketStatus(Long id, Status status);
}
