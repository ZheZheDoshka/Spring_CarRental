package com.zhe.carrental.controller;

import com.zhe.carrental.model.DTO.CarDTO;
import com.zhe.carrental.model.DTO.RentFormDTO;
import com.zhe.carrental.model.DTO.UserDTO;
import com.zhe.carrental.model.entity.Car;
import com.zhe.carrental.model.entity.RentForm;
import com.zhe.carrental.model.entity.User;
import com.zhe.carrental.repository.CarRepository;
import com.zhe.carrental.repository.UserRepository;
import com.zhe.carrental.service.*;
import com.zhe.carrental.validator.UserValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;
    //admin
    @Autowired
    private ManagerService managerService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private RentFormService rentFormService;

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

    @GetMapping("/{id}/rental")
    public String CarEdit(Model model, @PathVariable String id) {
        model.addAttribute("rentForm", new RentFormDTO());
        model.addAttribute("id", id);
        long currentTime=System.currentTimeMillis();
        Date currentDate = new Date(currentTime);
        model.addAttribute("date", currentDate);
        return "rental";
    }

    @PostMapping("/{id}/rental")
    public String CarEdit(Authentication authentication, @ModelAttribute("rentForm") RentFormDTO rentForm,
                          BindingResult bindingResult, @PathVariable String id) {
        Long sId = Long.valueOf(id);
        int dr = 0;
        if (rentForm.getDriver() == "Driver")
        {
            dr = 1;
        }
        long days = TimeUnit.DAYS.convert(rentForm.getToDate().getTime() - rentForm.getFromDate().getTime(), TimeUnit.MILLISECONDS);
        Long price = Long.valueOf( ((int) Double.parseDouble(carRepository.findById(sId).get().getPrice())*100 + dr*4000)/100)*days;
        String username = authentication.getName();
        RentForm rentForm1 = mapper.map(rentForm, RentForm.class);
        rentFormService.save(rentForm1, username, sId, String.valueOf(price));
        //carService.changeCarStatus(sId, "RENTED");
        return "redirect:/home";
    }

    @GetMapping("/usercabinet")
    public String cabinet(Authentication authentication, Model model) {
        List<RentForm> forms = rentFormService.findFormsByUsername(authentication.getName());;
        model.addAttribute("forms", forms);
        return "usercabinet";
    }

}
