package dt062g.dawe1103.assignment8.client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;

/**
* <h1>Client</h1>
* This class symbolizes the information sent from the Client to the server
* 
*
* @author  Daniel Westlin (dawe1103)
* @version 1.0
* @since   2018-01-18
*/


public class Client {

	// variables
	public static String DEFAULT_ADDRESS = "localhost";
	public static int DEFAULT_PORT = 10000;
	private Socket s = null;
	DataOutputStream streamOut;
	DataInputStream streamIn;

	// ---------------
	
	//Constructors
	@SuppressWarnings("static-access")
	public Client(String DEFAULT_ADDRESS, int DEFAULT_PORT) throws UnknownHostException, IOException {
		this.DEFAULT_ADDRESS = DEFAULT_ADDRESS;
		this.DEFAULT_PORT = DEFAULT_PORT;
	}
	

	
	@SuppressWarnings("static-access")
	public Client() throws UnknownHostException, IOException {
		this.DEFAULT_ADDRESS = "localhost";
		this.DEFAULT_PORT = 10000;
	}
	
	// ----------------
	
	
	// connect function that returns true if a connection is established and false if it already established.
	public boolean connect() throws UnknownHostException, IOException {
		try {
	
			if(s == null) {
				s = new Socket(DEFAULT_ADDRESS, DEFAULT_PORT);
				streamOut = new DataOutputStream(s.getOutputStream());
				streamIn = new DataInputStream(s.getInputStream());
				
	
						
				return true;
			}
			else {
				return false;}
		}catch(UnknownHostException uhe) {return false;}	
	}
	
	
	// disconnect function that closing the socket and streams. It also sets it to null.
	public void disconnect() throws IOException {
		try {
	
			s.close();
			streamOut.close();
			streamIn.close();
			
			s = null;
			streamOut = null;
			streamIn = null;
		}catch(IOException e) {}
	}
	
	
	// Help function that take cares of the message to server.
	private void sendMessageToServer(String message){
		  try {
	            streamOut.writeUTF(message);
	            streamOut.flush();
	        }
	        catch (IOException ioe) {
	            System.err.println("ERROR: Failed to send message");
	        }
	}

	
	// Function that gets all filenames from server. it returns an String array of every filename. If it can't connect, it will return null.
	public String[] getFilenamesFromServer() throws UnknownHostException, IOException {
		String[] fileName = null;

		if(connect()) {
			sendMessageToServer("list");
			fileName = getTheFileNames();
			disconnect();
			
			return fileName;
		}
		
		return null;
	}


	// Function that get an certain file from server. It's parameter decides which file it will get.
	public String getFileFromServer(String string) throws UnknownHostException, IOException {
		String fileName = null;
		
		if(connect()) {
			sendMessageToServer("load");	
			fileName = getFile(string);
			disconnect();
			return fileName;	
		}
		
		return null;
	}


	// Function that saves a local file to the server.
	public boolean saveAsFileToServer(String clientFilename, String serverFilename) throws UnknownHostException, IOException {
		
		if(connect()){
			sendMessageToServer("save");
			sendFileToServer(clientFilename, serverFilename);
			disconnect();
			return true;
		}	
		return false;
	}
	
	
	// Saving a local file to the server.
	public void saveFileToServer(String clientFilename) throws IOException {
		
		if(connect()){
			sendMessageToServer("save");
			localFileToServer(clientFilename);
			disconnect();
		}	
		
		
	}
	
	
	
	// Self made function that takes care of the communication to the server.
	
	
	



	// My own functions 
	
	//Function that handles the communication with the server and getting and desired file and saving it to a local place.
	private String getFile(String file) throws IOException {
		try {
			streamOut.writeUTF(file);
			int length = 0;
			length = streamIn.readInt();
		
			
			byte[] content = new byte[length];
			
			for(int i = 0; i < content.length; i++) {
				content[i] = streamIn.readByte();
			}
			
			if(length == 0)
			{
				return "";
			}
			final String xmlClientPath = "C:" + File.separator + "Java" + File.separator + "Assignment8"+File.separator+"xml"+File.separator+"client"+File.separator;
			String fullPath = xmlClientPath+file;
			
			Files.write(new File("xml"+File.separator+"client"+File.separator+file).toPath(), content);
			
			
			return fullPath;
		}catch(IOException e) { return null;}
	}
	
	
	// Function that takes two arguments. It search for the clients filename and sending a message to the server a filename for the server.
	private void sendFileToServer(String clientFilename, String serverFilename) throws IOException {
		
		File file = new File("xml"+File.separator+"client"+File.separator+clientFilename);
		
		byte[] content;
		
		content = Files.readAllBytes(file.toPath());
		
		streamOut.writeUTF(serverFilename);
		
		streamOut.writeInt(content.length);
		
		for (int i = 0; i < content.length; i++)
		{
			streamOut.writeByte(content[i]);
		}
		
	}

	
	// Listing all filenames that exists in the server folder
	private String[] getTheFileNames() throws IOException {	
		try {
			String[] fileName = null;
			
			int length = streamIn.readInt();
			
			if(length == 0) {
				fileName = new String[0];
				return fileName;
			}
			
			fileName = new String[length];
			
			for (int i = 0; i < length; i++) {
				fileName[i] = streamIn.readUTF();
			}	
			return fileName;
		}catch (IOException e){ return null;}
	}
	
	
	
	// saving a local file to the server.
	 private void localFileToServer(String clientFilename) throws IOException {
		 File file = new File("xml"+File.separator+"client"+File.separator+clientFilename);
		
		 byte[] content;
			
		content = Files.readAllBytes(file.toPath());
		
		streamOut.writeUTF(clientFilename);
		
		streamOut.writeInt(content.length);
		
		for (int i = 0; i < content.length; i++)
		{
			streamOut.writeByte(content[i]);
		}
	 
		
	}
	
}
