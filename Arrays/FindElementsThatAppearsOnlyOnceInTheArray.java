import java.util.*;
import java.io.*;

 public class FindElementsThatAppearsOnlyOnceInTheArray { 	
	 
	public static int singleNumber(int array[]) {
	   int number = array[0]; 	
	   for (int i = 1; i < array.length; i++) {
		 number = number ^ array[i];
	   }	
	   return number;
	} 	
	
	public static int singleNumber1(int array[]) {
	  HashSet<Integer> hashset = new HashSet<Integer>();
	  int result = 0;
	        
	  for (int i = 0; i < array.length; i++) {
	    if (!hashset.contains(array[i])) {
	      hashset.add(array[i]);
	    } else {
	      hashset.remove(array[i]);
	    }
	  }
	  
	  for (Integer number : hashset) {
		result = number;
      }
	  
      return result;
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
	   
	  Arrays.sort(array);
	   
	  int onceElement = singleNumber1(array);
	  System.out.println(); 
	  if (!(onceElement == 0)) {
	 	System.out.println("The element that appears once in the array is " + onceElement);
	  } else {
		System.out.println("There is no element that only appers once in the array.");
	  }	
	}
 }
