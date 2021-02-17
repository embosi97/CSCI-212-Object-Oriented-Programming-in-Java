package Cars;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CarGUI extends JFrame { //CarGUI inherits all the features of JFrame
	
	private JTextArea leftTextArea; //make 2 JTextAreas for the Jframe
	private JTextArea rightTextArea; 
	private StringBuilder leftSide; //make 2 StringBuilders which we'll later use to append the 2 ArrayLists onto
	private StringBuilder rightSide;
	
	public static ArrayList<Car> unsortedList = new ArrayList<Car>(); //2 ArrayLists that'll work with car objects
	public static ArrayList<Car> sortedList = new ArrayList<Car>();
	
	 public CarGUI() //default constructor for the GUI class
   {
		// Instance variables
       this("CS 212 - Project 1 (Emiljano Bodaj)");
   }
	 
		
	 public CarGUI(String title) //the 1-argument parameter constructor 
	    {
	        // Call the super class constructor to initialize the super
	        // class variables before initializing this class's variables
	        super(title); //Inherited the title from the previous constructor

	        // Configure the JFrame
	        // Configure the JFrame components we inherited
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setSize(450, 450); //setting the size to an arbitrary width and height
	        this.setLocation(200, 200);
	        this.getContentPane().setLayout(new GridLayout(1, 2)); //1 row and 2 columns, where the 2 lists' toStrings can be appended onto
	        this.leftSide = new StringBuilder("Unsorted Cars\n");  //just titling the 2 columns on the JFrame
	        this.rightSide = new StringBuilder("Sorted Cars\n");
	        this.leftTextArea = new JTextArea(this.leftSide.toString());
	        this.rightTextArea = new JTextArea(this.rightSide.toString());
	        this.getContentPane().add(this.leftTextArea); //add the currently empty TextAreas to the content panes (the left and right ones)
	        this.getContentPane().add(this.rightTextArea);
	        this.setVisible(true); //without this, the GUI wouldn't even show up
	    }
	 
	 
		 
	 public void readFile(String file) throws FileNotFoundException{
		    File myFile = new File(file); //put the parameter String into File so it can seen as a file
		    Scanner scanner = new Scanner(myFile); //scanner will now read through the file
		    String line = scanner.nextLine(); //line assigned to the next line
		    String delimiter = ",";
		    StringTokenizer tokenizer = new StringTokenizer(line, delimiter); //tokenizer will go through the file and sort by ","
		    int tokenCount = new StringTokenizer(line, ",").countTokens(); //counts the tokens and makes tokenCount equal to amount of tokens
		    
		    while(tokenizer.hasMoreTokens()){ //keeps iterating until there are no more tokens to be found. 
		    	//if there aren't exactly 4 tokens, print it to the console
		    	if(tokenCount == 1){ //in the case there's only one text token that can be found
		        	String CarMakeUNO = tokenizer.nextToken();
		            System.out.println(CarMakeUNO); //print to console
		        }
		    	else if(tokenCount == 2){ //in the case there are two tokens that were found in the current line
		        	String CarMake2 = tokenizer.nextToken();
		        	String CarModel2 = tokenizer.nextToken();
		            System.out.println(CarMake2 + ", " + CarModel2); //print to console
		        }
		        else if(tokenCount == 3){ //in the case there are three tokens that were found, doing this just in case another .txt file is used
		        	String CarMake3 = tokenizer.nextToken();
		        	String CarModel3 = tokenizer.nextToken();
		        	int CarYear3 = Integer.parseInt(tokenizer.nextToken());
		            System.out.println(CarMake3 + " " + CarModel3 + " " + CarYear3); //print to console
		        }
		        //finally, if there are 4 tokens in the current line, use tokenizer to extract the Make, Model, Year, and Mileage and put them in a Car Object
		        else if(tokenCount == 4){ //since the Make, Model, Year, and Mileage are in fixed order, we can just do it like this:
		        	String CarMake = tokenizer.nextToken();
		        	String CarModel = tokenizer.nextToken();
		        	int CarYear = Integer.parseInt(tokenizer.nextToken());
		        	int CarMileage = Integer.parseInt(tokenizer.nextToken());		
		            //newCar(Make, Model, Year, Mileage); 
		            Car newCar = new Car(CarMake, CarModel, CarYear, CarMileage); //put the appropriate variables in the newly instantiated Car object
		            unsortedList.add(newCar); //adds the contents of the line to the ArrayList
		            sortedList.add(newCar); //do the same for sortedList
		        }//goes through a single line
		        if(scanner.hasNextLine()){ //if there are more lines in the file
		            line = scanner.nextLine(); //assigns string line to the next line of the file/goes to the next line
		            tokenizer = new StringTokenizer(line, delimiter); //StringTokenizer tokenizes the current line
		            tokenCount = new StringTokenizer(line, ",").countTokens(); //counts the tokens of the new line
		        }
		    }//end of while loop
		    scanner.close(); //close the scanner since it's not necessary anymore
		    selectionSort(sortedList); //use the method below, SelectionSort, to sort one of the ArraysLists by Make
		   
		}

	
//Selection sort algorithm that accepts ArrayLists with Car objects, like sortedList
public void selectionSort(ArrayList<Car> sortedList2) {
		for (int i = 0; i < sortedList2.size() - 1; i++) {
			int min = i;			
			for (int j = min + 1; j < sortedList2.size(); j++)
				if (sortedList2.get(j).getMake().compareTo(sortedList2.get(min).getMake()) < 0)
					min = j;  
				else if (sortedList2.get(j).getMake().compareTo(sortedList2.get(min).getMake()) == 0) {
					continue;
				}
			
			// We don't switch if min == i
			/*
				Code
			*/
			
			Car currentSpot = sortedList2.get(i);
			Car minNode = sortedList2.get(min);
			sortedList2.set(i, minNode); //switches i to min 
			sortedList2.set(min, currentSpot); //switches min to i
			
			// Swap currentSpot and minNode
			

		}//The error is "The left-hand side of an assignment must be a variable"
			leftSide.append(unsortedList.toString()); //adds the ArrayLists to their respective StringBuilder	
			rightSide.append(sortedList.toString());
		
		//adds the 2 StringBuilders to their the 2 JTextAreas
		//since it's an ArrayList, there are commas and brackets that need to be removed, hence the replaceAll's
		 this.leftTextArea.setText(this.leftSide.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", ""));
	     this.rightTextArea.setText(this.rightSide.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", ""));

}
	
}// end of CarGUI

