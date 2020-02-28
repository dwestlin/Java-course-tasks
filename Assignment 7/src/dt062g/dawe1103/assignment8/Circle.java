package dt062g.dawe1103.assignment8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import dt062g.dawe1103.assignment8.NoEndPointException;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
/**
* <h1>Circle</h1>
* This sub-class creates a circle from the super-class Shape. 
* It can calculate radius, circumference, area as well as print information about these.
*
* @author  Daniel Westlin (dawe1103)
* @version 1.0
* @since   2017-11-24
*/


@XmlRootElement
public class Circle extends Shape{

	@XmlTransient
	final double pi = 3.14;
	
	Circle(){
		super();
	}
	
	Circle(Point p, String color){
		super(p, color);
	}
	
	
	Circle(double x, double y, String color){
		super(new Point(x,y), color);
		
	}
	
	
	public double getRadius() throws NoEndPointException {
			
			try {
				double squareRadius;
				double xCord;
				double yCord;
				double radius;

				if(super.points.get(0).getValueX() > super.points.get(1).getValueX()) {
					xCord = super.points.get(0).getValueX() - super.points.get(1).getValueX();
					if(super.points.get(0).getValueY() > super.points.get(1).getValueY())
						yCord = super.points.get(0).getValueY() - super.points.get(1).getValueY();
					else {
						yCord = super.points.get(1).getValueY() - super.points.get(0).getValueY();
					}
					squareRadius = (yCord*yCord)+(xCord*xCord);
					
					radius = Math.sqrt(squareRadius);
					return radius;
						
				}
				else {
					xCord = super.points.get(1).getValueX() - super.points.get(0).getValueX();
					if(super.points.get(0).getValueY() > super.points.get(1).getValueY())
						yCord = super.points.get(0).getValueY() - super.points.get(1).getValueY();
					else {
						yCord = super.points.get(1).getValueY() - super.points.get(0).getValueY();
					}
					squareRadius = (yCord*yCord)+(xCord*xCord);
					
					radius = Math.sqrt(squareRadius);
					return radius;
				}
			}catch(IndexOutOfBoundsException e){ throw new NoEndPointException("The circle has no end point, it's radius can not be calculated");}
		}
			
	

	@Override
	public void draw() {
		System.out.println(toString());
		
	}


	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		int x = (int) super.points.get(0).getValueX();
		int y = (int) super.points.get(0).getValueY();
		int w = 0;
		int h = 0;
		int radius = 0;
		
		try {
			w = (int) this.getRadius()*2;
			h = (int) this.getRadius()*2;
			radius = (int) this.getRadius();
			
			y = y - radius;
			x = x - radius;
			
			Color c = Color.decode(this.getColor());
			g2.setColor(c);
			g2.drawOval(x,y,w,h);
			g2.fillOval(x, y, w, h);
			System.out.println(c.toString());
			RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setRenderingHints(rh);
		} catch (NoEndPointException e) {
			e.printStackTrace();
		}
		

		
	}


	@Override
	public double getCircumference() throws NoEndPointException {
		
		try {
			return (getRadius()*2)*pi;
		}catch(NullPointerException e){ throw new NoEndPointException("The circle has no end point, it's circumference can not be calculated");}
	}


	@Override
	public double getArea() throws NoEndPointException {

		try {
			return (getRadius()*getRadius())*pi;
		}catch(NullPointerException e){ throw new NoEndPointException("The circle has no end point, it's area can not be calculated");}
	}
	
	public String toString() {
	
		try {
			return "Circle[start="+super.points.get(0)+"; end="+super.points.get(1)+"; radius="+getRadius()+"; color="+getColor()+"]";
		}catch(NullPointerException | NoEndPointException e) {return "Drawing a Circle[start="+super.points.get(0)+"; end=N/A; radius=N/A color="+getColor()+"]"; }
	
	}
	
}
