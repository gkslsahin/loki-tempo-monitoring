package com.hotel.hotelmanager.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ReservationDTO {

    private Long reservationId;
    private String name;
    private String surname;
    private String email;
    private Date checkInDate;
    private Date checkOutDate;


}
