import java.util.*;
import java.io.*;

  public class FirstMissingPositive {
	 
	public static int firstMissingPositive(int[] array) {      
	  if (array == null || array.length == 0) {
	    return 1;
	  }
	  for(int i = 0; i < array.length; i++) {
        while (array[i] > 0 && array[i] <= array.length && array[array[i] - 1] != array[i]) {		  
          int temp = array[i];
          array[i] = array[array[i] - 1];
          array[temp - 1] = temp; 
		}  
	  }
	  for(int i = 0; i < array.length; i++){
        if(array[i] != i + 1) {
          return i + 1;
        }
      }
	 
	  return array.length + 1;  
	}  

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int number = input.nextInt();  
	  int array[] = new int[number];
		
	  System.out.println();	
	  System.out.print("Please enter the elements of the array: ");
	  for (int i = 0; i < array.length; i++) {
		array[i] = input.nextInt();
	  }
		  
	  int firstMissingPositive = firstMissingPositive(array);
	  System.out.println();	
	  System.out.print("The smallest missing positive integer is: " + firstMissingPositive);
	}
  }
