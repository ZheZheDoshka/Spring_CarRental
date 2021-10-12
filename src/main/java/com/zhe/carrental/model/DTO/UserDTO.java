package com.zhe.carrental.model.DTO;

import com.zhe.carrental.model.enums.Roles;
import com.zhe.carrental.model.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private Roles role;
    private Status status;

}
