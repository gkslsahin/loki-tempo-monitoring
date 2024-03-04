package com.hotel.hotelmanager.api;

import com.hotel.hotelmanager.model.EmailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/email")
public class EmailService {

    @PostMapping("/send")
    public ResponseEntity sendEmail(@RequestBody EmailDTO emailDTO){
        log.info("sendEmail called");
        log.info("email sended to:{}", emailDTO.getEmail());


        return new ResponseEntity(emailDTO, HttpStatus.OK);
    }


}
