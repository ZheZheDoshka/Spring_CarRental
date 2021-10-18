package com.zhe.carrental.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RentFormDTO {

    private Long id;

    private String model;

    private String username;

    private String passport;

    private String price;
}
