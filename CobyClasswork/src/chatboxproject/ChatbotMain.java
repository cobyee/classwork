package chatboxproject;

import java.util.Scanner;

public class ChatbotMain {

	public static Chatbot chatbot = new Chatbot();
	//static means independent of instances. This chat bot represents the program itself, when the program runs if you want to access to
	//state of the program then you need to put a handle on it. You need to put an identifier on it so the identifier is the chat bot.
	
	public static void main(String[] args) {
		chatbot.startTalking();
	}
	private static Scanner inputSource = new Scanner(System.in);
	  

	 
	  
	  /**
	   *This method returns the index of keyword in searchString (after startPsn)where keyword is isolated and has no negations.
	   *It returns -1 if the keyword is not found.
	   */
	  
	public static int findKeyWord(String searchString, String keyword, int startPsn) {
		//makes lower case
		searchString = searchString.toLowerCase();
		keyword = keyword.toLowerCase();
		//find the first position after the startPsn
		int psn = searchString.indexOf(keyword, startPsn);
		  
		//keep searching until keyword is found (noNegations and isolated)
		while(psn >= 0) {
			  
		if(keywordIsIsolated(psn, keyword, searchString) && noNegations(searchString, psn)) {
			return psn;
		}else {
			//look for the next occurrence
			psn = searchString.indexOf(keyword, psn+1);
		}
	}
		  return -1;
	  }
	  
	  public static boolean keywordIsIsolated(int psn, String keyword, String s){
	    if(psn == 0) {
	    	if(s.substring(psn + keyword.length()).compareTo("a")<0) {
	    		return true;
	    	} else {
	    		return false;
	    	}
	    }
	    else {
	    	if(s.substring(psn-1).compareTo("a") < 0) {
	    		return true;
	    	}
	    	else {
	    		return false;
	    	}
	    }
	  }
	  
	  public static boolean noNegations(String s, int pos) {
			
			if(pos == 0 || pos < 3)
			{
				return true;
			}
			else
			{
				if(pos < 4)
				{
					return !(s.substring(pos - 3, pos - 1).equalsIgnoreCase("no"));
				}
				else
				{
					return !(s.substring(pos - 3, pos - 1).equalsIgnoreCase("no") || s.substring(pos - 4, pos - 1).equalsIgnoreCase("not"));
				}
			}
		}
	  
	  
	  public static String getInput(){
	    return inputSource.nextLine();
	  }
	  
	  public static void print(String s){
	    multiLinePrint(s);
	  }
	  
	  public static void multiLinePrint(String s){
		  String printString = "";
		  int cutoff = 55;
		  //this while loop last as long as there are words left in the original String
		  while(s.length() > 0){

			  String currentCut = "";
			  String nextWord = "";

			  //while the current cut is still less than the line length 
			  //AND there are still words left to add
			  while(currentCut.length()+nextWord.length() < cutoff && s.length() > 0){

				  //add the next word
				  currentCut += nextWord;
	 
				  //remove the word that was added from the original String
				  s = s.substring(nextWord.length());
	 
				  //identify the following word, exclude the space
				  int endOfWord = s.indexOf(" ");

				  //if there are no more spaces, this is the last word, so add the whole thing
				  if(endOfWord == -1) {
					  endOfWord = s.length()-1;//subtract 1 because index of last letter is one les than length
				  }

				  //the next word should include the space
				  nextWord = s.substring(0,endOfWord+1);
			  }

			  printString +=currentCut+"\n";

		  }
		  System.out.print(printString);
	  }

	 public static int getIntegerInput() {
		 print("Please enter an integer.");
		 String integerString = getInput();
		 boolean isInteger = false;
		 int value = 0;
		 while(!isInteger){
			 try{
				 value = Integer.parseInt(integerString);
				 //will not continue if an error above is thrown
				 isInteger = true;//exits loop if entry is valid
			 }catch(NumberFormatException e){
				 print("You must enter an integer. You better try again.");
				 integerString = getInput();
			 }
		 }
		 return value;
	 }
}
