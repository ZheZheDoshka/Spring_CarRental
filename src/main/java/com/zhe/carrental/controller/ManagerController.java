package com.zhe.carrental.controller;

import com.zhe.carrental.model.entity.Car;
import com.zhe.carrental.model.entity.RentForm;
import com.zhe.carrental.model.entity.Ticket;
import com.zhe.carrental.model.enums.ReviewStatus;
import com.zhe.carrental.model.enums.Status;
import com.zhe.carrental.service.ManagerService;
import com.zhe.carrental.service.RentFormService;
import com.zhe.carrental.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class ManagerController {

    @Autowired
    TicketService ticketService;

    @Autowired
    RentFormService rentFormService;

    @Autowired
    ManagerService managerService;

    @GetMapping("/manager_confirm")
    @Secured("ROLE_MANAGER")
    public String home(Model model) {
        List<RentForm> forms = rentFormService.findAllForms();
        model.addAttribute("forms", forms);
        return "manager_confirm";
    }

    @PostMapping("/{id}/ACCEPTED")
    public String StatusAccept(@PathVariable String id){
        Long sId = Long.valueOf(id);
        managerService.changeFormStatus(sId, ReviewStatus.ACCEPTED);
        Ticket ticket = new Ticket();
        ticketService.save(ticket, rentFormService.findById(sId));
        return "redirect:/manager_confirm";
    }

    @PostMapping("/{id}/REJECTED")
    public String StatusReject(@PathVariable String id){
        Long sId = Long.valueOf(id);
        managerService.changeFormStatus(sId, ReviewStatus.REJECTED);
        return "redirect:/manager_confirm";
    }
}
