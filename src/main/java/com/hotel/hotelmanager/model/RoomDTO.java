package com.hotel.hotelmanager.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.ArrayList;

@Data
@Builder
public class RoomDTO {

    private Long hotelId;
    private ArrayList<Integer> avaibleRooms;

}
