import java.io.*;
import java.util.*;

   public class CombinationSum {
	 
	 private static List<List<Integer>> combinationSum(List<Integer> priceList, int target) { 
	   List<List<Integer>> result = new ArrayList<List<Integer>>();	
	   if(priceList == null || priceList.size() < 0) {
	     return result;
	   }
	   Collections.sort(priceList);
	   backtrack(result, new ArrayList<Integer>(), priceList, target, 0);	
	   return result; 
	 }
		
	 private static void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, List<Integer> priceList, int remain, int start) {
	   if(remain < 0) {
		 return; 
	   } 
	   else if(remain == 0) {
		 result.add(new ArrayList<Integer>(tempList));  
	   }
	   else {
		 for(int i = start; i < priceList.size(); i++) {
		   tempList.add(priceList.get(i));
		   backtrack(result, tempList, priceList, remain - priceList.get(i), i); // not i + 1 because we can reuse same elements
		   tempList.remove(tempList.size() - 1);
		 }  
	   }
     }	

     public static void main(String[] args) {  
	   Scanner input = new Scanner(System.in);
	   System.out.print("Enter number of elements in the array: ");
	   int number = input.nextInt();  
	   List<Integer> list = new ArrayList<Integer>();	
	 
	   System.out.println();	
	   System.out.print("Please enter the elements in the array: ");
	   for (int i = 0; i < number; i++) {
	     list.add(input.nextInt());
	   }
			
	   System.out.println();	
	   System.out.print("Enter the sum that you want to check whether it is present array or not: ");
	   int sum = input.nextInt();  
			  
	   List<List<Integer>> result = new ArrayList<List<Integer>>();	
	   result = combinationSum(list, sum); 
	   System.out.println();
	   System.out.println("A solution set is: ");
	   System.out.println('[');
	   for(List<Integer> innerList : result) {
	     System.out.println(innerList + " ");
	   }
	   System.out.println(']');
     }
   }


