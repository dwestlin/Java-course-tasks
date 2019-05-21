package dt062g.dawe1103.assignment1;
/**
* <h1>Assignment 1 - Calculate area of circle or rectangle</h1>
* This program allows the user to decide if it wants an area of a circle or rectangle.
* The user determines the size of the figure and then the program manages the calculation.

* @author Daniel Westlin (dawe1103)
* @version 1.0
* @since 2017-11-07
*/

//To call IOException and BufferedReader we need to import the I / O package.
import java.io.*;

public class calculateFigures {

	// Creates an static object of BufferedReader that is in use when the user input
	// from the keyboard.
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));


	// In the main method the user will be getting info how the application works.
	// Then the user input either circle, rectangle or exit as input, and based on the input,
	// it will call the desired method.
	public static void main(String[] args) throws IOException {

		// The information is printed on the console,
		// so that the user knows how the program is built.
		System.out.println("Enter to calculate area on a circle or rectangle");
		System.out.println("Enter exit to exit the program");

		/*
		 * Declares an string variable that is used as input of what shape
		 * the application will calculate
		 */
		String answer;

		//boolean variable that is set as true. When the exit-method is being
		//called, it will set as false value.
		boolean again = true;

		/**
		 * do-while loop as long as boolean again value is true.
		 * Inside the loop it has an switch-case where the decided methos is called.
		 */
		do {
			System.out.println("What geometric shape do you want to use?: ");
			answer = input.readLine();

			switch(answer) {

			case "circle": circleFigure();
				break;
			case "rectangle": rectangleFigure();
				break;
			case "exit": goodbye(); again = false;
				break;
			default: invalidInput();
			}

		}while(again);

	}

	/**
	 * Method that prints out a exit-message.
	 */
	private static void goodbye() {
		System.out.println("Good bye!");

	}

	/**
	 * Method that prints out that input is wrong.
	 */
	private static void invalidInput() {
		System.out.println("Unknown shape!");
	}

	/**
	 * Method that calculates circles circumference and area.
	 */
	private static void circleFigure() throws IOException {

		final double PI = 3.14;

		System.out.println("Enter Radius");
		String answer = input.readLine();
		double radius= Double.parseDouble(answer);

		double circumference = PI * (2*radius);
		double area = PI * radius * radius;

		System.out.println("Circumference: " + circumference);
		System.out.println("Area: " + area);

	}

	/*
	 * Method that calculates rectangle circumference and area.
	 */
	private static void rectangleFigure() throws IOException {


		System.out.println("Enter width");
		String inputWidth = input.readLine();
		double width= Double.parseDouble(inputWidth);

		System.out.println("Enter height");
		String inputHeight = input.readLine();
		double height= Double.parseDouble(inputHeight);

		double circumference = (2*width)+(2*height);
		double area = height * width;

		System.out.println("circumference: " + circumference);
		System.out.println("area: " + area);


	}
}
