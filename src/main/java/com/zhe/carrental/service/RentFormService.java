package com.zhe.carrental.service;

import com.zhe.carrental.model.entity.RentForm;
import com.zhe.carrental.model.entity.User;

public interface RentFormService {

    void save(RentForm rentForm, String username, Long ID, String price);
}
