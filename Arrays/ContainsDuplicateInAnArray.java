import java.util.*;
import java.io.*;

 public class ContainsDuplicateInAnArray {
	
	public static boolean containsDuplicate(int[] array) {
	   Set<Integer> set = new HashSet<Integer>();
	   for (int i = 0; i < array.length; i++) {
	     if (set.contains(array[i])) {
	       return true;
	     }
	     else {
	       set.add(array[i]);
	     }
	   }
	   return false;   	    
	}	 

	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int number = input.nextInt();  
	  int array[] = new int[number];
			  
	  System.out.println();	
	  System.out.print("Please enter the actual numbers in the array: ");
      for (int i = 0; i < array.length; i++) {
		array[i] = input.nextInt();
	  }
	  boolean duplicates = containsDuplicate(array);  
	  System.out.println();	
	  if(duplicates) {
		System.out.println("The array contains duplicates.");  
	  } 
	  else {
	    System.out.println("The array does not contain any duplicates.");
	  }
	}
 }
