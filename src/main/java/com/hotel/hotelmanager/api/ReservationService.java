package com.hotel.hotelmanager.api;

import com.hotel.hotelmanager.model.EmailDTO;
import com.hotel.hotelmanager.model.HotelDTO;
import com.hotel.hotelmanager.model.PaymentDTO;
import com.hotel.hotelmanager.model.ReservationDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationService {

    private final WebClient webClient;

    @PostMapping("/create")
    public ResponseEntity<ReservationDTO> makeReservation(@RequestBody ReservationDTO reservationDTO){
        log.info("makeReservation called -> reservationId: {}",reservationDTO.getReservationId());

        //TODO reservation data ile if else ile bir log ekle
        log.info("check-in:{},  check-out:{}",reservationDTO.getCheckInDate(),reservationDTO.getCheckOutDate());

        HotelDTO hotelDTO = webClient.get()
                .uri("http://localhost:8083/api/hotels/333")
                .retrieve()
                .bodyToMono(HotelDTO.class).block();


        Long totalPrice = hotelDTO.getTotalPrice();

        PaymentDTO paymentDTO = webClient.get()
                .uri("http://localhost:8083/api/payment/" + totalPrice)
                .retrieve()
                .bodyToMono(PaymentDTO.class).block();

        log.info("Total price:{}",paymentDTO.getTotalPaid());


        EmailDTO emailDTO = EmailDTO.builder()
                .email("testmail.@outlook.com")
                .name("testname")
                .surname("test1")
                .totalPrice(totalPrice)
                .build();


        webClient.post()
                .uri("http://localhost:8083/api/email/send")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(emailDTO))
                .retrieve()
                .bodyToMono(PaymentDTO.class).block();


        return new ResponseEntity<>(reservationDTO, HttpStatus.OK);


    }
}
