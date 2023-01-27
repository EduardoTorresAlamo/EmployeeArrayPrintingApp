package edu.uprb.company;

import java.util.regex.Pattern;

/**
 * This is a class for Employees.
 * @author Eduardo R Torres Alamo 842-15-8724 {@literal <eduardo.torres12@upr.edu>}
 * @version 09/06/2019
 * This version uses {@throws IllegalException} to handle exceptions.
 */

public abstract class Employee
{
	
	/** The id of the employee */
	private final int employeeId;
	
	/** The first name of the employee */
	private String firstName;
	
	/** The last name of the employee */
	private String lastName;
	
	/** The department of the employee */
	private Department department = Department.INTE;

	
	/**
	 * Creates an employee with the specified Id, Name and Department.
	 * @param employeeId The id of this employee
	 * @param firstName The first name of the employee
	 * @param lastName The last name of the employee
	 * @param department The department of the employee
	 */
	public Employee(int employeeId,
			String firstName,
			String lastName,
			Department department)
	{
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
	}

	/**
	 * Creates an employee with the default values.
	 */
	public Employee(int employeeId)
	{
		this.employeeId = employeeId;
	}


	/**
	 * Returns the first name of this employee.
	 * @return The first name of this employee.
	 */
	public String getFirstName()
	{

		return firstName;
	}

	/**
	 * Sets the first name of this employee to the given value.
	 * @param firstName The first name of this employee
	 */
	public void setFirstName(String firstName)
	{
		boolean answer= false;

		answer=
				Pattern.matches("[A-Z]{1}[a-z]{0,9}", firstName); 

		if (!answer)

			throw new IllegalArgumentException
			( firstName + " does not follow name format");

		this.firstName = firstName;
	}

	/**
	 * Returns the last name of this employee.
	 * @return The last name of this employee.
	 */
	public String getLastName()
	{

		return lastName;
	}

	/**
	 * Sets the last name of this employee to the given value.
	 * @param lastName The first name of this employee
	 */
	public void setLastName(String lastName)
	{
		boolean answer = false;

		answer = Pattern.matches("[A-Z]{1}[a-z]{0,9}", lastName); 

		if (!answer)

			throw new IllegalArgumentException
			( lastName + " does not follow name format");

		this.lastName = lastName;
	}

	
	public Department getDepartment()
	{
		return department;
	}

	public void setDepartment(String department)
	{
		switch (department.toUpperCase()) {

		case "SALES": 
			this.department = Department.SALE;
			break;

		case "MARKETING":
			this.department = Department.MKTG;
			break;

		case "HUMAN RESOURSES":
			this.department = Department.HMRS;
			break;

		case "FINANCE":
			this.department = Department.FINA;
			break;

		case "INFORMATION TECNOLOGY":
			this.department = Department.INTE;
			break;

		default: 
			this.department = Department.INTE;
			
		}
	}

	public final int getEmployeeId()
	{		
		String id = Integer.toString(this.employeeId);
		if (! Pattern.matches("[1-9]{1}[0-9]{3}", id )) 
		{
			throw new IllegalArgumentException
			( employeeId + " does not follow the correct format");
		}

		return employeeId;

	}

	public abstract double weeklySalary();

	@Override	
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(! super.equals(obj) || !(obj instanceof Employee))
			return false;

		Employee other = (Employee) obj;
		return Integer.compare(this.employeeId, other.employeeId) == 0;
	}

	@Override
	public String toString()
	{
		return "Employee ID: " + employeeId + 
				"\nFirst Name: " + firstName + 
				"\nLast Name: " + lastName
				+ "\nDepartment: " + department;
	}



}
