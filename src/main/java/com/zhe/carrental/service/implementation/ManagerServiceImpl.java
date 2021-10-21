package com.zhe.carrental.service.implementation;

import com.zhe.carrental.model.entity.User;
import com.zhe.carrental.model.enums.ReviewStatus;
import com.zhe.carrental.model.enums.Role;
import com.zhe.carrental.model.enums.Status;
import com.zhe.carrental.repository.RentFormRepository;
import com.zhe.carrental.repository.UserRepository;
import com.zhe.carrental.service.ManagerService;
import com.zhe.carrental.service.RentFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RentFormService rentFormService;

    @Autowired
    private RentFormRepository rentFormRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(Role.MANAGER);
        user.setStatus(Status.PERMITTED);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void changeFormStatus(Long id, ReviewStatus status) {
        rentFormRepository.changeFormStatus(id, status);
    }
}
