package com.jeffcode.paymentzk8002.service.impl;

import com.jeffcode.paymentzk8002.dao.PaymentDao;
import com.jeffcode.paymentzk8002.service.PaymentService;
import com.jeffcode2020.api.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
