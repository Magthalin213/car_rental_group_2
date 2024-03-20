
	package com.controller;

	import java.sql.SQLException;
	import java.util.List;
	import java.util.Scanner;

import com.model.Customer;
import com.model.Lease;
import com.service.CustomerService;


	public class CustomerController {
		public static void main(String args[]) throws SQLException
		{
			CustomerService  customerService=new CustomerService();
			Scanner sc=new Scanner(System.in);
			while(true)
			{
			System.out.println("********************OPS********************");
			System.out.println("ENTER 1 TO SIGN UP");
			System.out.println("ENTER 2 TO FETCH");
			System.out.println("ENTER 3 TO FETCH BY NAME");
			System.out.println("ENTER 4 TO DELETE");
			System.out.println("ENTER 5 TO  FETCH BY LEASE");
			System.out.println("ENTER 6 TO UPDATE");
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
				System.out.println("SIGN UP!!!!");
				System.out.println("ENTER DETAILS TO SIGN UP");
				System.out.println("ENTER THE ID:");
				int id=sc.nextInt();
				System.out.println("ENTER FIRST NAME:");
				sc.nextLine();
				String firstName=sc.nextLine();
				System.out.println("ENTER LAST NAME:");
				
				String lastName=sc.nextLine();
				System.out.println("ENTER EMAIL:");
				
				String email=sc.nextLine();
				System.out.println("ENTER PHONENUMBER:");
				
				String phoneNumber=sc.nextLine();
				System.out.println("NOW TO LOGIN ENTER THE CREDENTIAL DETAILS!!!");
				System.out.println("ENTER USERNAME:");
				
				String userName=sc.nextLine();
				System.out.println("ENTER Password:");
				
				String password=sc.nextLine();
				customerService.signUp(id,firstName,lastName,email,
						phoneNumber,userName, password);
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
				catch(NullPointerException e)
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
					System.out.println("Enter the id");
					int lid=sc.nextInt();
					try
					{
						Lease l=customerService.getById(lid);
						System.out.println(l);
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
				case 6:
					System.out.println("UPDATE***********");
					System.out.println("ENTER ID TO UPDATE");
					int cid=sc.nextInt();
					System.out.println("ENTER LAST NAME");
					sc.nextLine();
					String clastName=sc.nextLine();
					customerService.update(cid, clastName);
					break;
				default:
					System.out.println("INVALID INPUT");
					break;
			}
		}
	}
	}
