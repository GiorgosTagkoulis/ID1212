package homework1.server.model;

import java.util.*;
import java.io.*;
import java.net.*;

public class HangmanGame{

	private BufferedReader br; 
	private PrintWriter pr;

	public HangmanGame(BufferedReader br, PrintWriter pr){
		this.br = br;
		this.pr = pr;
	} 

	public void hangman() {
		
		HangmanGame hg = new HangmanGame(this.br, this.pr);
		
		/* Create the ArrayList from which I pick words*/
		ListOfWords.createList();
		
        int score = 0;
        boolean connected = true;

        while(connected){
        

        	/* Pick a work */
			String hangmanWord = hg.pickWord().toLowerCase();
			/* Prints the word to the server side for checking */
			System.out.println(hangmanWord);

			/* The String array that I will check the characters the client sends*/
			String [] splittedWord = hangmanWord.split("");
			//System.out.println(Arrays.toString(splittedWord));
		
			/* Create an array of characters in the form of String */
			String[] forClient = new String[hangmanWord.length()];
		
			/* Create an array of "_" to send to the client to play */
			for (int i=0 ; i < hangmanWord.length(); i++)
				forClient[i] = "_";
			//System.out.println("Its length is: " + hangmanWord.length());
			//System.out.println(Arrays.toString(forClient));

			int remainingMistakes = hangmanWord.length() +1 ;
			String input;

			while (remainingMistakes != 0) {
				
				try{
					
					input = br.readLine();

					boolean letterExist = false;
					for (int i=0 ; i < hangmanWord.length() ; i++)
						if(input.equals(splittedWord[i])){
							forClient[i] = input;
							letterExist = true;
						}
					if(!letterExist)
						remainingMistakes--;

					if(0 == remainingMistakes){
						score--;
					}	

					if(Arrays.equals(splittedWord, forClient)){
						score++;
						remainingMistakes = 0; //break;
					}

					if (input.equals(hangmanWord)){
						score++;
						forClient = splittedWord;
						remainingMistakes = 0; //break;
					}

					pr.printf("%60s\t%26d\t%10d  \n", Arrays.toString(forClient),remainingMistakes, score);
					
				}catch(java.lang.NullPointerException e){
					System.out.print("Game ended for: ");
					connected = false;
					break;
				}catch(IOException ioEx){
					System.out.println("ioException");
				}
			}

		}			 
	}

	String pickWord () {

		/* I need to pick a random word for the game */ 
		int positionOfWord = 0;
		try{
			// Create a Random object of java.util.* package
			Random r = new Random();
			positionOfWord = r.nextInt(ListOfWords.words.size()-1);

		}catch(IllegalArgumentException iaEx){
			System.out.println("The integer for Random is not positive");
		}

		/*The word that the server will send to the client*/
		String hangmanWord = ListOfWords.words.get(positionOfWord);
		
		return hangmanWord;
	}
}