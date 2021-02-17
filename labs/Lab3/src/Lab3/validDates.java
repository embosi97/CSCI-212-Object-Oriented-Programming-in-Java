
package Lab3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class validDates {
	Date aDate = null;
	static int month;
	static int day;
	static int year; 
	

	public static void main(String[] args) {

		String fileName =  "validDates.txt";
		
		// opens a stream to 'validDates.txt' in the current local directory
		// if the file isn't found, it'll create it and then write to that.
		try (FileWriter outputFile = new FileWriter(fileName)) {
			
			for (int i = 0; i < 10; i++) {
				outputFile.write(month + day + year);
			}
		} catch (IOException ioe) {
			System.out.println("Error opening " + fileName + ": " + ioe);
		}
	}
}
	



