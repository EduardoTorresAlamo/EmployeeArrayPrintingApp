package edu.uprb.company;

/**
 * This is a class represents an employee's department.
 * @author Eduardo R Torres Alamo 842-15-8724 {@literal <eduardo.torres12@upr.edu>}
 * @version 09/06/2019
 * This version uses {@throws IllegalException} to handle exceptions.
 */

public enum Department
{
	SALE, MKTG, HMRS, FINA, INTE;

	/**
	 * This methods returns an employees department
	 * @param recieves a department type object
	 * @{code this} is the department object
	 * @return a string related to that object
	 */
	@Override
	public String toString() 
	{
		switch (this) 
		{
		case SALE: return "Sales";
		case MKTG: return "Marketing";
		case HMRS: return "Human Resources";
		case FINA: return "Finance";
		case INTE: return "Information Technology";
		default: return "NONE";
		}
	}

}
