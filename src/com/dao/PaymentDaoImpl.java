package com.dao;
import java.time.*;
import com.model.*;
import com.util.DBUtil;
import java.time.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {
    @Override
    public void recordPayment(Payment payment) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = DBUtil.getDBConn();
            String sql = "INSERT INTO payment (payment_date, amount, lease_id) VALUES (?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1, java.sql.Date.valueOf(payment.getPaymentDate()));
            pstmt.setDouble(2, payment.getAmount());
            pstmt.setInt(3, payment.getLease().getId()); 
            pstmt.executeUpdate();
        }
        catch(Exception e)
        {
        	
        }
    }

	@Override
	public List<Payment> getPaymentsByLeaseId(int leaseId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
