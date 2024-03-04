package com.hotel.hotelmanager.api;

import com.hotel.hotelmanager.model.PaymentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentService {
    @GetMapping("/{price}")
    public ResponseEntity processPayment(@PathVariable Long price) throws InterruptedException {
        Thread.sleep(3000);
        log.info("processPayment called -> total payment: {}",price);

        PaymentDTO paymentDTO = PaymentDTO.builder().paymentResult(true)
                .totalPaid(price).build();

        //TODO pamyment

        return new ResponseEntity(paymentDTO, HttpStatus.OK);


    }
}
