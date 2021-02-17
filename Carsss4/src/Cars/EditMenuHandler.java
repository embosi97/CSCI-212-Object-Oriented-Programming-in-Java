package Cars;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.File;
import java.io.FileNotFoundException;
public class EditMenuHandler implements ActionListener 
{
//this code is fine
	// Save the reference to the GUI object this FileMenuHandler is 
    // associated with
    private CarGUI gui;
   
    // Constructor that takes as its parameter the GUI associated 
    // with this FileMenuHandler
    public EditMenuHandler(CarGUI gui) 
    {
        this.gui = gui;
    }
    
    public void actionPerformed(ActionEvent event) 
    {
        // Get the command name from the event
        String menuName = event.getActionCommand();
        

        if (menuName.equals("Search")) //if Search is selected
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
                	
                	this.gui.searchFile(file);
					
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
    }
}