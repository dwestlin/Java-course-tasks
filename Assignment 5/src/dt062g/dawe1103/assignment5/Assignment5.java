package dt062g.dawe1103.assignment5;

import dt062g.dawe1103.assignment5.Circle;
import dt062g.dawe1103.assignment5.Rectangle;
import dt062g.dawe1103.assignment5.Shape;

/**
* <h1>Assignment 5</h1>
* This application creates a <code>Drawing</code> with a name,
* author and different shapes in it. It then saves the drawing
* to XML, clear the drawing and then loads a drawing from XML. 
*
* @author  Daniel Westlin
* @version 1.0
* @since   2017-11-21
*
*/
public class Assignment5 {

	public static void main(String[] args) {
		testDrawing();
	}

	private static void testDrawing() {
		// Create a drawing with a name and author.
		System.out.println("Create a drawing...\n");
		Drawing d1 = new Drawing();
		d1.setName("Mona Lisa");
		d1.setAuthor("L. da Vincis");
			
		// Create at least 5 shapes with end points
		Shape face = new Rectangle(100,100, "ffe0bd"); // RGB(255,224,189)
		Shape leftEye = new Circle(75, 75, "0000ff"); // RGB(0, 0, 255)
		Shape rightEye = new Circle(125, 75, "0000ff"); // RGB(0, 0, 255)
		Shape nose = new Rectangle(95, 100, "000000"); // RGB(0, 0, 0)
		Shape mouth = new Rectangle(55, 130, "ff0000"); // RGB(255, 0, 0)
		
		face.addPoint(175, 100);
		leftEye.addPoint(85, 75);
		rightEye.addPoint(135, 75);
		nose.addPoint(105, 115);
		mouth.addPoint(145, 140);
		
		// Add shapes to the drawing
		d1.addShape(face);
		d1.addShape(leftEye);
		d1.addShape(rightEye);
		d1.addShape(nose);
		d1.addShape(mouth);
		
		// Print the drawing
		d1.draw();
		
		// Save the drawing to XML
		final String fileName = "Mona Lisa.xml";
		System.out.println("\nSave the drawing to " + fileName + "...");
		FileHandler.saveToXML(d1, fileName);
		
		// Clear and print
		System.out.println("\nClearing the drawing and then draw it....");
		d1.clear();
		d1.draw();
		
		// Load drawing from XML
		System.out.println("\nLoad drawing from " + fileName + "...\n");
		d1 = FileHandler.loadFromXML(fileName);
		
		// Print the drawing
		d1.draw();
	}
}