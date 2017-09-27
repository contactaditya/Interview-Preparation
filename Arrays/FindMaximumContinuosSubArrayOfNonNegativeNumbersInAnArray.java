import java.util.*;
import java.io.*;

  public class FindMaximumContinuosSubArrayOfNonNegativeNumbersInAnArray {
	 
	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
	   long maxSum = 0;
	   long newSum = 0;	
	   ArrayList<Integer> maxArray = new ArrayList<>();		
	   ArrayList<Integer> newArray = new ArrayList<>();		
	   for(Integer i : a) {
		 if (i >= 0) {
	       newSum += i;
	       newArray.add(i);
	     } else {
	       newSum = 0;
	       newArray = new ArrayList<Integer>();
	     } 
	   	 if(newSum > maxSum || ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
		    maxSum = newSum; 
		    maxArray = newArray;
	     }
	   }
		
	   return maxArray;
	}	  

	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int number = input.nextInt();  
	  ArrayList<Integer> numbers = new ArrayList<>();	
			
	  System.out.println();	
	  System.out.print("Please enter the elements of the array: ");
	  for (int i = 0; i < number; i++) {
		numbers.add(input.nextInt());
	  }
	  List<Integer> result = new ArrayList<Integer>();
	  result = maxset(numbers);
	  System.out.println();	
	  System.out.print("The maximum subarray of non negative numbers from the array is: " + result);

	}
  }
