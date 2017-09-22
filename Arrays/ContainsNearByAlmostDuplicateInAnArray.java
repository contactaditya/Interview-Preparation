import java.util.*;
import java.io.*;

public class ContainsNearByAlmostDuplicateInAnArray {
	
   private static boolean containsNearbyAlmostDuplicate(int[] array, int k, int t) {
       if (array.length <= 1 || k < 0 || t < 0) {
	  return false;
       }
		   
       TreeSet<Integer> treeSet = new TreeSet<Integer>();
		   
       for (int i = 0; i < array.length; i++) {
	  Integer floor = treeSet.floor(array[i] + t);
          Integer ceil = treeSet.ceiling(array[i] - t);
	 
	  if ((floor != null && floor >= array[i]) || (ceil != null && ceil <= array[i])) {
             return true;
          }
	      
	  treeSet.add(array[i]);
	  if (i >= k) {
            treeSet.remove(array[i-k]);
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
      System.out.println();	
      System.out.print("Enter an integer k which represents the absolute difference between the two array values: ");
      int k = input.nextInt();  
		  
      System.out.println();	
      System.out.print("Enter an integer t which represents the absolute difference between two indexes: ");
      int t = input.nextInt();  
		  
      boolean duplicates = containsNearbyAlmostDuplicate(array, k, t);  
      System.out.println();	
      if(duplicates) {
	System.out.println("The array contains duplicates.");  
      } 
      else {
	System.out.println("The array does not contain any duplicates.");
      }
   }
}
