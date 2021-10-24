package com.zhe.carrental.validator;

import com.zhe.carrental.model.DTO.RentFormDTO;
import com.zhe.carrental.model.DTO.UserDTO;
import com.zhe.carrental.model.entity.RentForm;
import com.zhe.carrental.model.entity.User;
import com.zhe.carrental.service.RentFormService;
import com.zhe.carrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RentFormValidator implements Validator {

    @Autowired
    private RentFormService rentFormService;

    @Override
    public boolean supports(Class<?> clazz) {
        return RentForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RentFormDTO user = (RentFormDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"passport", "passport.required");

    }
}
