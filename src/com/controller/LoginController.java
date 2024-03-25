package com.controller;

import com.enums.UserRole;
import com.exception.InvalidChoiceException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginController {
    private Connection connection;

    public LoginController(Connection connection) {
        this.connection = connection;
    }

    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login");
        System.out.println("Enter Username:");
        String username = scanner.nextLine();
        System.out.println("Enter Password:");
        String password = scanner.nextLine();

        try {
            
            PreparedStatement customerStmt = connection.prepareStatement("SELECT * FROM customer WHERE user_name = ? AND password = ?");
            customerStmt.setString(1, username);
            customerStmt.setString(2, password);
            if (customerStmt.executeQuery().next()) {
             
                System.out.println("Customer login successful. Welcome, " + username + "!");
                customerMenu(); 
                return true;
            }
            
            PreparedStatement vendorStmt = connection.prepareStatement("SELECT * FROM vendor WHERE user_name = ? AND password = ?");
            vendorStmt.setString(1, username);
            vendorStmt.setString(2, password);
            if (vendorStmt.executeQuery().next()) {
               
                System.out.println("Vendor login successful. Welcome, " + username + "!");
                vendorMenu(); // Call vendor menu
                return true;
            }

            System.out.println("Invalid username or password.");
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void customerMenu() throws SQLException {
        
    	System.out.println("Customer menu.");
        CustomerController.main(new String[]{});

    }

    public void vendorMenu() throws SQLException {
       
    	System.out.println("Vendor menu.");
        VendorController.main(new String[]{});
    }

    public void signUp(UserRole role) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("***" + role.name() + " Sign Up***");
            if (role == UserRole.CUSTOMER) {
                System.out.println("Enter First Name:");
                String firstName = scanner.next();
                System.out.println("Enter Last Name:");
                String lastName = scanner.next();
                System.out.println("Enter Email:");
                String email = scanner.next();
                System.out.println("Enter Phone Number:");
                String phoneNumber = scanner.next();
                System.out.println("Enter Username:");
                String username = scanner.next();
                System.out.println("Enter Password:");
                String password = scanner.next();

              
                PreparedStatement pstmt = connection.prepareStatement("INSERT INTO customer (first_name, last_name, email, phone_number, user_name, password, role) VALUES (?, ?, ?, ?, ?, ?, ?)");
                pstmt.setString(1, firstName);
                pstmt.setString(2, lastName);
                pstmt.setString(3, email);
                pstmt.setString(4, phoneNumber);
                pstmt.setString(5, username);
                pstmt.setString(6, password);
                pstmt.setString(7, role.name());
                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Customer signed up successfully!");
                    login();
                } else {
                    System.out.println("Failed to sign up customer.");
                }
            } 
            
            else if (role == UserRole.VENDOR) {
                System.out.println("Enter First Name:");
                String firstName = scanner.next();
                System.out.println("Enter Last Name:");
                String lastName = scanner.next();
                System.out.println("Enter Email:");
                String email = scanner.next();
                System.out.println("Enter Phone Number:");
                String phoneNumber = scanner.next();
                System.out.println("Enter Username:");
                String username = scanner.next();
                System.out.println("Enter Password:");
                String password = scanner.next();
                System.out.println("Enter Vehicle ID:");
                int vehicleId = scanner.nextInt();

                PreparedStatement pstmt = connection.prepareStatement("INSERT INTO vendor (vehicle_id, first_name, last_name, email, phone_number, user_name, password, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                pstmt.setInt(1, vehicleId);
                pstmt.setString(2, firstName);
                pstmt.setString(3, lastName);
                pstmt.setString(4, email);
                pstmt.setString(5, phoneNumber);
                pstmt.setString(6, username);
                pstmt.setString(7, password);
                pstmt.setString(8, role.name());
                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Vendor signed up successfully!");
                    login();
                } else {
                    System.out.println("Failed to sign up vendor.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental", "root", "");

            LoginController loginController = new LoginController(connection);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Select option:");
            System.out.println("1. Customer Sign Up");
            System.out.println("2. Vendor Sign Up");
            System.out.println("3. Login");
            System.out.println("4. Lease");
            System.out.println("5. Payment");
            System.out.println("6. Exit");
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    loginController.signUp(UserRole.CUSTOMER);
                    break;
                case 2:
                    loginController.signUp(UserRole.VENDOR);
                    break;
                case 3:
                 
                    loginController.login();
                    break;
                case 4:
                	System.out.println("*****Lease*****");
				try {
					LeaseController.main(new String[]{});
				} catch (InvalidChoiceException e) {
					
					e.printStackTrace();
				}
                case 5:
                	System.out.println("*****Payment*****");
                	PaymentController.main(new String[]{});
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
