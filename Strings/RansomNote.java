import java.util.*;
import java.io.*;

  public class RansomNote {
	  
    public static boolean canConstruct(String ransomNote, String magazine) {
      int array[] = new int[26];	
      for(char c : ransomNote.toCharArray()) {
	array[c - 'a']++;    
      }
      for(char c: magazine.toCharArray()) {
	array[c - 'a']--;    
      }
      for(int i : array) {
        if(i > 0) {
          return false;
        }
      } 
	  
      return true;
    }	  

    public static void main(String[] args) { 	 
      String ransomNote = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the begin word: ");
      ransomNote = input.nextLine();  
      System.out.println();	
      String magazine = new String();	  
      System.out.print("Enter the end word: ");
      magazine = input.nextLine();
	  
      boolean canConstruct = canConstruct(ransomNote, magazine);
      System.out.println();
      if(canConstruct) {
	System.out.println("The ransom note can be constructed from the magazines.");  
      }
      else {
	System.out.println("The ransom note cannot be constructed from the magazines.");  
      }
    }
  }
