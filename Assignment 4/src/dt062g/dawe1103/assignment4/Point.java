package dt062g.dawe1103.assignment4;

/**
* <h1>Point</h1>
*This is a class that takes in the X and Y values. The class also includes setters and getters for these
*
* @author  Daniel Westlin (dawe1103)
* @version 1.0
* @since   2017-11-20
*/

public class Point {

	
	public double X;
	public double Y;
	
	public double getX() {
		return X;
	}

	public void setX(double x) {
		X = x;
	}

	public double getY() {
		return Y;
	}

	public void setY(double y) {
		Y = y;
	}

	public Point()
	{
		X = 0;
		Y = 0;
	}
	
	public Point(double x, double y)
	{
		this.X = x;
		this.Y = y;
	}
	
	public String toString() {
		return "(" +X + ", " + X + ")";
		
	}
	
	
}
