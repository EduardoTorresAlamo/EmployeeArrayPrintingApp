package edu.uprb.company;


/**
 * This class creates an Hourly Employee and calculates it's weekly salary.
 * @author Eduardo R Torres Alamo
 * @version 09/06/2019
 * This version uses {@throw IllegalException} to handle exceptions.
 */
public class HourlyEmployee extends Employee
{

	public static int DEFAULT_HOURS = 40;
	public static double DEFAULT_RATE = 10.00;


	private int hoursWorked;
	private double payRate;


	/**
	 * Creates an Hourly Employee with a given ID, First and 
	 * Last Name, Department, Hours Worked, Pay Rate.
	 * @param employeeId
	 * @param firstName
	 * @param lastName
	 * @param department
	 * @param hoursWorked
	 * @param payRate
	 */
	public HourlyEmployee(int employeeId, String firstName, 
			String lastName, String department, 
			int hoursWorked, double payRate) 
	{

		super(employeeId);
		setFirstName(firstName);
		setLastName(lastName);
		setDepartment(department);
		setHoursWorked(hoursWorked);
		setPayRate(payRate);

	}

	/**
	 * This constructor only creates an Hourly Employee with
	 * default values.
	 * @param employeeId
	 */
	public HourlyEmployee(int employeeId)
	{
		super(employeeId);
		hoursWorked = DEFAULT_HOURS;
		payRate = DEFAULT_RATE;

	}


	/**
	 * This method returns the hours worked of an employee
	 * @return hoursWorked
	 */
	public int getHoursWorked()
	{
		return hoursWorked;
	}

	/**
	 * This method validates the received hours worked and if valid sets
	 * it to the hoursWorked field
	 * @param hoursWorked
	 */
	public void setHoursWorked(int hoursWorked)
	{
		if (hoursWorked <0 || hoursWorked > 60)

			throw new IllegalArgumentException

			( hoursWorked + " must range between 0-60");

		this.hoursWorked = hoursWorked;
	}

	/**
	 * This method returns the pay rate
	 * @return payRate
	 * @code this.payRate
	 */
	public double getPayRate()
	{
		return payRate;
	}

	/**
	 * This method validates the received payrate and if it's
	 * valid sets it to the hoursRate field
	 * @param payRate
	 */
	public void setPayRate(double payRate)
	{
		if (payRate <7 || payRate > 50)

			throw new IllegalArgumentException
			( payRate + " must range between 7.00 -50.00");

		this.payRate = payRate;
	}

	/**
	 * @{inherit}
	 * in this case for an hourly employee
	 */
	@Override
	public double weeklySalary()
	{
		if(this.hoursWorked > 40)

			this.payRate = 1.5;

		return this.hoursWorked * this.payRate;
	}

	/**
	 * {@inheritDoc}
	 * In this case for an hourly employee
	 */
	@Override
	public String toString()
	{
		return super.toString() 
				+"\nHours Worked: " + hoursWorked 
				+ "\nPay Rate: $" + payRate + "0"
				+ "\nWeekly Salary: $" + weeklySalary() + "0";
	}

}
