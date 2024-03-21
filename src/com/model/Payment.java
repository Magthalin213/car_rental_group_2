package com.model;

import java.time.LocalDate;

public class Payment {
	private int id;
	private Lease lease;
	private LocalDate paymentDate;
	private double amount;
	
	public Payment() {
		super();
		
	}

	public Payment(int id, Lease lease, LocalDate paymentDate, double amount) {
		super();
		this.id = id;
		this.lease = lease;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Lease getLease() {
		return lease;
	}

	public void setLease(Lease lease) {
		this.lease = lease;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	

	
	
	
	
	
}
