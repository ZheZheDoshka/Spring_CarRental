package com.zhe.carrental.model.entity;

import com.zhe.carrental.model.enums.CarClass;
import com.zhe.carrental.model.enums.ReviewStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="rentform")
public class RentForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "carid")
    private Long carid;

    @Column(name = "username")
    private String username;

    @Column(name = "passport")
    private String passport;

    @Column(name = "price")
    private String price;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private ReviewStatus status;

    @Column(name="driver")
    private String driver;
}
