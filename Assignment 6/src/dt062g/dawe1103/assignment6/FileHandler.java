package dt062g.dawe1103.assignment6;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class FileHandler {

	public FileHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public static void saveToXML(Drawing drawing, String fileName) {	
		try {
			StringBuilder file = new StringBuilder();
			String fName;
			if(!fileName.endsWith(".xml"))
			{
				file.append(fileName+".xml");
				fName = file.toString();
			}else {
				fName = fileName;
			}
			
			JAXBContext context = JAXBContext.newInstance(Drawing.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(drawing, new File(fName));
			
		}catch(JAXBException e) { System.err.println("Something went wrong when trying to Save to XML!");
		}
		
	}
	
	public static void saveToXML(Drawing drawing) throws JAXBException {
		
		StringBuilder file = new StringBuilder();
		file.append(drawing.getName()+" by "+drawing.getAuthor()+".xml");
		
		String fileName = file.toString();		
		saveToXML(drawing, fileName);
	}
	
	public static Drawing loadFromXML(String fileName)  {
		Drawing draw =null; 
		try {		
			JAXBContext context = JAXBContext.newInstance(Drawing.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			draw = (Drawing) unmarshaller.unmarshal(new File(fileName));
			return draw;
		}catch(JAXBException e) {System.err.println("Something went wrong, check your file name again!"); return draw; }
		
	}

}
