
	package com.controller;

	import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.CustomerDto;
import com.dto.CustomerVehicleDto;
import com.exception.InvalidNameException;
import com.model.Customer;
import com.service.CustomerService;


	public class CustomerController {
		public static void main(String args[]) throws SQLException
		{
			CustomerService  customerService=new CustomerService();
			Scanner sc=new Scanner(System.in);
			while(true)
			{
			System.out.println("********************OPS********************");
			System.out.println("ENTER 1 TO FETCH WITH DATE RANGE");
			System.out.println("ENTER 2 TO FETCH");
			System.out.println("ENTER 3 TO FETCH BY NAME");
			System.out.println("ENTER 4 TO DELETE");
			System.out.println("ENTER 5 TO  FETCH BY LEASE");
			System.out.println("ENTER 6 TO UPDATE");
			System.out.println("ENTER 7 TO FETCH ALL VEHICLES BY CUSTOMER");
			System.out.println("ENTER 0 TO EXIT");
			int input=sc.nextInt();
			
			if(input==0)
			{
				System.out.println("EXITING.......THANK YOU!!!!");
				break;
			}
			switch(input)
			{
			case 1:
				System.out.println("FETCH ALL DETAILS");
				List<CustomerVehicleDto>lists=customerService.fetchRecord();
				for(CustomerVehicleDto v:lists)
				{
					System.out.println("[customerId="+v.getCustomerId()+  ", firstName=" + v.getFirstName() + ", lastName=" + v.getLastName()+ 
							 ", phoneNumber=" + v.getPhoneNumber() + ", vehicleId=" + v.getVehicleId ()+
							", make=" + v.getMake() +",model="+v.getMake()+ ",startDate="+v.getStartDate()+",endDate"+v.getEndDate()+"]");
				}
				break;
			
			case 2:
				System.out.println("FETCH ALL DETAILS");
				List<Customer>list=customerService.fetchAll();
				for(Customer m:list)
				{
					System.out.println("[id=" + m.getId() + ", firstName=" + m.getFirstName() + ", lastName=" + m.getLastName()+ 
							", email=" + m.getEmail()
							+ ", phoneNumber=" + m.getPhoneNumber() + ", userName=" + m.getUserName ()+
							", password=" + m.getPassword() + "]");
				}
				break;
			
			case 3:
				System.out.println("SEARCH BY NAME");
				System.out.println("Enter the name");
				sc.nextLine();
				String mname=sc.nextLine();
				try
				{
					Customer m=customerService.getByName(mname);
					System.out.println(m);
				}
				catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
				catch(InvalidNameException e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("DELETE");
				System.out.println("enter the id to be deleted");
				int id1=sc.nextInt();
				customerService.delete(id1);
				System.out.println("DELETED############");
				break;

				case 5:
					System.out.println("SEARCH BY LEASE");
					System.out.println("Enter the customer id to display the lease:");
					int cid=sc.nextInt();
					try {
						List<CustomerDto>l=customerService.getById(cid);
						for(CustomerDto d:l)
						{
					System.out.println("CustomerDto [id=" + d.getId() + ", firstName=" 
					+ d.getFirstName() + ", lastName=" + d.getLastName() + ", email=" + d.getEmail()
						+ ", phoneNumber=" + d.getPhoneNumber() + ", vehicleId=" 
						+ d.getVehicleId() + ", startDate=" +d.getStartDate()+ ", endDate="
							+ d.getEndDate() + ", type=" +d.getType() + "]");
						}
					}
					catch(SQLException e)
					{
						System.out.println(e.getMessage());
					}
					break;
				case 6:
					System.out.println("UPDATE***********");
					System.out.println("ENTER ID TO UPDATE");
					int ciid=sc.nextInt();
					System.out.println("ENTER LAST NAME");
					sc.nextLine();
					String clastName=sc.nextLine();
					customerService.update(ciid, clastName);
					break;
				case 7:
					System.out.println("FETCH ALL DETAILS");
					List<CustomerVehicleDto>list1=customerService.fetchDet();
					for(CustomerVehicleDto v:list1)
					{
						System.out.println("[customerId="+v.getCustomerId()+  ", firstName=" + v.getFirstName() + ", lastName=" + v.getLastName()+ 
								 ", phoneNumber=" + v.getPhoneNumber() + ", vehicleId=" + v.getVehicleId ()+
								", make=" + v.getMake() +",model="+v.getMake()+ "]");
					}
					break;
				default:
					System.out.println("INVALID INPUT");
					break;
			}
		}
	}
	}
