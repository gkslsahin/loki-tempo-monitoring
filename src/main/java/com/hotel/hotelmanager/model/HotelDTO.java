package com.hotel.hotelmanager.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class HotelDTO {
    private Long hotelId;
    private String hotelName;
    private String city;
    private ArrayList<String> images;
    private Long totalPrice;
}
