package dt062g.dawe1103.assignment8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import javax.swing.*;


public class WestPaint extends JFrame implements ActionListener, MouseMotionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private String name = "";
	private String author = "";
	
	private Container pane;
	private GridLayout gridLayout;
	private DrawingPanel drawingArea;
	private JLabel coordinates;
	private JPanel topPanel;
	private JPanel colorPanel;
	private JPanel greenPanel;
	private JPanel bluePanel;
	private JPanel blackPanel;
	private JPanel redPanel;
	private JPanel yellowPanel;
	private JPanel figurePanel;
	private JComboBox<String> figureList;
	private JPanel statusBar;
	private JLabel getColorLabel;
	private JPanel getColorPanel;
	private JPanel eastBlock;
	private JMenuBar mb;
	private JMenu menuFile;

	
	
	public WestPaint() {
		super();  
        createJFrame();       
        createMenu();     
        createContentPane(); 
	}

	
	private void createJFrame() {
		setLocation(450,250);
    	setSize(new Dimension(1060,545));
    	setMinimumSize(new Dimension(300,200));
    	setLayout(new BorderLayout());
    	setTitle("WestPaint");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon("images\\icon.png");
        setIconImage(img.getImage());	
	}

	private void createMenu() {

        mb = new JMenuBar();
        menuFile = new JMenu("File");
       
        JMenuItem newMenuItem = new JMenuItem("New...");
        menuFile.add(newMenuItem);
        
        newMenuItem.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		String inputName ="";
                String inputAuthor = "";
               
                inputName = JOptionPane.showInputDialog("Enter name of the drawing:");
                inputAuthor = JOptionPane.showInputDialog("Enter author of the drawing:");
               
                if((inputName != "" && inputName != null) && (inputAuthor != "" && inputAuthor != null)){
                    name = inputName;
                    author = inputAuthor;
                    setTitle("WestPaint - "+name+" by "+author);
                }else if((inputName != "" && inputName != null)) {
                    name = inputName;
                    author = inputAuthor;
                    setTitle("WestPaint - "+name);
                }else {
                    setTitle("WestPaint");
                }
 
                Drawing draw = new Drawing();
                
                drawingArea.repaint();
                drawingArea.setDrawing(draw);
                drawingArea.getDrawing().setName(inputName);
                drawingArea.getDrawing().setAuthor(inputAuthor);
        	}
        });
        
        
        JMenuItem saveMenuItem = new JMenuItem("Save as...");
        menuFile.add(saveMenuItem);
        
        saveMenuItem.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		Drawing theDrawing = drawingArea.getDrawing();
        		String fileName = "";
        		
        		if((name != "" && name != null) && (author != "" && author != null)){
        			String saveToFile = JOptionPane.showInputDialog("Save drawing to:", name+" by "+author+".xml");
        			fileName = saveToFile;
        		}else if((name != "" && name != null)) {
        			String saveToFile = JOptionPane.showInputDialog("Save drawing to:", name+".xml");
        			fileName = saveToFile;  			
        		}else {
        			String saveToFile = JOptionPane.showInputDialog("Save drawing to:", ".xml");
        			fileName = saveToFile;
        		}
        		
        		FileHandler.saveToXML(theDrawing, fileName);
        	}
        });
        
        
        JMenuItem loadMenuItem = new JMenuItem("Load...");
        menuFile.add(loadMenuItem);
        
        loadMenuItem.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		
        		String inputName = JOptionPane.showInputDialog("Load drawing from:");
        		
        		//declare object instance.
        		Drawing drawing = null;
        		
        	
        		try {	
	        		//loadFromXML should return Drawing-object.
	        		drawing = FileHandler.loadFromXML(inputName);
	        		
	        		// add the Drawing to the drawing area if drawing isn't null.
	        		if (drawing != null) {
	        			drawingArea.repaint();
		        		drawingArea.setDrawing(drawing);
		        		setTitle("WestPaint - "+drawingArea.getDrawing().getName()+" by "+drawingArea.getDrawing().getAuthor());
		        		name = drawingArea.getDrawing().getName();
		        		author = drawingArea.getDrawing().getAuthor();
	        		}
	        		else{
	        			JOptionPane.showMessageDialog(pane, "Wrong input, try again");
	        		}
	        		
        		}
        		catch(Exception e1) 
        		{
        			e1.printStackTrace();
      
        		}
        	}
        });
        
        
        JMenuItem info = new JMenuItem("Info");
        menuFile.add(info);
        menuFile.addSeparator();
        info.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		
				JOptionPane.showMessageDialog(pane,
						drawingArea.getDrawing().getName()+" by "+drawingArea.getDrawing().getAuthor()+"\n"+
						"Number of Shapes: "+drawingArea.getDrawing().getSize()+"\n"+
						"Total area: "+drawingArea.getDrawing().getTotalArea()+"\n"+
						"Total circumference: "+drawingArea.getDrawing().getTotalCircumference()
        		);
        	}
        });
        
        
        
        JMenuItem exitMenuItem = new JMenuItem("Exit...");
        menuFile.add(exitMenuItem);
        exitMenuItem.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) { System.exit(0); } });
        
        mb.add(menuFile);
        
        menuFile = new JMenu("Edit");
        JMenuItem undoMenuItem = new JMenuItem("Undo");
        menuFile.add(undoMenuItem);
        undoMenuItem.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        JMenuItem nameMenuItem = new JMenuItem("Name...");
        menuFile.add(nameMenuItem);
        nameMenuItem.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		String inputName = "";
        		inputName = JOptionPane.showInputDialog("Enter name of the drawing:");
        		drawingArea.getDrawing().setName(inputName);

        		if((inputName != "" && inputName != null) && author != ""){
        			name = inputName;
        			setTitle("WestPaint - "+name+" by "+author);
        		}else if((inputName != "" && inputName != null)) {
        			name = inputName;
        			setTitle("WestPaint - "+name);
        		}else {
        			setTitle("WestPaint");
        		}
        		
  
        	}
        });
        JMenuItem authorMenuItem = new JMenuItem("Author...");
        menuFile.add(authorMenuItem);
        authorMenuItem.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		String inputAuthor ="";
        		inputAuthor = JOptionPane.showInputDialog("Enter author of the drawing:");
        		drawingArea.getDrawing().setAuthor(inputAuthor);
        		
        		
           		if(name != "" && (inputAuthor != "" && inputAuthor != null)){
           			author = inputAuthor;
        			setTitle("WestPaint - "+name+" by "+author);
        		}else if(name != "" && name != null) {
        			setTitle("WestPaint - "+name);
        		}else {
        			setTitle("WestPaint");
        		}
        		
        	}
        });
        
        mb.add(menuFile);
        setJMenuBar(mb);
	}

	private void createContentPane() {		
		pane = getContentPane();
		gridLayout = new GridLayout();
		

		topPanel = new JPanel(new BorderLayout(0,0));
		topPanel.setPreferredSize( new Dimension(50, 50) );
		topPanel.setBackground(Color.GRAY);
		
		colorPanel = new JPanel();
		colorPanel.setLayout(gridLayout);
		
		// -- Color Panel --
		greenPanel = new JPanel();
		greenPanel.setBackground(Color.GREEN);
		greenPanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {getColorPanel.setBackground(greenPanel.getBackground()); }});
		colorPanel.add(greenPanel);
		
		
		
		bluePanel = new JPanel();
		bluePanel.setBackground(Color.BLUE);
		bluePanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {getColorPanel.setBackground(bluePanel.getBackground()); }});
		colorPanel.add(bluePanel);
		
		
		blackPanel = new JPanel();
		blackPanel.setBackground(Color.BLACK);
		blackPanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {getColorPanel.setBackground(blackPanel.getBackground()); }});
		colorPanel.add(blackPanel);
		
		
		redPanel = new JPanel();
		redPanel.setBackground(Color.RED);	
		redPanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {getColorPanel.setBackground(redPanel.getBackground()); }});
		colorPanel.add(redPanel);
		
		
		yellowPanel = new JPanel();
		yellowPanel.setBackground(Color.YELLOW);	
		yellowPanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {getColorPanel.setBackground(yellowPanel.getBackground()); }});
		colorPanel.add(yellowPanel);
		
		
		topPanel.add(colorPanel);
		
		figurePanel = new JPanel();
		
		//--- FigureList --
		String[] figureStrings = {"Rectangle", "Circle"};
		figureList = new JComboBox<String>(figureStrings);
		figureList.setSize(new Dimension(85, 50));
		
		
		figurePanel.add(figureList);
		topPanel.add(figurePanel, BorderLayout.EAST);
		pane.add(topPanel, BorderLayout.PAGE_START);
		
		statusBar = new JPanel(new BorderLayout());
		statusBar.setPreferredSize( new Dimension(100, 25) );
		
		pane.add(statusBar, BorderLayout.PAGE_END);

		drawingArea = new DrawingPanel();
		drawingArea.setBackground(Color.WHITE);
		;
		drawingArea.addMouseMotionListener(new MouseAdapter() 
		{
			public void mouseDragged(MouseEvent e) { coordinates.setText("Coordinates: " +e.getX()+", "+e.getY());	}
			public void mouseMoved(MouseEvent e) { coordinates.setText("Coordinates: " +e.getX()+", "+e.getY());	}});
		pane.add(drawingArea);
		
		
	
	
	
		
		coordinates = new JLabel("Coordinates: ");
		statusBar.add(coordinates, BorderLayout.WEST);
		
		
		eastBlock = new JPanel();
		getColorLabel = new JLabel("Selected Color: ");
		getColorPanel = new JPanel();
		
		getColorPanel.setPreferredSize(new Dimension(15,15));
		
		eastBlock.add(getColorLabel);	
		eastBlock.add(getColorPanel);
		
		statusBar.add(eastBlock,BorderLayout.EAST);
		
		
	}


	
	
	
	@Override
	public void mouseMoved(MouseEvent e) {
	}
	
	
	public void mouseDragged(MouseEvent e) {
	    
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {

	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}	
