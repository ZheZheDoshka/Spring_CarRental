package com.zhe.carrental.service;

import com.zhe.carrental.model.entity.Car;
import com.zhe.carrental.model.entity.RentForm;
import com.zhe.carrental.model.entity.User;

import java.util.List;

public interface RentFormService {

    void save(RentForm rentForm, String username, Long ID, String price);

    List<RentForm> findAllForms();

    RentForm findById(Long id);

    List<RentForm> findFormsByUsername(String Username);
}
