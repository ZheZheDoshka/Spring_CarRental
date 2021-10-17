package com.zhe.carrental.controller;

import com.zhe.carrental.model.DTO.UserDTO;
import com.zhe.carrental.model.entity.User;
import com.zhe.carrental.model.enums.Status;
import com.zhe.carrental.service.AdminService;
import com.zhe.carrental.service.ManagerService;
import com.zhe.carrental.service.SecurityService;
import com.zhe.carrental.service.UserService;
import com.zhe.carrental.service.implementation.AdminServiceImpl;
import com.zhe.carrental.validator.UserValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@PreAuthorize("hasRole('ADMIN')")
//@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AdminService adminService;

    //admin
    @GetMapping("/registration_manager")
    public String manager_registration(Model model) {
        model.addAttribute("userForm", new UserDTO());
        return "registration_manager";
    }

    @PostMapping("/registration_manager")
    public String manager_registration(@ModelAttribute("userForm") UserDTO userForm, BindingResult bindingResult) {
        //userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration_manager";
        }
        User user = mapper.map(userForm, User.class);
        managerService.save(user);
        return "redirect:/home";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @GetMapping("usercontrol")
    public String usercontrol(Model model) {
        List<User> users = adminService.findAllUsers();
        model.addAttribute("users", users);
        return "usercontrol";
    }

    @PostMapping("/{id}/permit")
    public String StatusPermit(@PathVariable Long id){

        adminService.updateStatus(id, Status.PERMITTED);
        return "redirect:/usercontrol";
    }

    @PostMapping("/{id}/ban")
    public String StatusBanned(@PathVariable Long id){

        adminService.updateStatus(id, Status.BANNED);
        return "redirect:/usercontrol";
    }
}
