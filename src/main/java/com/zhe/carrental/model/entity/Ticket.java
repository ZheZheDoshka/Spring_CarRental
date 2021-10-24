package com.zhe.carrental.model.entity;
import com.zhe.carrental.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "carid")
    Long carid;

    @Column(name = "reason")
    String reason;

    @Column(name = "cardnumber")
    String cardnumber;

    @Column(name = "price")
    Long price;

    @Column(name = "username")
    String username;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    Status status;
}
