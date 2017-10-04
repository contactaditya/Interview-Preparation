import java.util.*;
import java.io.*;

 public class WordBreak {
	 
	public static boolean wordBreak(String string, List<String> wordDictionary) {
	   if(string == null || string.length() == 0) {
	     return true;
	   }
	   boolean [] dp = new boolean[string.length()+1];
	   dp[0] = true ;
	               
       for(int i=1; i<=string.length(); i++) {
         dp[i] = false;
         for(int j=0; j<i; j++) {
           if(dp[j] && wordDictionary.contains(string.substring(j, i))) {
              dp[i] = true;
           }
         }
       }
	   
	   return dp[string.length()];     
	}	 
 
	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number of words in the dictionary: ");
	  int numberOfWords = input.nextInt();
	  System.out.println();
	  input.nextLine();
	  System.out.println("Please enter the actual words in the dictionary: ");
	  ArrayList<String> dictionary = new ArrayList<String>();
	  for (int i = 0; i < numberOfWords; i++) {
		dictionary.add(input.nextLine());
	  }		 
	  System.out.println();
	  String string = new String();	
	  System.out.print("Enter a non empty string: ");
	  string = input.nextLine();  
	  boolean searchResult = wordBreak(string, dictionary); 
	  System.out.println();
	  if(searchResult) {
	    System.out.println("The word " + string + " can be segmented into a space-separated sequence of one or more dictionary words.");
	  }
	  else {
		System.out.println("The word " + string + " cannot be segmented into a space-separated sequence of one or more dictionary words.");
	  }
	}
 }
