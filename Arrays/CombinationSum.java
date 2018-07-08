import java.util.*;
import java.io.*;

 public class CombinationSum {
	 
   public static List<List<Integer>> combinationSum(int[] array, int target) {
     List<List<Integer>> result = new ArrayList<List<Integer>>();	
     if(array == null || array.length < 0) {
       return result;
     }
     Arrays.sort(array);
     backtrack(result, new ArrayList<Integer>(), array, target, 0);	
     return result;    
   } 

   private static void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int[] array, int remain, int start) {
     if(remain < 0) {
       return; 
     }
     else if(remain == 0) {
       result.add(new ArrayList<Integer>(tempList));  
     }
     else {
       for(int i = start; i < array.length; i++) {
	 tempList.add(array[i]);
	 backtrack(result, tempList, array, remain - array[i], i); // not i + 1 because we can reuse same elements
	 tempList.remove(tempList.size() - 1);
       }  
     }
   }

   public static void main(String[] args) {   
     Scanner input = new Scanner(System.in);
     System.out.print("Enter number of elements in the array: ");
     int number = input.nextInt();  
     int array[] = new int[number];
		
     System.out.println();	
     System.out.print("Please enter the elements in the array: ");
     for (int i = 0; i < array.length; i++) {
       array[i] = input.nextInt();
     }
		
     System.out.println();	
     System.out.print("Enter the sum that you want to check whether it is present array or not: ");
     int sum = input.nextInt();  
		  
     System.out.println();
     List<List<Integer>> result = new ArrayList<List<Integer>>();	
     result = combinationSum(array, sum); 
     System.out.println();
     System.out.println("A solution set is: ");
     System.out.println('[');
     for(List<Integer> innerList : result) {
       System.out.println(innerList + " ");
     }
     System.out.println(']');
   }
 }
