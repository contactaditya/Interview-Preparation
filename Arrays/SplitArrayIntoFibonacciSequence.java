import java.util.*;
import java.io.*;

  public class SplitArrayIntoFibonacciSequence {
	  
	public static List<Integer> splitIntoFibonacci(String string) {  
	  if(string == null || string.length() < 3) {
		return null;
	  }
      int length = string.length();
      for (int i = 0; i < length/2; i++) {
        for (int j = i+1; j < length-i-1; j++) {  
          List<Integer> result = new ArrayList<Integer>();	
          try {
        	int f0 = Integer.parseInt(string.substring(0, i+1)), f1 = Integer.parseInt(string.substring(i+1,j+1));	
        	int k = j; 
        	result.add(f0);
        	while (k < length-i-1 && string.substring(k+1).startsWith(String.valueOf(f0+f1))) {
              result.add(f1);
              int f2 = f0 + f1;
              f0 = f1; 
              f1 = f2; 
              k += String.valueOf(f2).length();
            }
        	if (k >= length-i-1) {
              result.add(f1);
              return result;
        	}  
          } catch(Exception e) {
        	j = length; 
          }
        }
      }
	  
	  return new ArrayList<Integer>();
	}	  

	public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String string = new String();	  
	  System.out.print("Enter the string: ");
	  string = input.nextLine();	
		  
	  List<Integer> result = new ArrayList<Integer>();
      result = splitIntoFibonacci(string); 
	  System.out.println();
	  System.out.println("The Fibonacci-like sequence split from " + string  + " is: " + result);
	}
  }
