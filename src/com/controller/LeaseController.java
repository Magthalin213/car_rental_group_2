package com.controller;

import java.sql.Date;
import java.sql.SQLException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.exception.InvalidChoiceException;
import com.model.Lease;
import com.service.LeaseService;

public class LeaseController {

	public static void main(String[] args) throws InvalidChoiceException, SQLException {
		Scanner sc=new Scanner(System.in);
		LeaseService leaseService=new LeaseService();
		while (true) {
			System.out.println("******** Lease OPS ********");
			System.out.println("Press 1. To Display all Lease Details");
			System.out.println("Press 2. To Recieve a Lease Detail using ID");
			System.out.println("Press 3. To Add Lease");
			System.out.println("Press 4. To List the Active Lease");
			System.out.println("Press 5. To change the vehicle status by ID");
			System.out.println("Press 6. To check the number of times a vehicle has been booked by id");
			System.out.println("Press 0 for exit");
			System.out.println("****************************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting...Thank You!!!");
				break;
			}
			switch(input)
			{
			case 1:
				System.out.println("*******All Lease Details*******");
				try
				{
					List<Lease> lease=leaseService.returnCar();
					for( Lease l: lease)
						System.out.println(l);
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				Lease lease;
				break;
			case 2:
				System.out.println("********Single Lease Detail********");
				System.out.println("Enter Lease ID: ");
				int id = sc.nextInt();
				try {
					Lease lease1 = leaseService.getLeaseById(id);
					System.out.println(lease1);
				} catch (NullPointerException | SQLException e) {
					e.printStackTrace();
				} 
				Lease lease1;
				break;
			case 3:
				System.out.println("**********Adding New Lease Details**********");
				
				System.out.println("Enter Vehicle ID: ");
				int vehicleId=sc.nextInt();
				
				System.out.println("Enter Customer ID: ");
				int customerId=sc.nextInt();

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				System.out.println("Enter the starting Date of Lease (YYYY-MM-DD): ");
				sc.nextLine();
				String start=sc.nextLine();
				LocalDate sdate= LocalDate.parse(start, formatter);
				Date startDate=java.sql.Date.valueOf(sdate);
				
				
				System.out.println("Enter the Ending Date of Lease (YYYY-MM-DD): ");
				String end=sc.nextLine();
				LocalDate edate= LocalDate.parse(end, formatter);
				Date endDate = java.sql.Date.valueOf(edate);
				
				System.out.println("Choose the Type of Lease:\n1. Daily Lease\n2. Monthly Lease");
				int choice = sc.nextInt();
		        String selectedOption;
				if(choice == 1)
		        	selectedOption = "DailyLease";
				else if (choice == 2)
					selectedOption = "MonthlyLease";
				else
					throw new InvalidChoiceException("Invalid choice has been made");
		        leaseService.addLease(vehicleId,customerId,startDate,endDate,selectedOption);
		      	break;
			case 4:
				System.out.println("*********All Active Leases*********");
				try {
					List<Lease> list=leaseService.getActiveLease();
					for( Lease l: list)
						System.out.println(l);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				
				break;
			case 6:
				break;
			default :
				break;
			}

		}
	}
}
