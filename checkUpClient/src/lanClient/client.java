package lanClient;

import java.net.*;
import java.io.*;

public class client {
	// initialize socket and input output streams
    private Socket socket            = null;
    private DataInputStream  in   = null;
    private DataOutputStream out     = null;
 
    // constructor to put ip address and port
    public client(String address, int port)
    {
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
 
            // takes input from terminal
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));
 
            // sends output to the socket
            out    = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
 
        // string to read message from input
 
        // keep reading until "Over" is input
            try
            {
            	String line;
                out.writeUTF("test");
                line = in.readUTF();
                if (line == "succeed") {
                	System.out.println(line);
                	out.writeUTF("Over");
                }
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
 
        // close the connection
        try
        {
            in.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
}
