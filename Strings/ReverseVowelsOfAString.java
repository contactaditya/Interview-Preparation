import java.util.*;
import java.io.*;

  public class ReverseVowelsOfAString {   
	  
    public static String reverseVowels(String string) {  
       char[] list = string.toCharArray();
       Set<Character> vowels = new HashSet<>(Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'}));
       int start = 0;
       int end = string.length()-1;
       while(start<end) {
         if (!vowels.contains(list[start])) {
           start++;
           continue;
         }	
         if (!vowels.contains(list[end])) {
           end--;
           continue;
         }	
         char temp = list[start];
         list[start] = list[end];
         list[end] = temp;
         
         start++;
         end--;
       } 
       return string.valueOf(list);
    }

    public static void main(String[] args) { 
       String string = new String();	  	
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the string: ");
       string = input.nextLine(); 
	   
       String reverse = reverseVowels(string);
       System.out.println();
       System.out.println("The string after reversing the vowels is: " + reverse);
    }
  }
