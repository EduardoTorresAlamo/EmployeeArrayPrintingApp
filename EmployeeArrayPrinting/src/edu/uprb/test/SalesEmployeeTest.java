package edu.uprb.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.uprb.company.Department;
import edu.uprb.company.SalesEmployee;

/**
 * This is a Junit test class that creates Sales employees with both
 * valid and invalid  data inputs.
 * @author Eduardo R Torres Alamo
 * @version 09/06/2019
 * This version uses {@throws IllegalException} to handle exceptions.
 */

public class SalesEmployeeTest {

	SalesEmployee employee;

	/**
	 * this method creates an sales employee object before each test
	 * @throws Exception
	 */

	@Before
	public void setUp() throws Exception {

		employee = new SalesEmployee
				(2000,"Jane","Doe","Sales",4000.00,0.5);

	}// before

	/**
	 * this method tests the toString method in the SalesEmployee class
	 */

	@Test
	public void testToString() {

		assertEquals("Employee ID: 2000" 
				+ "\nFirst Name: Jane"  
				+ "\nLast Name: Doe" 
				+ "\nDepartment: Sales"
				+ "\nSales Amount: $4000.00" 
				+ "\nComission Rate: 0.50%"
				+ "\nWeekly Salary: $2000.00", employee.toString());

	}// testToString

	/**
	 * this method tests the getEmployeeId method in the SalesEmployee
	 *  class
	 */

	@Test
	public void testGetEmployeeId(){

		assertEquals(2000, employee.getEmployeeId());

	}// testGetEmployeeId

	/**
	 * this method tests the getFirstName method in the SalesEmployee
	 *  class
	 */

	@Test
	public void testGetFirstName(){

		assertEquals("Jane", employee.getFirstName());

	}// testGetFirstName

	/**
	 * this method tests the getLastName method in the SalesEmployee
	 *  class
	 */

	@Test
	public void testGetLastName(){

		assertEquals("Doe", employee.getLastName());

	}// testGetLastName

	/**
	 * this method tests the getDepartment method in the SalesEmployee
	 *  class
	 */

	@Test
	public void testGetDepartment(){

		assertEquals(Department.SALE, employee.getDepartment());

	}// testGeDepartment

	/**
	 * this method tests the getSalesAmount method in the
	 *  SalesEmployee class
	 */
	@Test
	public void testGetSalesAmount(){

		assertEquals(4000.00, employee.getSalesAmount(), 0.001);

	}// testGetSalesAmount

	/**
	 * this method tests the getComissionRate method in the SalesEmployee
	 *  class
	 */

	@Test
	public void testGetComissionRate(){

		assertEquals(.50, employee.getComissionRate(), 0.001);

	}// testGetComissionRate

	/**
	 * this method tests the weeklySalary method in the SalesEmployee 
	 * class
	 */

	@Test
	public void testweeklySalary(){

	assertEquals(2000.00, employee.weeklySalary(), 0.001);

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

		SalesEmployee copy = employee;
		assertTrue(employee.equals(copy));

	}// testEqualsWithCopy

	/**
	 * this method tests the equals in the Employee class by sending
	 * employee and a difreint object, should not be equals
	 */

	@Test
	public void testEqualsDiferent(){

		SalesEmployee other = new SalesEmployee(5000,"Jammie","Domian","Sales",5000.00,0.10);
		assertFalse(employee.equals(other));

	}// testEqualsDiferent

	/**
	 * this method tests the setFirstName method in the SalesEmployee
	 *  class with a valid value
	 */

	@Test
	public void testSetFirstNameValid(){

		employee.setFirstName("Norman");
		assertEquals("Norman", employee.getFirstName() );

	}// testSetFirstNameValid

	/**
	 * this method tests the setFirstName method in the SalesEmployee
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
	 * this method tests the setLastName method in the SalesEmployee
	 *  class with a valid value
	 */

	@Test
	public void testSetLastNameValid(){

		employee.setLastName("Lucifer");
		assertEquals("Lucifer", employee.getLastName() );

	}// testSetFirstNameValid

	/**
	 * this method tests the setLastName method in the SalesEmployee
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
	 * This method tests the setSalesAmount method in the SalesEmployee
	 *  class by sending a valid value
	 */

	@Test
	public void testSetSalesAmountValid(){

		employee.setSalesAmount(41);
		assertEquals(41, employee.getSalesAmount(), 0.001);

	}// testSetSalesAmount

	/**
	 * this method test the setSalesAmount method in the SalesEmployee
	 *  class by sending an invalid value
	 */

	@Test 
	public void testSetSalesAmountInvalid(){

		try {
			employee.setSalesAmount(-6);
			fail("Test faliure with an invalid value");

		}// try

		catch (IllegalArgumentException ex) {
			assertEquals("invalid sales amount", ex.getMessage());

		}// catch

	}// testSetSalesAmountInvalid

	/**
	 * This method tests the setComissionRate method in the 
	 * SalesEmployee class by sending a valid value
	 */

	@Test
	public void testSetComissionRateValid(){

		employee.setComissionRate(.20);
		assertEquals(.20, employee.getComissionRate(), 0.001);

	}// testSetComissionRateValid

	/**
	 * this method test the setComissionRate method in the 
	 * SalesEmployee class by sending an invalid value
	 */

	@Test 
	public void testSetComissionRateInvalid(){

		try {
			employee.setComissionRate(12.5);
			fail("Test faliure with an invalid value");

		}// try

		catch (IllegalArgumentException ex) {
			assertEquals("invalid comission rate", ex.getMessage());

		}// catch

	}// testSetComissionRateInvalid
	
	/**
	 * this method creates a constructor with only the employee id and
	 * shows the corresponding information
	 */

	@Test
	public void employeeData(){

		SalesEmployee employee = new SalesEmployee(1000);

		assertEquals("Employee ID: 1000" 
				+ "\nFirst Name: null"  
				+ "\nLast Name: null" 
				+ "\nDepartment: Information Technology"
				+ "\nSales Amount: $0.00" 
				+ "\nComission Rate: 0.10%"
				+ "\nWeekly Salary: $0.00", employee.toString());

	}// employeeData

	/**
	 * this method creates a a employee with an invalid id and displays
	 * the corresponding error message
	 */

	@Test
	public void invalidEmployee(){

		try {

			SalesEmployee employee = new SalesEmployee
					(100);


		}// try

		catch (IllegalArgumentException ex) {
			assertEquals("100 does not follow id format", ex.getMessage());

		}// catch

	}// invalidEmployee

}//class
