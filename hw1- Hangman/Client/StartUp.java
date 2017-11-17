import java.io.*;
import java.net.*;
import java.util.*;
import homework1.client.view.View;
import homework1.client.net.TCP_Client;

public class StartUp {
    
    	public static void main(String[] args) throws IOException,ClassNotFoundException {

    		View niceView = new View();
			niceView.view();
			TCP_Client client = new TCP_Client();
			client.play();
	}
}