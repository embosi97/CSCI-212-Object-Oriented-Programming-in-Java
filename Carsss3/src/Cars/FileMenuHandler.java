package Cars;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.File;
import java.io.FileNotFoundException;
public class FileMenuHandler implements ActionListener 
{
//this code is fine
	// Save the reference to the GUI object this FileMenuHandler is 
    // associated with
    private CarGUI gui;
   
    // Constructor that takes as its parameter the GUI associated 
    // with this FileMenuHandler
    public FileMenuHandler(CarGUI gui) 
    {
        this.gui = gui;
    }
    
    public void actionPerformed(ActionEvent event) 
    {
        // Get the command name from the event
        String menuName = event.getActionCommand();
        

        if (menuName.equals("Open")) //if Open is selected
        {
            // Create the object that will choose the file
            JFileChooser fc = new JFileChooser();

            // Attempt to open the file
            int returnVal = fc.showOpenDialog(null);

            // If user selected a file, create File object and pass it to
            // the gui's readFile method
            if (returnVal == JFileChooser.APPROVE_OPTION) 
            {
                File file = fc.getSelectedFile();               
                try {
                	
					this.gui.readFile(file); //calls readFile method in CarGUI class
					
				} catch (FileNotFoundException e) {
                    System.out.println(" There is no file");
					e.printStackTrace();
				}
            } 
            else if (returnVal == JFileChooser.CANCEL_OPTION)
            {
                System.out.println("Open command cancelled by user.");
            }
        } 
        else if (menuName.equals("Quit")) //if Quit is selected
        {
            System.exit(1); //end the program
        }
        else if (menuName.equals("Msg")) //if Msg is selected
        {
            JOptionPane.showMessageDialog(null, "You clicked on \'Msg\'"); //display this message
        } 
    } 
}


