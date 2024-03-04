package com.hotel.hotelmanager.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentDTO {

    boolean paymentResult;
    Long totalPaid;


}
