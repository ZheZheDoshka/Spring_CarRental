package com.zhe.carrental.service.implementation;

import com.zhe.carrental.model.entity.RentForm;
import com.zhe.carrental.model.entity.Ticket;
import com.zhe.carrental.model.enums.Status;
import com.zhe.carrental.repository.CarRepository;
import com.zhe.carrental.repository.TicketRepository;
import com.zhe.carrental.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void save(Ticket ticket, RentForm form) {
        ticket.setUsername(form.getUsername());
        ticket.setPrice(Long.valueOf(form.getPrice()));
        ticket.setStatus(Status.UNPAYED);
        ticket.setCarid(form.getCarid());
        ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> findTicketsByUsername(String Username) {
        List<Ticket> tickets = new ArrayList<Ticket>();
        List<Ticket> alltickets = ticketRepository.findAll();
        for (int i = 0; i<alltickets.size(); i++)
        {
            if (alltickets.get(i).getUsername().equals(Username))
            {
                tickets.add(alltickets.get(i));
            }
        }
        return tickets;
    }

    @Override
    public void changeTicketStatus(Long id, Status status) {
        ticketRepository.changeTicket(id, status);
    }
}
