import java.util.*;
import java.io.*;

 public class PalindromePermutation {
	 
    public static boolean isPermutationOfPalindrome(String phrase) {
       int[] table = buildCharFrequencyTable(phrase);
       return checkMaxOneOdd(table);
    }
    
    public static boolean checkMaxOneOdd(int[] table) {
       boolean foundOdd = false;
       for (int count : table) {
	 if (count % 2 == 1) {
	   if (foundOdd) {
	     return false;
	   }
	   foundOdd = true;
	 }
       }
      return true;
    }
    
    public static int getCharNumber(Character c) {
      int a = Character.getNumericValue('a');
      int z = Character.getNumericValue('z');
      int value = Character.getNumericValue(c);
	  
      if (a <= value && value <= z) {
	return value - a;
      }
      return -1;
    }
    
    public static int[] buildCharFrequencyTable(String phrase) {
      int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
      for (char c : phrase.toCharArray()) {
        int x = getCharNumber(c);
        if (x != -1) {
	  table[x]++;
        }
      }
      return table;
    }
    	 
    public static void main(String[] args) {
      String string = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the first string: ");
      string = input.nextLine(); 
		  
      System.out.println();
      if(isPermutationOfPalindrome(string)) {
	System.out.println("The string is a permutation of the palindrome.");
      }
      else {
        System.out.println("The string is not a permutation of the palindrome.");  
      }
    }
 } 
