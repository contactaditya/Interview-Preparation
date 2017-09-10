import java.util.*;
import java.io.*;

  public class ReverseFirstKCharactersInAString {
	  
	public static String reverseWords(String string, int k) {  
	  if (string == null || string.length() == 0) {
		return "";
      }
			 
	  char[] array = string.toCharArray();
      int n = array.length;
      int i = 0;
      while(i < n) {
    	 int j = Math.min(i + k - 1, n - 1);
         swap(array, i, j);
         i += 2 * k;    
      }
	  return string.valueOf(array);
	}  
	
	private static void swap(char[] array, int left, int right) {
      while (left < right) {
        char temp = array[left];
        array[left++] = array[right];
        array[right--] = temp;
      }
    }	

	public static void main(String[] args) {
	  String string = new String();	  	
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string = input.nextLine(); 
		  
	  System.out.println();
	  System.out.print("Enter how many characters you want to reverse: ");
	  int k = input.nextInt();  
		  
	  String reverse = reverseWords(string,k);
	  System.out.println();
	  System.out.println("The string after reversing " + k + " characters is: " + reverse);	

	}
  }
