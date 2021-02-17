package Lab3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab3App {
	public static void main(String[] args) {  
	
	Date aDate = null;
	int month, day, year;
	boolean done = false;
	aDate = new Date(); 
	while(!done) {
		while(true) { //while loop so it'll keep asking the user for an input until he/she enters one that meets the conditions of the method
			try {
				Scanner scan = new Scanner(System.in);
				System.out.print("Enter the month as an integer:");
				month = scan.nextInt();
				aDate.setMonth(month);
				break; //if no errors, break to next loop
			}
			catch (InputMismatchException ime) { 
				System.out.println("Not an integer.");
			}
			catch(DateException ex)
			{
				System.out.println("DateException: " + ex.getMessage());
			}
		}
		while(true) {
			try {
				Scanner scan = new Scanner(System.in);
				System.out.print("Enter the day as an integer:");
				day = scan.nextInt();
				aDate.setDay(day);
				break;
			}
			catch (InputMismatchException ime) { 
				System.out.println("Not an integer.");
			}
			catch(DateException ex)
			{
				System.out.println("DateException: " + ex.getMessage());
			}
		}
		while(true) {
			try {
				Scanner scan = new Scanner(System.in);
				System.out.print("Enter the year as an integer:");
				year = scan.nextInt();
				aDate.setYear(year);
				break;
			}
			catch (InputMismatchException e) { 
			   System.out.println("Not an integer.");
			}
			catch(DateException ex)
			{
				System.out.println("DateException: " + ex.getMessage());;
			}
		}
		done = true; 
		System.out.println(aDate);
		}
	}
}

