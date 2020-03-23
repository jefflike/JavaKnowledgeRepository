package com.jeffcode2020.order80.service;

import com.jeffcode2020.api.entities.Payment;
//import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(value = "provider-payment8001")
public interface PaymentService {

    @PostMapping(value = "/payment/create")
    int create(Payment payment);

    @GetMapping(value = "payment/get/{id}")
    Payment getPaymentById(@PathVariable("id") Long id);
}
