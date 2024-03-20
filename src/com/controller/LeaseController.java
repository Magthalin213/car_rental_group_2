package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Lease;
import com.service.LeaseService;

public class LeaseController {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		LeaseService ls=new LeaseService();
		while (true) {
			System.out.println("******** Lease OPS ********");
			System.out.println("Press 1. To Display all Lease Details");
			System.out.println("Press 2. To Recieve a Lease Detail using ID");
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
					List<Lease> lease=ls.returnCar();
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
					Lease lease1 = ls.getLeaseById(id);
					System.out.println(lease1);
				} catch (NullPointerException | SQLException e) {
					e.printStackTrace();
				} 
				Lease lease1;
				break;
			default :
				break;
			}

		}
	}
}
