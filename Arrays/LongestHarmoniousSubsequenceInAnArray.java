import java.util.*;
import java.io.*;

  public class LongestHarmoniousSubsequenceInAnArray {
	 
    public static int findLHS(int[] array) {
       if (array.length == 0) {
	 return 0;
       }	
       int max = 0;
       Map<Integer, Integer> map = new HashMap<Integer, Integer>();
       for (int number : array) {
	 map.put(number, map.getOrDefault(number, 0) + 1);
       }
	   
       for (int number : map.keySet()) {
         if (map.containsKey(number + 1)) {
           max = Math.max(max, map.get(number) + map.get(number + 1));
         }
       }
	 
       return max;       
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
	   	   
       int LHS = findLHS(array);
       System.out.println();
       System.out.println("The longest harmonious subsequence is: " + LHS);

    }
  }
