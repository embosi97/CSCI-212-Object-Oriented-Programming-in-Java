package Cars;
//This project is similar to Project 1, just that instead of ArrayLists it uses LinkedLists
//Author: Emiljano Bodaj
//Class: CSCI 212
//Lab Section: 11G 

//import all the things necessary for the JFrame 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.GridLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CarGUI extends JFrame { //CarGUI inherits all the features of JFrame
	
	private JTextArea leftTextArea; //make 2 JTextAreas for the Jframe
	private JTextArea rightTextArea; 
	private StringBuilder leftSide; //make 2 StringBuilders which we'll later use to append the 2 ArrayLists onto
	private StringBuilder rightSide;
	
	//private JPanel panel;
	//private JTextField textField;
	//Instantiate the two child linked lists we created
	static SortedCarList sortedList = new SortedCarList();
	static UnsortedCarList unSortedList = new UnsortedCarList();
	static SortedCarList searchList = new SortedCarList();
	 
		
	 public CarGUI() //the 1-argument parameter constructor 
	    {
	        // Call the super class constructor to initialize the super
	        // class variables before initializing this class's variables
	        this.setTitle("Project 4 - Emiljano Bodaj"); //Inherited the title from the previous constructor

	        // Configure the JFrame
	        // Configure the JFrame components we inherited
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setSize(500, 500); //setting the size to an arbitrary width and height
	        this.setLocation(200, 200);
	        this.getContentPane().setLayout(new GridLayout(1, 2)); //1 row and 2 columns, where the 2 lists' toStrings can be appended onto
	        this.leftSide = new StringBuilder();  //just titling the 2 columns on the JFrame
	        this.rightSide = new StringBuilder();
	        	        
	        this.leftTextArea = new JTextArea(this.leftSide.toString());
	        this.rightTextArea = new JTextArea(this.rightSide.toString());

	        this.getContentPane().add(this.leftTextArea); //add the currently empty TextAreas to the content panes (the left and right ones)
	        this.getContentPane().add(this.rightTextArea);
	        //create menu buttons and menu bar
	        JMenuItem open = new JMenuItem("Open");
	        JMenuItem quit = new JMenuItem("Quit");
	        JMenuItem msg = new JMenuItem("Msg");
	        //new menu item
	        JMenuItem search = new JMenuItem("Search");
	        JMenuBar menuBar = new JMenuBar();
	        JMenu fileMenu = new JMenu("File");
	        JMenu fileMenuEdit = new JMenu("Edit");
	        FileMenuHandler fmh = new FileMenuHandler(this);
	        EditMenuHandler emh = new EditMenuHandler(this);
	        
	        // Add the action listener to the menu items 
	        open.addActionListener(fmh);
	        quit.addActionListener(fmh);
	        msg.addActionListener(fmh);
	        
	        search.addActionListener(emh);
	        // Add the menu items to the file menu
	        fileMenu.add(open);
	        fileMenu.addSeparator();
	        fileMenu.add(quit);
	        fileMenu.addSeparator();
	        fileMenu.add(msg);
	        fileMenuEdit.add(search);
	        // Add file menu to the menu bar, and set this gui's
	        // menu bar to the menuBar we created above
	        menuBar.add(fileMenu);
	        menuBar.add(fileMenuEdit);
	        this.setJMenuBar(menuBar);
	        this.setVisible(true); //without this, the GUI wouldn't even show up
	    }
	 
	 
	//Method that will read from a file, sieve through the lines via the StringTokenizer
	//Create Car objects after each line and add them to 2 Linked Lists as CarNodes
	//Move on to the next line and keeps going until there are no more tokens to be found in the file
	//Then it'll append the lists onto StringBuilders which will then be placed into the textAreas
	 public void readFile(File file) throws FileNotFoundException{
		 try{
		    Scanner scanner = new Scanner(file); //scanner will now read through the file, whatever it is
		    String line = scanner.nextLine(); //'line' is assigned to the first line of the file
		    String delimiter = ",";
		    StringTokenizer tokenizer = new StringTokenizer(line, delimiter); //tokenizer will go through the line and separate by ","
		    int tokenCount = new StringTokenizer(line, ",").countTokens(); //counts the tokens and makes tokenCount equal to amount of tokens
		    
		    while(tokenizer.hasMoreTokens()){ //keeps iterating until there are no more tokens to be found. 
		    	//if there aren't exactly 4 tokens, print it to the console
		    	if(tokenCount == 1){ //in the case there's only one text token that can be found
		        	String CarMakeUNO = tokenizer.nextToken();
		            System.out.println(CarMakeUNO + "\n"); //print to console
		        }
		        if(tokenCount == 2){ //in the case there are two tokens that were found in the current line
		        	String CarMakeDOS = tokenizer.nextToken();
		        	String CarModelDOS = tokenizer.nextToken();
		            System.out.println(CarMakeDOS + ", " + CarModelDOS + "\n"); //print to console
		        }
		        else if(tokenCount == 3){ //in the case there are three tokens that were found, doing this just in case another .txt file is used
		        	String CarMakeTRES = tokenizer.nextToken();
		        	String CarModelTRES = tokenizer.nextToken();
		        	int CarYearTRES = Integer.parseInt(tokenizer.nextToken());
		            System.out.println(CarMakeTRES + " " + CarModelTRES + " " + CarYearTRES + "\n"); //print to console
		        }
		        //finally, if there are 4 tokens in the current line, use tokenizer to extract the Make, Model, Year, and Mileage and put them into a new Car Object
		        else if (tokenCount == 4){ //since the Make, Model, Year, and Mileage are in fixed order, we can just do it by each subsequent token:
		        	String CarMake = tokenizer.nextToken();
		        	String CarModel = tokenizer.nextToken();
		        	int CarYear = Integer.parseInt(tokenizer.nextToken()); //since years are integers, we need to parse it with parseInt
		        	int CarMileage = Integer.parseInt(tokenizer.nextToken());	
		        	
		            //make a new object with the above values
		        	//newCar(Make, Model, Year, Mileage); 
		            Car newCar = new Car(CarMake, CarModel, CarYear, CarMileage); //put the appropriate variables in the newly instantiated Car object
		            unSortedList.addIt(newCar); //place the Car object into the linked list as a node
		            sortedList.insert(newCar); 
		            
		        }//goes through a single line of the file
		        if(scanner.hasNextLine()){ //if there are more lines in the file
		            line = scanner.nextLine(); //assigns string line to the next line of the file/goes to the next line
		            tokenizer = new StringTokenizer(line, delimiter); //StringTokenizer tokenizes the current line
		            tokenCount = new StringTokenizer(line, ",").countTokens(); //counts the tokens of the new line
		        }
		    }//end of while loop (stops when no more tokens)
		    
		scanner.close(); //close the scanner since it's not necessary anymore

		leftSide.append(" Unsorted Cars" + "\n");
		rightSide.append(" Sorted Cars" + "\n");

    	leftSide.append(unSortedList.toString()); //adds the LinkedLists to their respective StringBuilder	
		rightSide.append(sortedList.toString()); //Utilizes the overrided toString in CarList
		
		//adds the 2 StringBuilders to the 2 JTextAreas
		 this.leftTextArea.setText(this.leftSide.toString());
	     this.rightTextArea.setText(this.rightSide.toString());
	     
	    }catch (FileNotFoundException fnfe){
		 System.out.println("Selected File Was Not Found. Try Again. ");
	    }
	}//end of readFile
	 
	 
	 public void searchFile(File file) throws FileNotFoundException{
		 try{
			 
			leftTextArea.setText(null); //delete the contents in the JTextAreas
			rightTextArea.setText(null);
		    leftSide.setLength(0); //Set the StringBuilders to 0 so we can reuse them for this method
		    rightSide.setLength(0);
		    
		    Scanner scanner = new Scanner(file); //scanner will now read through the file, whatever it is
		    String line = scanner.nextLine(); //'line' is assigned to the first line of the file
		    String delimiter = ",";
		    StringTokenizer tokenizer = new StringTokenizer(line, delimiter); //tokenizer will go through the line and separate by ","
		    int tokenCount = new StringTokenizer(line, ",").countTokens(); //counts the tokens and makes tokenCount equal to amount of tokens
		    int counter = 0; //this counter makes it so the search won't do anything if the user enters an invalid make
		    
		    String theMake = JOptionPane.showInputDialog(null, "Input the Make of your choice");//ask the user to input the car make	
		    
		    while(tokenizer.hasMoreTokens()){ //keeps iterating until there are no more tokens to be found. 
		    	//if there aren't exactly 4 tokens, print it to the console
		    	String carMake = tokenizer.nextToken();	
		    	
		    	if(tokenCount == 1 && carMake.equalsIgnoreCase(theMake)){ //in the case there's only one text token that can be found
		            System.out.println(carMake + "\n"); //print to console
		        }
		        if(tokenCount == 2 && carMake.equalsIgnoreCase(theMake)){ //in the case there are two tokens that were found in the current line
		        	String CarModelDOS = tokenizer.nextToken();
		            System.out.println(carMake + ", " + CarModelDOS + "\n"); //print to console
		        }
		        else if(tokenCount == 3 && carMake.equalsIgnoreCase(theMake)){ //in the case there are three tokens that were found, doing this just in case another .txt file is used
		        	String CarModelTRES = tokenizer.nextToken();
		        	int CarYearTRES = Integer.parseInt(tokenizer.nextToken());
		            System.out.println(carMake + " " + CarModelTRES + " " + CarYearTRES + "\n"); //print to console
		        }
		        //finally, if there are 4 tokens in the current line, use tokenizer to extract the Make, Model, Year, and Mileage and put them into a new Car Object
		        else if (tokenCount == 4 && carMake.equalsIgnoreCase(theMake)){ //since the Make, Model, Year, and Mileage are in fixed order, we can just do it by each subsequent token:
		        	String CarModel = tokenizer.nextToken();
		        	int CarYear = Integer.parseInt(tokenizer.nextToken()); //since years are integers, we need to parse it with parseInt
		        	int CarMileage = Integer.parseInt(tokenizer.nextToken());			        	
		            //make a new object with the above values
		        	//newCar(Make, Model, Year, Mileage); 
		            Car newCar = new Car(carMake, CarModel, CarYear, CarMileage); //put the appropriate variables in the newly instantiated Car object
		            searchList.insert(newCar); //place the Car object into the linked list as a node
		            counter++;
		        }//goes through a single line of the file
		        
		        if(scanner.hasNextLine()){ //if there are more lines in the file
		            line = scanner.nextLine(); //assigns string line to the next line of the file/goes to the next line
		            tokenizer = new StringTokenizer(line, delimiter); //StringTokenizer tokenizes the current line in file
		            tokenCount = new StringTokenizer(line, ",").countTokens(); //counts the tokens of the new line
		        }
		    }//end of while loop (stops when no more tokens)	    
		scanner.close(); //close the scanner since it's not necessary anymore
		
		if(counter > 0){
			
		leftSide.append(" Cars that are of make " + "'" + theMake + "'" + "\n");
		leftSide.append(searchList.toString()); //Utilizes the overrided toString in CarList
		//adds the 2 StringBuilders to the 2 JTextAreas
	     this.leftTextArea.setText(this.leftSide.toString());
		}
		else{
		    rightSide.append(" No cars of that make were found" + "\n"); //if the make is not found, this will be displayed
		    this.leftTextArea.setText(this.leftSide.toString());
		}
		 }catch (FileNotFoundException fnfe){
			 System.out.println("Selected File Was Not Found. Try Again. ");
		 } 
	}//end of searchFile 
	 
}// end of CarGUI