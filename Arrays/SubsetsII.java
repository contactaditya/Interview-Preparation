import java.util.*;
import java.io.*;

  public class SubsetsII {
	  
    public static List<List<Integer>> subsetsWithDuplicates(int[] array) { 
      List<List<Integer>> result = new ArrayList<List<Integer>>();	
      if(array.length == 0) {
	return result;
      }	
		  
      Arrays.sort(array);
      dfs(array, 0, new ArrayList<Integer>(), result);
      return result;      
    }
		  
    private static void dfs(int[] array, int start, List<Integer> arrayList, List<List<Integer>> result) {
      result.add(new ArrayList<Integer>(arrayList));
      for(int i = start; i < array.length; i++) {
        if(i > start && array[i] == array[i-1]) {
	  continue; // skip duplicates  
	}
	arrayList.add(array[i]);
	dfs(array, i + 1, arrayList, result);
	arrayList.remove(arrayList.size() - 1);
      }	
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
		
      List<List<Integer>> result = new ArrayList<List<Integer>>();
	   
      result = subsetsWithDuplicates(array); 
	   
      System.out.println();
      System.out.println("A solution set is: ");
      System.out.println('[');
      for(List<Integer> innerList : result) {
	System.out.println(" " + innerList);
      }
      System.out.println(']');

    }
  }
