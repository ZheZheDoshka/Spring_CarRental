package com.zhe.carrental.controller;

import com.zhe.carrental.model.DTO.CarDTO;
import com.zhe.carrental.model.DTO.UserDTO;
import com.zhe.carrental.model.entity.Car;
import com.zhe.carrental.model.entity.User;
import com.zhe.carrental.model.enums.Status;
import com.zhe.carrental.service.*;
import com.zhe.carrental.service.implementation.AdminServiceImpl;
import com.zhe.carrental.validator.CarValidator;
import com.zhe.carrental.validator.UserValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@PreAuthorize("hasRole('ADMIN')")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private CarService carService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private CarValidator carValidator;

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
//@Secured("ROLE_ADMIN")

    @PostMapping("/registration_manager")
    public String manager_registration(@ModelAttribute("userForm") UserDTO userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
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
    public String StatusPermit(@PathVariable String id){
        Long sId = Long.valueOf(id);
        adminService.updateStatus(sId, Status.PERMITTED);
        return "redirect:/usercontrol";
    }

    @PostMapping("/{id}/ban")
    public String StatusBanned(@PathVariable String id){
        Long sId = Long.valueOf(id);
        adminService.updateStatus(sId, Status.BANNED);
        return "redirect:/usercontrol";
    }

    @GetMapping("/ucarcontrol")
    public String carcontrol(Model model) {
        List<Car> cars = carService.findAllCars();
        model.addAttribute("cars", cars);
        return "ucarcontrol";
    }

    @GetMapping("/ucaradd")
    public String caradd(Model model) {
        model.addAttribute("carForm", new CarDTO());
        return "ucaradd";
    }

    @PostMapping("/ucaradd")
    public String caradd(@ModelAttribute("carForm") CarDTO carForm, BindingResult bindingResult) {
        //userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "ucaradd";
        }
        Car car = mapper.map(carForm, Car.class);
        carService.save(car);
        return "redirect:/ucarcontrol";
    }

    @PostMapping("/{id}/delete")
    public String CarDelete(@PathVariable String id){
        Long sId = Long.valueOf(id);
        adminService.deleteCarById(sId);
        return "redirect:/ucarcontrol";
    }

    @GetMapping("/{id}/caredit")
    public String CarEdit(Model model, @PathVariable String id) {
        model.addAttribute("carForm", new CarDTO());
        model.addAttribute("id", id);
        return "ucaredit";


    }

    @PostMapping("/{id}/caredit")
    public String CarEdit(@ModelAttribute("carForm") CarDTO carForm, BindingResult bindingResult, @PathVariable String id){
        Long sId = Long.valueOf(id);
        //adminService.updateCar(sId, carForm.getModel(), carForm.getBrand(), carForm.getClass_(), carForm.getPrice());
        carValidator.validate(carForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/{id}/caredit";
        }
        adminService.deleteCarById(sId);
        if (bindingResult.hasErrors()) {
            return "ucaredit";
        }
        Car car = mapper.map(carForm, Car.class);
        car.setId(sId);
        carService.save(car);
        return "redirect:/ucarcontrol";
    }
}
