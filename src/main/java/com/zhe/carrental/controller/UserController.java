package com.zhe.carrental.controller;

import com.zhe.carrental.model.DTO.UserDTO;
import com.zhe.carrental.model.entity.User;
import com.zhe.carrental.service.ManagerService;
import com.zhe.carrental.service.SecurityService;
import com.zhe.carrental.service.UserService;
import com.zhe.carrental.validator.UserValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    //admin
    @Autowired
    private ManagerService managerService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }
    //admin
    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @GetMapping("/")
    public String home2(Model model) {
        return "home";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserDTO());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") UserDTO userForm, BindingResult bindingResult) {
        //userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        User user = mapper.map(userForm, User.class);
        userService.save(user);
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if(error != null) {
            model.addAttribute("error","login.error");
        }

        if(logout != null) {
            model.addAttribute("message","login.out");
        }

        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        return "logout";
    }

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
}
