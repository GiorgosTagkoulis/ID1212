package homework1.server.model;

import java.util.*;
import java.io.*;


class ListOfWords {

	public static ArrayList<String> words = new ArrayList<String>();

	static void createList (){
		
		/* Location of the file */
		File file = new File("words.txt");
		
		try{
				/* Scanner from the file */
				Scanner in = new Scanner(file);

				/* While there is more words in the text, add them in the List */
				while(in.hasNext()){
				String word = in.next();
				words.add(word);
				}	
				/* Closing the Scanner to avoid abnormalities */
				in.close();
		}catch(FileNotFoundException fnfEx){
			fnfEx.printStackTrace();
		}
	}
}