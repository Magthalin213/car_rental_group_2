package com.dao;

import com.model.Payment;

import java.sql.SQLException;
import java.util.List;

public interface PaymentDao {
    void recordPayment(Payment payment) throws SQLException;
    List<Payment> getPaymentsByLeaseId(int leaseId) throws SQLException;
}
