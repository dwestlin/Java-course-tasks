package dt062g.dawe1103.assignment3;

/**
* <h1>Point</h1>
*This is a class that takes in the X and Y values. The class also includes setters and getters for these
*
* @author  Daniel Westlin (dawe1103)
* @version 1.0
* @since   2017-11-16
*/

public class Point {

	
	public double x;
	public double y;
	
	public double getX() {
		return x;
	}

	public void setValueX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setValueY(double y) {
		this.y = y;
	}

	public Point()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" +x + ", " + y + ")";
		
	}
	
	
}