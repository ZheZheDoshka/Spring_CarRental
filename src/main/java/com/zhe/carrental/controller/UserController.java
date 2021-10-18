package com.zhe.carrental.controller;

import com.zhe.carrental.model.DTO.UserDTO;
import com.zhe.carrental.model.entity.Car;
import com.zhe.carrental.model.entity.User;
import com.zhe.carrental.repository.UserRepository;
import com.zhe.carrental.service.CarService;
import com.zhe.carrental.service.ManagerService;
import com.zhe.carrental.service.SecurityService;
import com.zhe.carrental.service.UserService;
import com.zhe.carrental.validator.UserValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @Autowired
    private UserRepository userRepository;
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
        List<Car> cars = carService.findAllCars();
        model.addAttribute("cars", cars);
        return "home";
    }


    @GetMapping("/")
    public String home2(Model model) {
        List<Car> cars = carService.findAllCars();
        model.addAttribute("cars", cars);
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


}
