package com.zhe.carrental.validator;

import com.zhe.carrental.model.entity.User;
import com.zhe.carrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if((user.getUsername().length() < 2)||(user.getUsername().length()>32))
            errors.rejectValue("username","login.invalid.username");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username", "login.required");

        if(userService.findByUsername(user.getUsername())!=null){
            errors.rejectValue("username", "login.repeating.username");
        }

        if((user.getPassword().length() < 8)||(user.getPassword().length()>32))
            errors.rejectValue("password","login.invalid.password");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "login.required");

    }
}
