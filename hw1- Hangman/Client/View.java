package homework1.client.view;

import homework1.client.net.TCP_Client;

//import java.io.*;
//import java.net.*;
//import java.util.*;

public class View {


	public static void view() {
		String k = "***HANGMAN***";
		String l = "Everytime a new game begins, press ENTER for new word";
		String m = "--> Press *** to QUIT";

		System.out.printf("%80s \n", k);
		System.out.printf("%100s \n", l);
		System.out.printf("%60s %-30s \n","", m);
		
		String a = "Word";
    	String b = "Remaining Failed Attempts";
    	String c = "Score";
    	System.out.printf("%60s\t%26s\t%10s \n", a,b,c);
	}
}