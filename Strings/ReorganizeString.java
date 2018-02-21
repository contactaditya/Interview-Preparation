import java.util.*;
import java.io.*;
 
  public class ReorganizeString {
	  
	public static String reorganizeString(String string) {
	  int[] counts = new int[26];
	  
	  for (char c: string.toCharArray()) {
		counts[c-'a'] += 100;
	  }
	  
	  for (int i = 0; i < 26; ++i) {
		counts[i] += i;
	  }
	  Arrays.sort(counts);
	  
	  char[] answer = new char[string.length()];
	  int t = 1;
	  for (int code : counts) {
        int ct = code / 100;
        char ch = (char) ('a' + (code % 100));
        if (ct > (string.length() + 1) / 2) {
    	  return "";
        }
        for (int i = 0; i < ct; i++) {
          if (t >= string.length()) {
            t = 0;
          }
          answer[t] = ch;
          t += 2;
        }
      }
	 	
	  return String.valueOf(answer);      
	}	  

	public static void main(String[] args) {     
	  String string = new String();	  
	  Scanner input = new Scanner(System.in);

	  System.out.print("Enter the string: ");
	  string = input.nextLine();
		  
	  String result = reorganizeString(string);
	  System.out.println();
	  System.out.println("The string after the letters can be rearranged so that two characters that are adjacent to each other are not the same is: " + result);  
	 
	}
  }
