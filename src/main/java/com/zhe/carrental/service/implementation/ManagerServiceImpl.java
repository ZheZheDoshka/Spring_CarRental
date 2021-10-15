package com.zhe.carrental.service.implementation;

import com.zhe.carrental.model.entity.User;
import com.zhe.carrental.model.enums.Role;
import com.zhe.carrental.model.enums.Status;
import com.zhe.carrental.repository.UserRepository;
import com.zhe.carrental.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(Role.MANAGER);
        user.setStatus(Status.Not_banned);
        userRepository.save(user);
    }
}
