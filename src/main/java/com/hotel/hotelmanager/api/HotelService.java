package com.hotel.hotelmanager.api;

import com.hotel.hotelmanager.model.HotelDTO;
import com.hotel.hotelmanager.model.ImageDTO;
import com.hotel.hotelmanager.model.RoomDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/hotels")
public class HotelService {
    private final WebClient webClient;

    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelDTO> getHotel(@PathVariable Long hotelId){
        log.info("getHotel called -> hotelId: {}",hotelId);


        List imageList = webClient.get()
                .uri("http://localhost:8083/api/images/"+ hotelId )
                .retrieve()
                .bodyToMono(List.class).block();




        RoomDTO rooomDTO = webClient.get()
                .uri("http://localhost:8083/api/rooms/" + hotelId)
                .retrieve()
                .bodyToMono(RoomDTO.class).block();


        log.info("avaible rooms received for: {}",hotelId);

        HotelDTO hotel = HotelDTO.builder().hotelId(hotelId)
                .hotelName("test hotel")
                .images((ArrayList<String>) imageList)
                .totalPrice((long) (rooomDTO.getAvaibleRooms().size() * 115))
                .city("Istanbul")
                .build();


        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }



}
