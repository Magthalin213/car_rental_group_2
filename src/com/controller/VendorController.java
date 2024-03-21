package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.VendorDto;
import com.model.Vendor;
import com.service.VendorService;

public class VendorController {
	
	public static void main(String args[]) throws SQLException
	{
		VendorService  vendorService=new VendorService();
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("**********VENDOR OPS************");
			System.out.println("PRESS 1 TO Sign up");
			System.out.println("PRESS 2 TO List all Vendor");
			System.out.println("PRESS 3 TO Fetch by ID");
			System.out.println("PRESS 4 TO Delete");
			System.out.println("PRESS 5 TO Get by Lease");
			System.out.println("PRESS 6 TO Update");
			System.out.println("PRESS 0 TO Exit");
			System.out.println("**********************");
			int input=sc.nextInt();
			
			if(input==0)
			{
				System.out.println("Exiting....Thank you!!!");
				break;
			}
			switch(input)
			{
				case 1:
					System.out.println("***Sign up***");
					System.out.println("Enter detail to sign up: ");
					System.out.println("Enter the ID: ");
					int id=sc.nextInt();
					
					System.out.println("Enter the Vechile ID: ");
					int vcid=sc.nextInt();
					
					System.out.println("Enter First Name: ");
					sc.nextLine();
					String firstName=sc.nextLine();
					
					System.out.println("Enter Last Name: ");
					String lastName=sc.nextLine();
					
					System.out.println("Enter Email: ");
					String email=sc.nextLine();
					
					System.out.println("Enter Phone Number: ");
					String phoneNumber=sc.nextLine();
					
					System.out.println("***Enter the Login Credentials***");
					System.out.println("Enter Username: ");
					String userName=sc.nextLine();
				
					System.out.println("Enter Password: ");
					String password=sc.nextLine();
					vendorService.signUp(id,vcid,firstName,lastName,email,phoneNumber,userName, password);
				
					
				case 2:
					System.out.println("***List All Vendors***");
					List<Vendor>list=vendorService.listAll();
					for(Vendor m:list)
					{
						System.out.println("[id=" + m.getId() + ", vehicleId=" + m.getVehicleId() + ", firstName=" + m.getFirstName() + ", lastName=" + m.getLastName()+ 
								", email=" + m.getEmail()+ ", phoneNumber=" + m.getPhoneNumber() + ", userName=" + m.getUserName ()+
								", password=" + m.getPassword() + "]");
					}
					break;
				
					
				case 3:
					System.out.println("***Fetch by ID***");
					System.out.println("Enter the ID: ");
					sc.nextLine();
					int mid=sc.nextInt();
					
					try
					{
						Vendor m= vendorService.getById(mid);
						System.out.println(m);
					}
					catch(SQLException e)
					{
						System.out.println(e.getMessage());
					}
					catch(NullPointerException e)
					{
						System.out.println(e.getMessage());
					}
					break;
				
					
				case 4:
					System.out.println("***Delete Details***");
					System.out.println("Enter the ID to be deleted: ");
					int id1=sc.nextInt();
					vendorService.delete(id1);
					System.out.println("###Deleted###");
					break;
		
					
				case 5:
					System.out.println("***Get by Lease***");
					System.out.println("Enter the Vendor ID whose Lease has to be diplayed: ");
					int vid=sc.nextInt();
					
					try 
					{
						List<VendorDto>l=vendorService.getByid(vid);
						for(VendorDto d:l)
							{
								System.out.println("CustomerDto [id=" + d.getId() + ", vehicleId=" + d.getVehicleId() + ", firstName=" + d.getFirstName() + 
										", lastName=" + d.getLastName() + ", email=" + d.getEmail() +
										", phoneNumber=" + d.getPhoneNumber() + ", vehicleId=" + d.getVehicleId() + 
										", startDate=" +d.getStartDate()+ ", endDate=" + d.getEndDate() + ", type=" +d.getType() + "]");
							}
					}
					catch(SQLException e)
					{
						System.out.println(e.getMessage());
					}
					break;
					
					
				case 6:
					System.out.println("***Update***");
					System.out.println("Enter ID to be Updated: ");
					int viid=sc.nextInt();
					
					System.out.println("Enter First Name: ");
					sc.nextLine();
					String vfastName=sc.nextLine();
					vendorService.update(viid, vfastName);
					break;
					
					
				default:
					System.out.println("Invalid Input!!!");
					break;
			}
		} 
		sc.close();
	}
}
