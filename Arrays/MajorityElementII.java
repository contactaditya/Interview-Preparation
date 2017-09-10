import java.util.*;
import java.io.*;

 public class MajorityElementII {
	
   public static List<Integer> majorityElement(int array[]) {
	 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	 for(int i: array) {
	   if(map.containsKey(i)) {
	      map.put(i, map.get(i)+1);
	   } else {
	      map.put(i, 1);
	   }
	 }
	 
	 List<Integer> result = new ArrayList<Integer>();
	 
	 for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
	   if(entry.getValue() > array.length/3) {
	      result.add(entry.getKey());
	   }    
	 }
	        
	  return result;  
	}	 

	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int numbers = input.nextInt();   
	  int array[] = new int[numbers];

	  System.out.print("\n");
	  System.out.print("Please enter the actual values in the array: ");
	  for (int i = 0; i < numbers; i++) {
		array[i] = input.nextInt();
	  }
		
	  List<Integer> majorityElement = majorityElement(array); 
	  System.out.println();	
	  System.out.print("The majority element that appears more than n/3 times in the array is: " + majorityElement);

	}
 }
