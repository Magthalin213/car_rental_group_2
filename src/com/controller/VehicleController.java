package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.exception.VehicleNotFoundException;
import com.model.Customer;
import com.model.Vehicle;
import com.service.VehicleService;

public class VehicleController {
	public static void main(String[] args) throws SQLException, VehicleNotFoundException {
		VehicleService vehicleService = new VehicleService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("*********VEHICLE OPS**********");
			System.out.println("Press 1. for all vehicle details.....");
			System.out.println("Press 2. listing vehicle by status......");
			System.out.println("Press 3. To delete the vehicle details.....");
			System.out.println("Press 4. To insert elements into the table.....");
			System.out.println("Press 5. Search vechile details by NUMBER PLATE.....");
			System.out.println("Press 0 for exit......");
			System.out.println("****************************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting.. thank you!!!");
				break;
			} // if ends
			switch (input) {
			case 1:
				System.out.println("***ALL VEHICLE DETAILS****");

				List<Vehicle> list = vehicleService.getVehicles();
				for (Vehicle v : list) {
					System.out.println(v);
				}

				break;
			case 2:
				System.out.println("Enter STATUS Required: ");
				String str = sc.next();
				
				List<Vehicle> list1 = vehicleService.getVehiclesByStatus(str);
				for(Vehicle v : list1) {
				System.out.println(v);
				}
				
				break;
			case 3:
				System.out.println("DELETE VEHICLES...");
				System.out.println("Enter the Vehicle ID to be deleted..");
				int id1=sc.nextInt();
				VehicleService.delete(id1);
				System.out.println("***DELETED "+ id1+"***");
				break;
			case 4:
				System.out.println("Insert Details...");
				System.out.println("Enter ID:  ");
				int id=sc.nextInt();
				System.out.println("Enter Brand Name: ");
				String brandName=sc.next();
				System.out.println("Enter Model: ");
				String model=sc.next();
				System.out.println("Daily Rate: ");
				int dr=sc.nextInt();
				System.out.println("Status: ");
				String status=sc.next();
				System.out.println("Passenger Capacity: ");
				int pa=sc.nextInt();
				System.out.println("Engine Capacity: ");
				int ec=sc.nextInt();
				System.out.println("number plate: ");
				String np=sc.next();
				VehicleService.insert(id,brandName,model,dr,status,pa,ec,np);
				
			case 5:
				System.out.println("SEARCH VEHICLE BY NUMBER PLATE ");
				System.out.println("Enter the Number Plate ");
				sc.nextLine();
				String numberPlate=sc.nextLine();
				try
				{
					Vehicle v=vehicleService.getByNumPlate(numberPlate);
					System.out.println(v);
				}
				catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
				catch(VehicleNotFoundException e)
				{
					System.out.println(e.getMessage());
				}
				break;
				
			default:
				System.out.println("Invalid Input");
			} // end switch
		} // while ends
		sc.close(); // scanner closed.
	} // main ends

}
