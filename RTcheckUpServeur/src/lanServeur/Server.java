package lanServeur;

import java.net.*;
import java.util.List;
import java.io.*;

public class Server {
	private Socket          socket   = null;
	private ServerSocket    server   = null;
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
 
            OutputStream outputStream = socket.getOutputStream();
            // create an object output stream from the output stream so we can send an object through it
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
 
            List<String> toSend;
 
            while (connectionCloseFlag!=1)
            {
                try
                {
                    Infos infos = new Infos();
                    toSend = infos.getInfos();
                    
                    System.out.println("Sending infos to client");
                    objectOutputStream.writeObject(toSend);
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
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
}
