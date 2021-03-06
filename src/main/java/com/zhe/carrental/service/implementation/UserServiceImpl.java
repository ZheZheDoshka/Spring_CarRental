package com.zhe.carrental.service.implementation;


import com.zhe.carrental.model.entity.Car;
import com.zhe.carrental.model.entity.User;
import com.zhe.carrental.model.enums.Role;
import com.zhe.carrental.model.enums.Status;
import com.zhe.carrental.repository.CarRepository;
import com.zhe.carrental.repository.UserRepository;
import com.zhe.carrental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setStatus(Status.PERMITTED);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }



    /**/
}
