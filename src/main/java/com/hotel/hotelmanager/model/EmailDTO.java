package com.hotel.hotelmanager.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailDTO {
    private String email;
    private String name;
    private String surname;
    private Long totalPrice;
}
