package homework1.client.net;

import java.io.*;
import java.net.*;
import java.util.*;

public class ReadingFromServer extends Thread {

	private BufferedReader fromServer;

	public ReadingFromServer (Socket socket) throws IOException {
		fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	@Override
	public void run() {
		while(true){
			try {
				System.out.println(fromServer.readLine());
			}catch(IOException ioEx){
				System.out.println("Game finished");
				break;
			}
		}
	}
}