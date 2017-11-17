package homework1.client.net;

import java.io.*;
import java.net.*;
import java.util.*;

public class TCP_Client {
    
    private static InetAddress host;
    private static final int PORT = 1234;
    private static Socket socket;
    private PrintWriter toServer;

    public static void play() throws IOException, ClassNotFoundException{
        
        TCP_Client client = new TCP_Client();
        
        client.connect(host ,PORT);
        client.writingToServer();
    }

    private void connect(InetAddress host, int port) throws IOException {
        try{
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException uhEx){
            System.out.println("\nHost not found\n");
            System.exit(1);
        }
        socket = new Socket(host, PORT);
        ReadingFromServer object = new ReadingFromServer(socket);
        toServer = new PrintWriter(socket.getOutputStream(),true);
        object.start();
    }

    private void writingToServer() throws IOException, ClassNotFoundException{
          
            //Set up in stream for keyboard entry...
            Scanner userEntry = new Scanner(System.in);
            
            String message;
            while (true){
                message = userEntry.nextLine();
                if (message.equals("***")){
                    socket.close();
                    break;
                }
                try{
                    toServer.println(message);
                }catch(java.lang.NullPointerException e){
                    System.out.println("You have exited the game");
                }
            }
        }
}