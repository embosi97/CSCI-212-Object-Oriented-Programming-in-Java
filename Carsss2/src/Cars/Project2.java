package Cars;

import java.io.FileNotFoundException;


public class Project2 {

	public static void main(String arg[]) throws FileNotFoundException{ //main method that enables us to even run this class
		 String file = "cars.txt"; //the .txt file is in the project
			CarGUI testGUI = new CarGUI(); //create a new CarGUI object
			testGUI.readFile(file); //call the GUI object and the readFile method

	}
}


