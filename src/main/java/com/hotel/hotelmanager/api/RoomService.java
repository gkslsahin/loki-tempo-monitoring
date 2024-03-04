package com.hotel.hotelmanager.api;

import com.hotel.hotelmanager.model.RoomDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/rooms")
public class RoomService {

    @GetMapping("/{hotelId}")
    public ResponseEntity avaibleRoom(@PathVariable Long hotelId){
        log.info("avaibleRoom called -> hotelId: {}",hotelId);
        Random random = new Random();
        RoomDTO roomDTO = RoomDTO.builder().hotelId(hotelId)
                .avaibleRooms((ArrayList<Integer>) IntStream.range(0, random.nextInt(0,15))
                        .map(i -> random.nextInt())
                        .boxed()
                        .collect(Collectors.toList())).build();

        if (roomDTO.getAvaibleRooms().size() > 5){
            log.info("available room size is higher than 5");
        }else {
            log.info("there are few vacant rooms");

        }


        return new ResponseEntity(roomDTO, HttpStatus.OK);

    }
}
