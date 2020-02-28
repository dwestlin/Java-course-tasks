package dt062g.dawe1103.assignment8.client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;

/**
* <h1>ClientHandler</h1>
* This class is used to receive messages from the client and answer them.
* 
*
* @author  Daniel Westlin (dawe1103)
* @version 1.0
* @since   2018-01-18
*/


public class ClientHandler extends Thread{
	
	private Socket socket;
	private DataInputStream streamIn;
	private DataOutputStream streamOut;
	
	
	
	public ClientHandler(Socket s){
		socket = s;	

	}
	
	
	
	@Override
	public void run() {
		
		try {	
			//Setting up connection for both input and output streams
			streamOut = new DataOutputStream(socket.getOutputStream());
			streamIn = new DataInputStream(socket.getInputStream());
			
	
			
			System.out.println("New client connected from: " + socket.getInetAddress().getHostAddress()+":"+ socket.getPort());
			
			//Incoming string should determine what the server should do
			String answer = streamIn.readUTF();
			
			//Based on what incoming string says, it should be based on these options
			switch(answer) {			
				case "list" :
					System.out.println("Command 'list' received from "+ socket.getInetAddress().getHostAddress()+":"+ socket.getPort());
					listFileNames();
					break;	
				case "load" :
					System.out.println("Command 'load' received from "+ socket.getInetAddress().getHostAddress()+":"+ socket.getPort());
					getFileFromServer();
					break;
				case "save" :
					System.out.println("Command 'save' received from "+ socket.getInetAddress().getHostAddress()+":"+ socket.getPort());
					saveFileToServer();
					break;
						
				default: 
					System.out.println("Invalid input");
					break;
					
					
			}} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		

		//Finally, it will break the connection between server and client	
		try {
			disconnect();
		} catch (IOException e) {
			System.err.println("Coudln't disconnect "+socket.getInetAddress().getHostAddress()+":"+ socket.getPort());
		}
	}
	
	

	//This function will list all files contained in the server folder
	private void listFileNames() throws IOException {
		
		// the path to the directory stored on server
		File file = new File("xml"+File.separator+"server"+File.separator);
		
		// list all files in that directory
		File[] listOfFiles = file.listFiles();
		
		// create an array with all the files listed.
		String[] fileNames = new String[listOfFiles.length];
		
		int length = fileNames.length;
		
		//store every files in the array that ends with .xml 
		for(int i = 0; i < listOfFiles.length; i++) {
			if(listOfFiles[i].getName().endsWith(".xml")) {
				fileNames[i] = listOfFiles[i].getName();	
			}		
		}	
		
		//Sends a message to the client that tells it how long the array is.
		streamOut.writeInt(length);
		
		System.out.println("Sending list of files to "+ socket.getInetAddress().getHostAddress()+":"+ socket.getPort());
		
		// Sends every string stored in array.
		for (int i = 0; i < length; i++) {
			streamOut.writeUTF(fileNames[i]);
		}
		
	
	}
	
	//This function should send the requested file to the client
	private void getFileFromServer() throws IOException {
		
		// gets the filename from the client.
		String filename = streamIn.readUTF();
		
		//makes an file of it.
		File file = new File("xml"+File.separator+"server"+File.separator+filename);
		
		//creates an byte array
		byte[] content;
		
		//the content array shall gets every byte that the file consists of.
		content = Files.readAllBytes(file.toPath());
		

		System.out.println("Size of '"+filename+"' is "+content.length+" bytes");
		System.out.println("Sending file to "+ socket.getInetAddress().getHostAddress()+":"+ socket.getPort());
		
		
		// Send the length of the byte array.
		streamOut.writeInt(content.length);
		
		// Sends every byte to the client.
		for (int i = 0; i < content.length; i++)
		{
			streamOut.writeByte(content[i]);
		}
		
		System.out.println("File sent to "+ socket.getInetAddress().getHostAddress()+":"+ socket.getPort());	
		
	}


	// This function will save a client's file to the server's folder
	private void saveFileToServer() throws IOException {
		String fileName = streamIn.readUTF();
		

		// gets the length of the byte array from client.
		int length = streamIn.readInt();
		
		System.out.println("Receiving "+fileName+" from "+socket.getInetAddress().getHostAddress()+":"+ socket.getPort());
		
		
		//creates the array based on clients byte array.
		byte[] content = new byte[length];
		
		//receiving the array of bytes.
		for (int i = 0; i < length; i++)
		{
			content[i] = streamIn.readByte();
		}
		
	
		
		Files.write(new File("xml"+File.separator+"server"+File.separator+fileName).toPath(), content);
		System.out.println("File received from "+socket.getInetAddress().getHostAddress()+":"+ socket.getPort());
	
	}
	
	// disconnect function that closing the socket and streams. It also sets it to null.
	public void disconnect() throws IOException {
		try {
			System.out.println("Client "+ socket.getInetAddress().getHostAddress()+":"+ socket.getPort()+ " has disconnected");	
			socket.close();
			streamOut.close();
			streamIn.close();
			
			socket = null;
			streamOut = null;
			streamIn = null;
		}catch(IOException e) {}
	}

}
