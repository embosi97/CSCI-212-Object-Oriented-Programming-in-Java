package Lab3;

import java.util.Calendar;

/**

 * <p>

 * Title:

 * </p>

 *

 * <p>

 * Description:

 * </p>

 *

 * <p>

 * Copyright: Copyright (c) 2016

 * </p>

 *

 * <p>

 * Company:

 * </p>

 *

 * @author not attributable

 * @version 1.0

 */

public class Date {

	
	private int dMonth; // variable to store the month
	private int dDay; // variable to store the day
	private int dYear; // variable to store the year
    private boolean dLeapYear; // variable for the leap year

	/**

	 * default constructor - sets dMonth=1, dDay=1, and dYear=1900

	 */
	public Date() {
		dMonth = 1;
		dDay = 1;
		dYear = 1900;
		dLeapYear = true; //private leap year value
	}

	

	/**

	 * parameterized constructor - sets dMonth, dDay, and dYear to user

	 * specified values

	 * 

	 * @param month

	 *            value to be stored in dMonth

	 * @param day

	 *            value to be stored in dDay

	 * @param year

	 *            value to be stored in dYear

	 */

	public Date(int month, int day, int year) throws DateException { //all the scanner shit will go in here
		setMonth(month);
		setDay(day);
		setYear(year);
	}



	/**

	 * setDate - stores month, day, and year in dMonth, dDay, and dYear

	 * respectively be calling each of the setMethods defined

	 * 

	 * @param month

	 *            value to be stored in dMonth

	 * @param day

	 *            value to be stored in dDay

	 * @param year

	 *            value to be stored in dYear

	 */

	public void setDate(int month, int day, int year) throws DateException {
		setMonth(month);
		setDay(day);
		setYear(year);
	}



	/**

	 * setMonth - stores month in dMonth

	 * 

	 * @param month

	 *            the value to be stored in dMonth

	 */

	public boolean getLeap() {
		return dLeapYear;
	}

	//****************************************************************************

	public boolean setLeapYear(int year) { //attempt to make a method for leap year
		if((year % 400) == 0 || ((year % 4) == 0 && year % 100 != 0)) { // check if the year is a leap year through math
			return true;
		}
		else {
			return false;
		}
	}

		

	

	public void setMonth(int month) throws DateException { //this method catches DataException
		if (month >= 1 && month <= 12) // January to December
			dMonth = month;
		else 
			throw new DateException("Invalid Month: month out of range");
			dMonth = month;
		}



	/**

	 * setDay - stores day in dDay

	 * 

	 * @param day

	 *            the value to be stored in dDay

	 */

	public void setDay(int day) throws DateException {
		int maxDay = 0;
		if(dMonth == 9 || dMonth == 4 || dMonth == 6 || dMonth == 11) { // months with 30 days
			maxDay = 30;
		}
		if(dMonth == 1 || dMonth == 3 || dMonth == 5 || dMonth == 7 || dMonth == 8 || dMonth == 10 || dMonth == 12) { // months with 31 days
			maxDay = 31;
		}
		else if(dMonth == 2) {
			maxDay = 29;
		}
		if(day <= 0 || day > maxDay) // if the input date is less than or equal to zero or more than maxDay (number of days in a month) of that month, return an error
			throw new DateException("Not a valid day.");
		    dDay = day;
	}



	/**

	 * setYear - stores year in dYear

	 * 

	 * @param year

	 *            the value to be stored in dYear

	 */

 	public void setYear(int year) throws DateException {

		if(setLeapYear(year) == false && dDay == 29 && dMonth == 2) { //if it is not a leap year and its February 29, return an error message
 			throw new DateException("Invalid Year: day out of range for non-leap year");
		}
		else if ((year < 1752) && (year > 2018)) { 
		throw new DateException("Invalid Year: year out of range");
		}
		dYear = year; //dYear is set to the user input of year

	}



	/**

	 * getMonth - accessor for dMonth

	 * 

	 * @return returns the value stored in dMonth

	 */

	public int getMonth() {
		return dMonth;
	}



	/**

	 * getDay - accessor for dDay

	 * 

	 * @return returns the value stored in dDay

	 */

	public int getDay() {
		return dDay;
	}



	/**

	 * getYear - accessor for dYear

	 * 

	 * @return returns the value stored in dYear

	 */

	public int getYear() {
		return dYear;
	}



	/**

	 * toString - returns the month, day, and year in the format: mm-dd-yyyy;

	 * leading zeros are NOT contained within the string

	 * 

	 * @return a String containing the date in month-day-year format

	 */

	public String toString() {
		return (dMonth + "-" + dDay + "-" + dYear);
	}
}



