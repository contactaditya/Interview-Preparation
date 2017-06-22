import java.util.*;
import java.io.*;

 public class ArrayElements {
	 
    static class pair {
	  int first, second;
	  pair(int f,int s) {
	    first = f; 
	    second = s;
	  }
    }; 
	 
	public static boolean findPairs(int[] array) {
       // Create an empty Hash to store mapping from sum to pair indexes
       HashMap<Integer,pair> map = new HashMap<Integer,pair>();
       int n = array.length;
       
       for (int i = 0; i < n; i++) {
         for (int j = i + 1; j < n; j++) {
           // If sum of current pair is not in hash, then store it and continue to next pair	 
           int sum = array[i] + array[j];
           if (!map.containsKey(sum)) {
             map.put(sum,new pair(i,j));
           }
           else {
        	  // Find previous pair  
        	  pair p = map.get(sum);
    		  // Since array elements are distinct, we don't need to check if any element is common among pairs  
              System.out.println();
         	  System.out.println("There are two pairs ("+ array[p.first] +","+ array[p.second] +") and ("+ array[i] +","+ array[j] +") such that "+ array[p.first] +" + "+ array[p.second] +" = "+ array[i] +" + "+ array[j] +""); 
              return true;  
           }
         }
       }
      return false;
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
	   boolean pairs = findPairs(array);
	   if(!pairs) {
		  System.out.println();
		  System.out.println("No Pairs Found."); 
	   }
	}
  }
