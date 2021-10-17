package com.zhe.carrental.model.DTO;

import com.zhe.carrental.model.enums.CarClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CarDTO {

    private Long id;
    private String brand;
    private String model;
    private String price;
    private CarClass class_;

}
