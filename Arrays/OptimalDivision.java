import java.util.*;
import java.io.*;

  public class OptimalDivision {
	  
	public static String optimalDivision(int[] array) {   
	  if (array.length == 1) {
        return array[0] + "";
	  }
	  if (array.length == 2) {
        return array[0] + "/" + array[1];
	  }
	  StringBuilder result = new StringBuilder(array[0] + "/(" + array[1]);
	  for (int i = 2; i < array.length; i++) {
        result.append("/" + array[i]);
      }
	  result.append(")");
		
	  return result.toString();      
	}	  

	public static void main(String[] args) {    
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
	 
      System.out.println();	
      System.out.print("Please enter number: ");
      for (int i = 0; i < array.length; i++) {
        array[i] = input.nextInt();
      }
			
      String maxResult = optimalDivision(array);
      System.out.println();	
      System.out.print("The corresponding expression that gives the maximum result in string format is: " + maxResult);
	}
  }
