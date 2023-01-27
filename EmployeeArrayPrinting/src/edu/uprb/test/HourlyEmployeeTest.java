package edu.uprb.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.uprb.company.Department;
import edu.uprb.company.HourlyEmployee;

/**
 * This is a Junit test class that creates Hourly employees with both
 * valid and invalid  data inputs.
 * @author Eduardo R Torres Alamo
 * @version 09/06/2019
 * This version uses {@throws IllegalException} to handle exceptions.
 */

public class HourlyEmployeeTest {

	HourlyEmployee employee;

	/**
	 * this method creates an hourly employee object before each test
	 * @throws Exception
	 */

	@Before
	public void setUp() throws Exception {

		employee = new HourlyEmployee
				(1000,"John","Doe","Finance",40,7.50);

	}// before

	/**
	 * this method tests the toString method in the HourlyEmployee class
	 */

	@Test
	public void testToString() {

		assertEquals("Employee ID: 1000"
				+ "\nFirst Name: John" 
				+ "\nLast Name: Doe"
				+ "\nDepartment: Finance"
				+ "\nHours Worked: 40" 
				+ "\nPay Rate: $7.50"
				+ "\nWeekly Salary: $300.00", employee.toString());

	}// testToString

	/**
	 * this method tests the getEmployeeId method in the HourlyEmployee
	 *  class
	 */
	@Test
	public void testGetEmployeeId(){

		assertEquals(1000, employee.getEmployeeId());

	}// testGetEmployeeId

	/**
	 * this method tests the getFirstName method in the HourlyEmployee
	 *  class
	 */
	@Test
	public void testGetFirstName(){

		assertEquals("John", employee.getFirstName());

	}// testGetFirstName

	/**
	 * this method tests the getLastName method in the HourlyEmployee
	 *  class
	 */
	@Test
	public void testGetLastName(){

		assertEquals("Doe", employee.getLastName());

	}// testGetLastName

	/**
	 * this method tests the getDepartment method in the HourlyEmployee
	 *  class
	 */
	@Test
	public void testGetDepartment(){

		assertEquals(Department.FINA, employee.getDepartment());

	}// testGeDepartment

	/**
	 * this method tests the getHourWorked method in the HourlyEmployee
	 *  class
	 */
	@Test
	public void testGetHoursWorked(){

		assertEquals(40, employee.getHoursWorked());

	}// testGetHoursWorked

	/**
	 * this method tests the getPayRate method in the HourlyEmployee
	 *  class
	 */
	@Test
	public void testGetPayRate(){

		assertEquals(7.50, employee.getPayRate(),0.001);

	}// testGetPayRate

	/**
	 * this method tests the weeklySalary method in the HourlyEmployee 
	 * class
	 */
	@Test
	public void testweeklySalary(){

		assertEquals(300.00, employee.weeklySalary(),0.001);

	}// testGetPayRate

	/**
	 * this method tests the equals method in the Employee class
	 */
	@Test
	public void testEquals(){

		assertTrue(employee.equals(employee));

	}// testEquals

	/**
	 * this method tests the equals method in the Employee class
	 * sending employee and a copy of itself
	 */
	@Test
	public void testEqualsWithCopy(){

		HourlyEmployee copy = employee;
		assertTrue(employee.equals(copy));

	}// testEqualsWithCopy

	/**
	 * this method tests the equals in the Employee class by sending
	 * employee and a difreint object, should not be equals
	 */
	@Test
	public void testEqualsDiferent(){

		HourlyEmployee other = new HourlyEmployee(2000,"Shay","Ribera","",41,8.50);
		assertFalse(employee.equals(other));

	}// testEqualsDiferent

	/**
	 * this method tests the setFirstName method in the HourlyEmployee
	 *  class with a valid value
	 */
	@Test
	public void testSetFirstNameValid(){

		employee.setFirstName("Norman");
		assertEquals("Norman", employee.getFirstName() );

	}// testSetFirstNameValid

	/**
	 * this method tests the setFirstName method in the HourlyEmployee
	 *  class with a invalid value
	 */
	@Test
	public void testSetFirstNameInvalid(){

		try {
			employee.setFirstName("norman");
			fail("Test faliure with an invalid name");

		}// try

		catch (IllegalArgumentException ex) {
			assertEquals("norman does not follow name format", ex.getMessage());

		}// catch

	}// testSetFirstNameInvalid

	/**
	 * this method tests the setLastName method in the HourlyEmployee
	 *  class with a valid value
	 */
	@Test
	public void testSetLastNameValid(){

		employee.setLastName("Lucifer");
		assertEquals("Lucifer", employee.getLastName() );

	}// testSetFirstNameValid

	/**
	 * this method tests the setLastName method in the HourlyEmployee
	 *  class with a invalid value
	 */
	@Test
	public void testSetLastNameInvalid(){

		try {
			employee.setLastName("lucifer");
			fail("Test faliure with an invalid name");

		}// try

		catch (IllegalArgumentException ex) {
			assertEquals("lucifer does not follow name format", ex.getMessage());

		}// catch

	}// testSetLastNameInvalid

	/**
	 * This method tests the setHoursWorked method in the HourlyEmployee
	 *  class by sending a valid value
	 */
	@Test
	public void testSetHoursWorkedValid(){

		employee.setHoursWorked(41);
		assertEquals(41, employee.getHoursWorked());

	}// testSetHoursWorkedValid

	/**
	 * this method test the setHoursWorked method in the HourlyEmployee
	 *  class by sending an invalid value
	 */
	@Test 
	public void testSetHoursWorkedInvalid(){

		try {
			employee.setHoursWorked(-6);
			fail("Test faliure with an invalid value");

		}// try

		catch (IllegalArgumentException ex) {
			assertEquals("-6 must range between 0-60", ex.getMessage());

		}// catch

	}// testSetHoursWorkedInvalid

	/**
	 * This method tests the setPayRate method in the HourlyEmployee class
	 * by sending a valid value
	 */
	@Test
	public void testSetPayRateValid(){

		employee.setPayRate(7.50);
		assertEquals(7.50, employee.getPayRate(), 0.001);

	}// testSetPayRateValid

	/**
	 * this method test the setPayRate method in the HourlyEmployee class
	 * by sending an invalid value
	 */
	@Test 
	public void testSetPayRateInvalid(){

		try {
			employee.setPayRate(5.65);
			fail("Test faliure with an invalid value");

		}// try

		catch (IllegalArgumentException ex) {
			assertEquals("5.65 must range between 7.00 -50.00", ex.getMessage());

		}// catch

	}// testSetPayRateInvalid

	/**
	 * this method creates a employee with overtime, becouse overtime is
	 * not permitted the salary should be calculated with the default 
	 * hours worked and the inputed pay rate
	 */
	@Test
	public void testOvertime(){

		try {

			HourlyEmployee employee = new HourlyEmployee
					(1000,"John","Doe","Finance", 61, 7.50);

			fail("overtime is not accepted");

		}// try

		catch (IllegalArgumentException ex) {
			assertEquals( "61 must range between 0-60", ex.getMessage());

		}// catch

		assertEquals(300.00, employee.weeklySalary(),0.001);

	}// testOverTime

	/**
	 * this method creates a constructor with only the employee id and
	 * shows the corresponding information
	 */
	@Test
	public void employeeData(){

		HourlyEmployee employee = new HourlyEmployee(1000);

		assertEquals("Employee ID: 1000" 
				+ "\nFirst Name: null"  
				+ "\nLast Name: null" 
				+ "\nDepartment: Information Technology"
				+ "\nHours Worked: 40" 
				+ "\nPay Rate: $10.00"
				+ "\nWeekly Salary: $400.00", employee.toString());

	}// employeeData

	/**
	 * this method creates a a employee with an invalid id and displays
	 * the corresponding error message
	 */
	@Test
	public void invalidEmployee(){

		try {

			HourlyEmployee employee = new HourlyEmployee
					(100);


		}// try

		catch (IllegalArgumentException ex) {
			assertEquals("100 does not follow id format", ex.getMessage());

		}

	}

}
