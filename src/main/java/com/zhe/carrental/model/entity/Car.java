package com.zhe.carrental.model.entity;

import com.zhe.carrental.model.enums.CarClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*; //wow, nice feature!

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private String price;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "class")
    private CarClass class_;

}