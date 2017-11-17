package homework1.server.controller;

import homework1.server.model.HangmanGame;
import java.util.*;
import java.io.*;
import java.net.*;

public class Controller{

	private BufferedReader br; 
	private PrintWriter pr;

	public Controller(BufferedReader br, PrintWriter pr){
		this.br = br;
		this.pr = pr;
	}

	public void hangman() {
		HangmanGame hg = new HangmanGame (br,pr);
		hg.hangman();
	}
}
