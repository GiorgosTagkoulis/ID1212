package homework1.server.net;

import java.io.*;
import java.net.*;
import java.util.*;

public class TCP_Server {

    private static ServerSocket serverSocket;
    private static final int PORT = 1234;
  
    public static void main(String[] args) throws IOException {
        //System.out.println("Opening port ...\n");
        try{
        /* Step 1: Create a Server Socket with the indicating Port*/
            serverSocket = new ServerSocket(PORT);
        }
        catch(IOException ioEx){
            System.out.println("Unable to attach the port!");
            System.exit(1);
        }
        System.out.println("Server is up");
        do{
            Socket client = null;
            try{
                /* Wait for a client */
                client = serverSocket.accept();
                /* Create a thread to handle communication with this client and pass
                    the constructor for this thread a reference to the relevant socket */
                ClientHandle handler = new ClientHandle(client);
                /* Invoke the start() method for the run() method of ClientHandle */
                handler.start();
                //handleClient();
            }catch(NullPointerException e){
                System.out.println("Closing down connection");
                client.close();
            }
        }while(true);
    }
}