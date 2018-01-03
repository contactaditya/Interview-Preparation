import java.util.*;
import java.io.*;

  public class FindSmallestLetterGreaterThanTarget {
	  
     public static char nextGreatestLetter(char[] letters, char target) {
       for (char c: letters) {
	 if (c > target) {
	   return c;
	 }
       }
       return letters[0];    
     }	  

     public static void main(String[] args) {   
       Scanner input = new Scanner(System.in);
       System.out.print("Enter number of letters: ");
       int number = input.nextInt();  
       char letters[] = new char[number];
	  
       System.out.println();	
       System.out.print("Please enter a list of sorted characters containing only lowercase letters: ");
       for (int i = 0; i < letters.length; i++) {
	 letters[i] = input.next().charAt(0);
       }
	    
       System.out.println();	
       System.out.print("Please enter a target letter: ");
       char target = input.next().charAt(0);
	      	
       char smallestElement = nextGreatestLetter(letters, target);
       System.out.println();	
       System.out.print("The smallest element in the list that is larger than the given target is: " + smallestElement);
     }
  }
