package dt062g.dawe1103.assignment5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
* <h1>Point</h1>
*This is a class that takes in the X and Y values. The class also includes setters and getters for these
*
* @author  Daniel Westlin (dawe1103)
* @version 1.0
* @since   2017-11-20
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Point {

	@XmlElement
	public double x;
	@XmlElement
	public double y;
	
	public double getValueX() {
		return x;
	}

	public void setValueX(double x) {
		this.x = x;
	}

	public double getValueY() {
		return y;
	}

	public void setValueY(double y) {
		this.y = y;
	}

	public Point() {
		
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
