import java.util.*;
import java.io.*;

  public class PalindromicSubstrings {
	  
	public static int countSubstrings(String string) {
      if(string == null || string.length()==0) {
		return 0;
	  }
      int count = 0;
      for(int i = 0; i < string.length(); i++) {
        count += countPalindrome(string,i,i);
        count += countPalindrome(string,i,i+1);
      }
  
      return count;
	}
	
	private static int countPalindrome(String string, int i, int j) {
      int count = 0;	
      while(i >= 0 && j < string.length()) {
        if(string.charAt(i) == string.charAt(j)) {
          count++;
        }
        else {
          break;
        }
        i--;
        j++; 
      }

	  return count;
	}

	public static void main(String[] args) {   
	  String string = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string = input.nextLine(); 
	  int countSubstrings = countSubstrings(string);
	  System.out.println();
	  System.out.println("The number of palindromic substrings in this string are: " + countSubstrings);
	}
  }
