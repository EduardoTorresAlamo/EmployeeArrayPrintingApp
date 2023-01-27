package edu.uprb.company;

/**
 * This class creates an Sales Employee and calculates it's weekly salary.
 * @author Eduardo R Torres Alamo
 * @version 09/06/2019
 * This version uses {@throw IllegalException} to handle exceptions.
 */
public class SalesEmployee extends Employee
{

	private double salesAmount = 0.0;
	private double comissionRate = 0.10;

	/**
	 * This constructor is used by the testing app, sets all the 
	 * parameters to their corresponding setters and sends the id to the
	 * super constuctor 
	 * @param employeeId
	 * @param firstName
	 * @param lastName
	 * @param department
	 * @param salesAmount
	 * @param comissionRate
	 */
	public SalesEmployee(int employeeId, String firstName, 
			String lastName, String department, 
			double salesAmount, double comissionRate)
	{
		super(employeeId);
		setFirstName(firstName);
		setLastName(lastName);
		setDepartment(department);
		setSalesAmount(salesAmount);
		setComissionRate(comissionRate);
	}

	/**
	 * this constructor only recieves an id
	 * @param employeeId
	 */
	public SalesEmployee(int employeeId)
	{
		super(employeeId);
	}

	/**
	 * @{inherit Doc}
	 * in this case for a sales employee
	 * A code this.salesAmount*this.comissionRate;
	 */
	@Override
	public double weeklySalary()
	{
		return this.salesAmount * this.comissionRate;
	}

	/**
	 * This method returns sale amounts
	 * @return salesAmount
	 * @code this.salesAmount;
	 */
	public double getSalesAmount()
	{
		return salesAmount;
	}

	/**
	 * This method validates the recieved sales amount and if valid, sets
	 *  it in the salesAmount field.
	 *  @param salesAmount 
	 *  @code this.salesAmount = salesAmount;
	 *  @throws IllegalArgumentException if salesAmount is < 0
	 */
	public void setSalesAmount(double salesAmount)
	{
		if(salesAmount < 0)

			throw new IllegalArgumentException ("invalid sales amount");

		this.salesAmount = salesAmount;
	}

	/**
	 * this method returns the comission rate
	 * @return comissionRate
	 * @code this.comissionRate;
	 */
	public double getComissionRate()
	{
		return comissionRate;
	}

	/**
	 * this method validates the comissionRate variable and if valid, sets
	 * it int the comissionRate field.
	 * @param comissionRate
	 *@throws IllegalArgumentException if comission is <0 or >1
	 */
	public void setComissionRate(double comissionRate)
	{
		if(comissionRate < 0 || comissionRate > 1)

			throw new IllegalArgumentException ("invalid comission rate");

		this.comissionRate = comissionRate;
	}

	/**
	 * @{inheritDoc}
	 * then adds sales amount and comission rate
	 */
	@Override
	public String toString()
	{
		return super.toString() 
				+ "\nSales Amount: $" + salesAmount + "0"
				+ "\nComission Rate: " + comissionRate + "0%"
				+ "\nWeekly Salary: $" + weeklySalary() + "0";
	}





}
