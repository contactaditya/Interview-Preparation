import java.io.*;
import java.util.*;

  public class AllStringPermutations {    
	
    public static void getPermutation1(StringBuffer s) { 
      String str = s.toString();
      System.out.println();	
      System.out.println("These are the permutations obtained from the second method: ");	
      System.out.println();	
      getPermutation1("", str); 
    }
   
    private static void getPermutation1(String prefix, String s) {
      int n = s.length();
      if (n == 0) {
        System.out.println(prefix);
      }
      else {
        for (int i = 0; i < n; i++) {
          getPermutation1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));  
        }  
      }
    } 
  	
    public static void getPermutation(StringBuffer string, int index) {    
      if(index <= 0) {
        System.out.println(string);   
        return;
      }
      else {
  	getPermutation(string, index-1);
        int currentPosition = string.length() - index;
  	 
        for (int i = currentPosition+1; i < string.length(); i++) {
          //start swapping all other chars with current first char
          swap(string,currentPosition, i);
          getPermutation(string, index-1);
          swap(string,i,currentPosition); //restore back my string buffer
        }
      }
    }
   
    public static void swap(StringBuffer string, int i, int j) {
      char c = string.charAt(i);
      string.setCharAt(i, string.charAt(j));
      string.setCharAt(j, c);
    }
  	
    public static void main(String[] args) {   
      StringBuffer word = new StringBuffer();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string whose permutation you want to find: ");
      word.append(input.nextLine());  
     
      System.out.println();	
      System.out.println("These are the permutations obtained from the first method: ");	
      System.out.println();	
     	
      getPermutation(word, word.length());
  	   
      getPermutation1(word);
    }     
  } 
