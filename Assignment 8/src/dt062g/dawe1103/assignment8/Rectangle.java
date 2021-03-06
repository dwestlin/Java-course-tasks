package dt062g.dawe1103.assignment8;

import java.awt.Color;
import java.awt.Graphics;

import javax.xml.bind.annotation.XmlRootElement;

import dt062g.dawe1103.assignment8.NoEndPointException;

/**
* <h1>Rectangle</h1>
* This sub-class creates a rectangle from the super-class Shape. 
* It can calculate radius, circumference, area as well as print information about these.
*
* @author  Daniel Westlin (dawe1103)
* @version 1.0
* @since   2017-11-20
*/

@XmlRootElement
public class Rectangle extends Shape {

	
	Rectangle(){
		super();
	}
	
	Rectangle(Point p, String color){
		super(p, color);
	}
	
	
	Rectangle(double x, double y, String color){
	
		super(new Point(x,y), color);
		
	}
	
	public double getWidth() throws NoEndPointException
	{		
		try{
			double width;
			if(super.points.get(0).getValueX() > super.points.get(1).getValueX()) {
				width = super.points.get(0).getValueX() - super.points.get(1).getValueX();
				return width;
			}
			else {
				width = super.points.get(1).getValueX() - super.points.get(0).getValueX();
				return width;
			}
		}catch(IndexOutOfBoundsException e){ throw new NoEndPointException("The rectangle has no end point, it's width can not be calculated");	}
		
	
	}
	
	
	public double getHeight() throws NoEndPointException
	{
		
		try{
			double height;
			if(super.points.get(0).getValueY() > super.points.get(1).getValueY()) {
				height = super.points.get(0).getValueY() - super.points.get(1).getValueY();
				return height;
			}
			else {
				height = super.points.get(1).getValueY() - super.points.get(0).getValueY();
				return height;
			}
		}catch(IndexOutOfBoundsException e){ throw new NoEndPointException("The rectangle has no end point, it's height can not be calculated");	}
	}


	@Override
	public void draw() {
		System.out.println(toString());
		
	}


	@Override
	public void draw(Graphics g) {
		
		int x = (int) super.points.get(0).getValueX();
		int y = (int) super.points.get(0).getValueY();
		int w = 0;
		int h = 0;
		
		try {
			w = (int) this.getWidth();
		} catch (NoEndPointException e) {
			e.printStackTrace();
		}
		
	
		try {
			h = (int) this.getHeight();
		} catch (NoEndPointException e) {
			e.printStackTrace();
		}
		Color c = Color.decode(this.getColor());

		g.setColor(c);
		g.drawRect(x, y, w, h);
		g.fillRect(x, y, w, h);
		
	
		
	}


	@Override
	public double getCircumference() throws NoEndPointException{
		
		
		try {
			return (getHeight()*2)+(getWidth()*2);
		}catch(NullPointerException e){ throw new NoEndPointException("The rectangle has no end point, it's circumference can not be calculated");}
		
	}


	@Override
	public double getArea() throws NoEndPointException{		
		try {
			
			return (getHeight()*getWidth());
		}catch(IndexOutOfBoundsException e){ throw new NoEndPointException("The rectangle has no end point, it's area can not be calculated");}
	}
	
	
	public String toString(){
		
		try {
			return "Rectangle[start="+super.points.get(0)+"; end="+super.points.get(1)+"; width="+getWidth()+"; height="+getHeight()+"; color="+getColor()+"]";
		}catch(NullPointerException | NoEndPointException e) { return "Drawing a Rectangle[start="+super.points.get(0)+"; end=N/A; width=N/A; height=N/A; color="+getColor()+"]"; }
		
	}
	
}

