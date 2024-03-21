package com.service;

import com.dao.PaymentDao;
import com.dao.PaymentDaoImpl;
import com.model.Payment;

import java.sql.SQLException;
import java.util.List;

public class PaymentService {
    private PaymentDao paymentDao = new PaymentDaoImpl();

    public void recordPayment(Payment payment) throws SQLException {
        paymentDao.recordPayment(payment);
    }

    public List<Payment> getPaymentsByLeaseId(int leaseId) throws SQLException {
        return paymentDao.getPaymentsByLeaseId(leaseId);
    }
}
