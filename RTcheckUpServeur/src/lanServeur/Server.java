package lanServeur;

import java.net.*;
import java.io.*;

public class Server {
	private Socket          socket   = null;
	private ServerSocket    server   = null;
	private DataInputStream in       =  null;
	private int connectionCloseFlag = 0;

    // constructor with port
    public Server(int port)
    {
    	
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            
            socket = server.accept();
            System.out.println("Client accepted");
 
            // takes input from the client socket
            in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
 
            String line = "";
 
            // reads message from client until "Over" is sent
            while (!line.equals("Over") && connectionCloseFlag==0)
            {
                try
                {
                    line = in.readUTF();
                    System.out.println(line);
 
                }
                catch(IOException i)
                {
                    System.out.println(i);
                    connectionCloseFlag=1;

                } 

            }
            System.out.println("Closing connection");
 
            // close connection
            socket.close();
            server.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
}
