package dt062g.dawe1103.assignment5;
/**
* <h1>Drawing</h1>
* This is a class that stores the Shape objects and then prints information about it.
*
* @author  Daniel Westlin (dawe1103)
* @version 1.0
* @since   2017-11-20
*/


import java.awt.Graphics;
import java.util.ArrayList;

import dt062g.dawe1103.assignment5.Drawable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Drawing implements Drawable{
	
	@XmlElement
	private String name;
	
	@XmlElement
	private String author;
	
	@XmlElement(name="shape")
	private ArrayList<Shape> shapes;
	
	public Drawing() {
		name = "";
		author = "";
		shapes = new ArrayList<Shape>(2);
	}
	
	public Drawing(String name, String author) {
		this.name = name;
		this.author = author;
		shapes = new ArrayList<Shape>(2);
	}
	
	public String getName() {return name;}

	public void setName(String name) { this.name = name;}

	public String getAuthor() { return author;}

	public void setAuthor(String author) { this.author = author; }
	
	public void addShape(Shape s) {		
		if(s != null) {
			shapes.add(s);
		}		
	}
	
	public int getSize() {
		return shapes.size();
		
	}
	
	public double getTotalCircumference() {
		double total = 0 ;
		for(int i = 0; i < shapes.size(); i++)
		{
			try {			
				shapes.get(i).getCircumference();
				total+= shapes.get(i).getCircumference();				
			} catch (NoEndPointException e) {}
		}
			return total;	
		
		
	}
	
	public double getTotalArea(){
		double total = 0;
		for(int i = 0; i < shapes.size(); i++)
		{
			try {
				
				shapes.get(i).getArea();
				total+= shapes.get(i).getArea();
			
			}catch (NoEndPointException e) {}
		}	
		return total;
	}
	
	
	public void clear() {
		shapes.clear();
		name = "";
		author = "";
	}

	@Override
	public void draw() {
		System.out.println(toString());
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString(){
			
		 try {
			 
			 if(getTotalCircumference() > 0 && getTotalArea() > 0)
			 {					 
				 StringBuilder s = new StringBuilder();
				 
				 shapes.forEach(shapes->s.append(shapes+"\n"));
				 
				 String result = s.toString();
				 
				 return "A drawing by "+getAuthor()+" called "+getName()+"\n"+result;
			 }
			 
			 
			return "Drawing[name=" + getName() + "; author=" + getAuthor() + "; size=" + getSize() +"; circumference=" + getTotalCircumference() +"; area=" + getTotalArea() +"]";
			} catch (NullPointerException e) { return "Drawing[name=" + getName() + "; author=" + getAuthor() + "; size=" + getSize() +"; circumference=0; area=0]";} 
		
	}
		
	}		

