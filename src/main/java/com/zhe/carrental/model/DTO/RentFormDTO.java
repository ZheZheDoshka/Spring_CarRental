package com.zhe.carrental.model.DTO;

import com.zhe.carrental.model.enums.ReviewStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RentFormDTO {

    private Long id;

    private Long carid;

    private String username;

    private ReviewStatus status;

    private String passport;

    private String price;

    private String driver;

    private Date fromDate;

    private Date toDate;
}
