package com.jeffcode.paymentzk8002.service;

import com.jeffcode2020.api.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
