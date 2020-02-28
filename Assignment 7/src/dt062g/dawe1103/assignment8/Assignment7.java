package dt062g.dawe1103.assignment8;

import javax.swing.SwingUtilities;

/**
* <h1>Assignment 6</h1>
* This class is the starting point for the drawing application.
* It creates our JFrame and makes it visible.
* 
*
* @author  Daniel Westlin (dawe1103)
* @version 1.0
* @since   2017-11-24
*/
public class Assignment7 {

	public static void main(String[] args) {
		// Make sure GUI is created on the event dispatching thread
		// This will be explained in the lesson about threads
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			
				new WestPaint().setVisible(true);
				
			}
		});		
	}
}