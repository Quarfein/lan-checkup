import java.net.*;
import java.util.List;
import java.io.*;

public class client {
	// initialize socket and input output streams
    private Socket socket            = null;
    int closeConnection = 0;
 
    // constructor to put ip address and port
    public client(String address, int port, int index, Infos infos) throws ClassNotFoundException
    {
        // establish a connection
        try
        {
            socket = new Socket(address, port);
 
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            try
            {
            	while(closeConnection!=1) {
            	@SuppressWarnings("unchecked")
				List<String> received = (List<String>) objectInputStream.readObject();
            	String[] rec = new String[received.size()];
                for (int i = 0; i < received.size(); i++) {
                	rec[i] = received.get(i);
                }
                Infos.setInfos(index, rec);
            	}
            }
            catch(IOException i)
            {
                System.out.println(i);
                closeConnection = 1;
            }
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
 
        // close the connection
        try
        {
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
}
