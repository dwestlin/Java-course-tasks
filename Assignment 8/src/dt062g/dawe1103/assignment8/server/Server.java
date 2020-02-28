package dt062g.dawe1103.assignment8.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import dt062g.dawe1103.assignment8.client.ClientHandler;
/**
* <h1>Server</h1>
* This class creates a server-like feature that connects the client to the server.
* 
*
* @author  Daniel Westlin (dawe1103)
* @version 1.0
* @since   2018-01-18
*/






public class Server {

	

	@SuppressWarnings("resource")
	public static void main(String [] args) throws IOException{
		
		// The port's default value is set to 10000
		int port = 10000;
		
		
		//If the arguments are more than 0, then it should set the port value from the input parameter
		if(args.length > 0) {	
			try {
				port = Integer.parseInt(args[0]);
			}catch(NumberFormatException e) {
				System.err.println("Couldn't convert port number to an integer, therefore it will be set to 10000.");
			}
			
		}
		
		// Creating an object of ServerSocket.
		ServerSocket ss = null; 
		
	
		// Creating an object of ServerSocket with the port-number.
		ss = new ServerSocket(port);	
		System.out.println("Server started on port: " + port);
		
		
		try {
		
			
			while(true){
			
				
			// Creates a socket object in anticipation of connected clients
			Socket s = ss.accept();
			
			
			// Creating and thread with that socket.
			new ClientHandler(s).start();
			
			
			}
		}catch(IOException ioe) { System.err.println("Connection from server is lost");}
		
	}
}
