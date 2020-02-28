package dt062g.dawe1103.assignment8;



import java.awt.Color;
import java.awt.Graphics;


import javax.swing.JPanel;


public class DrawingPanel extends JPanel{


	private static final long serialVersionUID = 1L;
	private Drawing drawing;
	
	
	
	public DrawingPanel() 
	{
		drawing = new Drawing();
	}
	
	
	public DrawingPanel(Drawing d)
	{
		drawing = d;		
	}
	
	
	public void setDrawing(Drawing d)
	{
		drawing = d;
	}
	
	
	
	public void addDrawing(Drawing d)
	{
		//Set the author and name from the old drawings
		drawing.setAuthor(d.getAuthor());
		drawing.setName(d.getName());
		
		for( Shape item : d.getShape())
		{
			drawing.addShape(item);
		}
		
	

	}
	
	
	public Drawing getDrawing()
	{
		return drawing;
	}

	
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		super.repaint();
		

		if(drawing.getSize() > 1)
		{
			drawing.draw(g);
		}
		
	}
	
	
}
