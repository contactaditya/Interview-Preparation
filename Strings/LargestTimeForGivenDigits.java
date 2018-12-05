import java.util.*;
import java.io.*;

  public class LargestTimeForGivenDigits {
	  
	public static String largestTimeFromDigits(int[] array) {
	  String answer = new String();  
      // Choose different indices i, j, k, l as a permutation of 0, 1, 2, 3
      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
          for (int k = 0; k < 4; k++) {
            if (i == j || i == k || j == k) {
              continue; // avoid duplicate among i, j & k.
            }
            String hours = "" + array[i] + array[j];
            String minutes = "" + array[k] + array[6 - i - j - k];
            String time = hours + ":" + minutes; 
            if (hours.compareTo("24") < 0 && minutes.compareTo("60") < 0 && answer.compareTo(time) < 0) {
              answer = time; // hour < 24; minute < 60; update result.
            }
          }
        }
	  }
		
	  return answer;      
	}

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int numbers = input.nextInt();   
	  int array[] = new int[numbers];
	    
	  System.out.println();
	  System.out.print("Please enter the actual values in the array: ");
	  for (int i = 0; i < numbers; i++) {
		array[i] = input.nextInt(); 
	  }
	   
	  String largestTimeFromDigits = largestTimeFromDigits(array);
	  System.out.println();
	  System.out.print("The largest 24 hour time that can be made is: " + largestTimeFromDigits);
	  input.close();
	}
  }
