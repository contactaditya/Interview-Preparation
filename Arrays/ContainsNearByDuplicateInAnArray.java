import java.util.*;
import java.io.*;

 public class ContainsNearByDuplicateInAnArray {
	 
   private static boolean containsNearbyDuplicate(int[] array, int k) {
      if (array.length <= 1) {
         return false;
      }
	   
      HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
	   
      for (int i = 0; i < array.length; i++) {
        if(hashMap.containsKey(array[i]) && i - hashMap.get(array[i]) <= k) {
           return true;
        }
        hashMap.put(array[i], i);
      }
	   
      return false;
   } 
	 
   private static boolean containsNearbyDuplicate1(int[] array, int k) {
      if (array.length <= 1 || k==0) {
	 return false;
      }
	     
      HashSet<Integer> hashSet = new HashSet<Integer>();
		   
      for(int i = 0; i < array.length; i++) {
	if(i > k) {
	  hashSet.remove(array[i-k-1]);
	}
	if(!hashSet.add(array[i])) {
	  return true;
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
      System.out.print("Enter an integer t which represents the absolute difference between two indexes: ");
      int k = input.nextInt();  
	  
      boolean duplicates = containsNearbyDuplicate(array, k);  
      System.out.println();	
      if(duplicates) {
	 System.out.println("The array contains duplicates.");  
      } 
      else {
	 System.out.println("The array does not contain any duplicates.");
      }
   }
 }
