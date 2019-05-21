package dt062g.dawe1103.assignment2;

/**
* <h1>Point</h1>
*This is a class that takes in the X and Y values. The class also includes setters and getters for these
*
* @author  Daniel Westlin (dawe1103)
* @version 1.0
* @since   2017-11-16
*/

public class Point {

	
	public double valueX;
	public double valueY;
	
	public double getValueX() {
		return valueX;
	}

	public void setValueX(double x) {
		valueX = x;
	}

	public double getValueY() {
		return valueY;
	}

	public void setValueY(double y) {
		valueY = y;
	}

	public Point()
	{
		valueX = 0;
		valueY = 0;
	}
	
	public Point(double x, double y)
	{
		this.valueX = x;
		this.valueY = y;
	}
	
	public String toString() {
		return "(" +valueX + ", " + valueY + ")";
		
	}
	
	
}
