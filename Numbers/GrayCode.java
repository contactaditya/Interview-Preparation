import java.util.*;
import java.io.*;

  public class GrayCode {
	  
    public static List<Integer> grayCode(int number) {
      List<Integer> result = new LinkedList<Integer>();	
      for (int i = 0; i < 1 << number; i++) {
	result.add(i ^ i >> 1);
      }
	
      return result;      
    }	  

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();   
	
      List<Integer> result = new ArrayList<Integer>();
      result = grayCode(number);
      System.out.println();	
      System.out.print("The sequence of the gray code is: " + result);
    }
  } 
