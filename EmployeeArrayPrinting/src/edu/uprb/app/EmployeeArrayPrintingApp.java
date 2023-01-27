package edu.uprb.app;

import java.util.Scanner;

/**
 * This is a class that represents a list of employees who can be 
 * either Hourly or Sale employees with both valid and invalid 
 * data inputs that will be feed to the super class in order to
 * test whether or not each method properly handles these inputs
 * @author Eduardo R Torres Alamo
 * @version 09/06/2019
 * This version uses {@throws IllegalException} to handle exceptions.
 */

import edu.uprb.company.Employee;
import edu.uprb.company.HourlyEmployee;
import edu.uprb.company.SalesEmployee;



public class EmployeeArrayPrintingApp {
	
	/**
	 *  This array constructs employees with sample testing data.
	 *  Some purposely caused errors for validation purposes and
	 *  are set as comments after being executed and showing the
	 *  expected flags
	 */
	
	public static void main (String[] args){



		Employee employees[] = {

				new HourlyEmployee
				(1000,"John","Doe","Finance",40,7.50), // perfect case

				// new HourlyEmployee (0001,"John","Doe","Finance",40,7.50), tests the id validation
				//	new HourlyEmployee (1000,"john","Doe","Finance",40,7.50), tests the first name validation
				//	new HourlyEmployee (1000,"John","doe","Finance",40,7.50), tests the last name validation

				new HourlyEmployee
				(1000,"John","Doe","",40,7.50), // uses default department

				//	new HourlyEmployee(1000,"John","Doe","Finance",400,7.50), test the hours worked validation
				// new HourlyEmployee (1000,"John","Doe","Finance",40,-7.50), tests the pay rate validation

				new HourlyEmployee(1000),

				new SalesEmployee 
				(2000,"Jane","Doe","Sales",4000.00,0.5), // perfect case scenerio

				//	new SalesEmployee (-200,"Jane","Doe","Sales",4000.00,12.5), 
				//	new SalesEmployee (2000,"jane","Doe","Sales",4000.00,12.5),
				// new SalesEmployee (2000,"Jane","doe","Sales",4000.00,12.5),

				new SalesEmployee 
				(2000,"Jane","Doe","Sal",4000.00,1), // wrong department, uses the default value

				//	new SalesEmployee 	(2000,"Jane","Doe","Sales",-4000.00,12.5), // tests sales amount validation
				//	new SalesEmployee (2000,"Jane","Doe","Sales",4000.00,-12.5)}; // tests sales comissionValidation

				new SalesEmployee (3000,"S", "A","Finance", 4000.00, .15), // an anomaly employee to edit

				new SalesEmployee (3000)

		};// Employee list

		HourlyEmployee[] hourlyEmployees = {(HourlyEmployee) employees[0],
				(HourlyEmployee) employees[1] ,(HourlyEmployee) employees[2]

		};// list of Hourly employees

		for (HourlyEmployee employee : hourlyEmployees) {

			// tests each individual method instead of using the toString
			System.out.println("\nId: " + employee.getEmployeeId());
			System.out.println("First Name: " + employee.getFirstName());
			System.out.println("Last Name: " + employee.getLastName());
			System.out.println("Department: " + employee.getDepartment().toString());
			System.out.println("Hours Worked: " + employee.getHoursWorked());
			System.out.printf("Pay Rate: $%.2f", employee.getPayRate());
			System.out.printf("\nWeekly Salary: $%.2f", employee.weeklySalary());
			System.out.println();

		}//for


		SalesEmployee saleEmployees[] = {(SalesEmployee) employees[3],
				(SalesEmployee) employees[4], (SalesEmployee) employees[5], 
				(SalesEmployee) employees[6]

		};// list of sale employees

		for (SalesEmployee saleEmployee : saleEmployees) {


			// tests each individual method instead of using the toString
			System.out.println("\nId: " + saleEmployee.getEmployeeId());
			System.out.println("First Name: " + saleEmployee.getFirstName());
			System.out.println("Last Name: " + saleEmployee.getLastName());
			System.out.println("Department: " + saleEmployee.getDepartment().toString());
			System.out.printf("Sales Amount: $%.2f", saleEmployee.getSalesAmount());
			System.out.printf("\nComission Rate: %.2f", saleEmployee.getComissionRate());
			System.out.println("%");
			System.out.printf("Weekly Salary: $%.2f", saleEmployee.weeklySalary());
			System.out.println();


		System.out.println("\nEnd of execution.");
		System.exit(0);  // exit with success 
		}
	}//main

}// class
