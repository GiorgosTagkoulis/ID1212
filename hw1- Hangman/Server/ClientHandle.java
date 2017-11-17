package homework1.server.net;

import java.io.*;
import java.net.*;
import java.util.*;
import homework1.server.controller.Controller;

public class ClientHandle extends Thread {

        private Socket client;
        private BufferedReader input;
        private PrintWriter output;

		public ClientHandle (Socket socket){
			/* Set up reference to associated socket */
			client = socket;
			try{
				input = new BufferedReader(new InputStreamReader(client.getInputStream()));
				output = new PrintWriter (client.getOutputStream(),true);
			} catch (IOException ioEx){
				ioEx.printStackTrace();
			}
		}        

		public void run(){
			
			System.out.println(Thread.currentThread().getName() + " is connected");
			Controller game = new Controller(input, output);
			game.hangman();
			
			try{
				//if(client != null) {
					System.out.println(Thread.currentThread().getName());
					client.close();				
				}catch(IOException ioEx){
				System.out.println("Unable to disconnect!");
				System.exit(1);
				}
			
		}
}

