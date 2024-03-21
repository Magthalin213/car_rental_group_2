package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import com.model.Lease;
import com.model.Payment;
import com.service.LeaseService;
import com.service.PaymentService;

public class PaymentController {
    private PaymentService paymentService;
    private LeaseService leaseService;
    private Scanner scanner;

    public PaymentController() {
        this.paymentService = new PaymentService();
        this.leaseService = new LeaseService();
        this.scanner = new Scanner(System.in);
    }

    public void paymentMenu() {
        int choice;

        do {
            System.out.println("Payment Menu:");
            System.out.println("1. Record a Payment");
            System.out.println("2. Exit");
            System.out.println("Enter your choice:");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    recordPayment();
                    break;
                case 2:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 2);

        scanner.close();
    }

    public void recordPayment() {
        System.out.println("Enter Lease ID:");
        int leaseId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.println("Enter Payment Amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        try {
            Lease lease = leaseService.getLeaseById(leaseId);
            if (lease != null) {
                Payment payment = new Payment();
                payment.setPaymentDate(LocalDate.now());
                payment.setAmount(amount);
                payment.setLease(lease);

                paymentService.recordPayment(payment);
                System.out.println("Payment recorded successfully!");
            } else {
                System.out.println("Lease not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while recording payment: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        PaymentController paymentController = new PaymentController();
        paymentController.paymentMenu();
    }
}
