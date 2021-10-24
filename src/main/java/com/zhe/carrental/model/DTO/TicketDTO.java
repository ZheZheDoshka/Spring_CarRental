package com.zhe.carrental.model.DTO;
import com.zhe.carrental.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TicketDTO {
    Long id;
    Long carid;
    String reason;
    String cardnumber;
    Long price;
    String username;
    Status status;
}
