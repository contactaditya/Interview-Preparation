import java.util.*;
import java.io.*;

  public class ShortestPalindrome {
	  
	public static String shortestPalindrome(String string) {
	  if (string == null || string.length() < 2) {
		return string;	
	  }
	  char[] array = string.toCharArray(); 
	  int j = array.length - 1;
	  int i = 0;
	  while (j >= 0) {
	    if (array[j] == array[i]) {
	      i++;
	    }
	    j--;
	  }
	  if (i == array.length) {
		return string;
	  }
	  reverse(array, i, array.length - 1);
	  return (new String(array, i, array.length - i)) + shortestPalindrome(string.substring(0, i)) + string.substring(i);
	}
	    
	private static void reverse(char[] array, int start, int end) {
	  while (start < end) {
	    char x = array[start];
	    array[start] = array[end];
	    array[end] = x;
	    start++;
	    end--;
	  }
	}

	public static void main(String[] args) { 	  
	  String string = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string = input.nextLine(); 
	  String shortestPalindrome = shortestPalindrome(string);
	  System.out.println();
	  System.out.println("The shortest palindrome you can find by adding characters in front of the string is: " + shortestPalindrome);  
	}
  }
