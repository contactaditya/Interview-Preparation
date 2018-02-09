import java.util.*;
import java.io.*;

  public class ShortestCompletingWord {
	  
	public static String shortestCompletingWord(String licensePlate, String[] words) {
	  int[] target = count(licensePlate);
      String answer = "";
      for (String word: words) {
        if ((word.length() < answer.length() || answer.length() == 0) && dominates(count(word.toLowerCase()), target)) {
           answer = word;
        }
      }
      return answer;
	}	  

	private static boolean dominates(int[] count1, int[] count2) {
      for (int i = 0; i < 26; i++) {
	    if (count1[i] < count2[i]) {
	       return false;
	    }
      }
	  return true;
	}

	private static int[] count(String word) {
	  int[] answer = new int[26];
      for (char letter: word.toCharArray()) {
        int index = Character.toLowerCase(letter) - 'a';
        if (index >= 0 && index < 26) {
          answer[index]++;
        }
      }
      return answer;
	}

	public static void main(String[] args) {    
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the dictionary: ");
	  int numbers = input.nextInt();   
	  String array[] = new String[numbers];
		    
	  System.out.println();
	  input.nextLine();
	  System.out.print("Please enter the actual values in the dictionary: ");
	  System.out.println();
	  for (int i = 0; i < numbers; i++) {
		array[i] = input.nextLine(); 
	  }
	  String word = new String();	
	  System.out.println();	
	  System.out.print("Enter the word: ");
	  word = input.next();  
	   
	  String shortestCompletingWord = shortestCompletingWord(word, array);
	  System.out.println();
	  System.out.print("The minimum length word from a given dictionary words, which has all the letters from the string licensePlate is: " + shortestCompletingWord);
	}
  }
