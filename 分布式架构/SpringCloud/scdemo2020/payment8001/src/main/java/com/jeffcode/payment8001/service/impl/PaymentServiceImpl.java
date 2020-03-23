package com.jeffcode.payment8001.service.impl;

import com.jeffcode.payment8001.dao.PaymentDao;
import com.jeffcode.payment8001.service.PaymentService;
import com.jeffcode2020.api.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        log.info("provider id is {}", id);
        return paymentDao.getPaymentById(id);
    }
}
