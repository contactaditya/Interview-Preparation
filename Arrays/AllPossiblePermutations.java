import java.util.*;
import java.io.*;

 public class AllPossiblePermutations {
	 
    public static List<List<Integer>> permute(int[] array) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();	
      if (array == null || array.length == 0) {
        return result;
      }
      backtrack(result, new ArrayList<>(), array);	
      return result;    
    }	 

    private static void backtrack(List<List<Integer>> result, List<Integer> list, int[] array) {
      if(list.size() == array.length) {
	result.add(new ArrayList<>(list));
      } 
      else {
	for(int i = 0; i < array.length; i++) { 
	  if(list.contains(array[i])) {
	    continue; // This element already exists, skips
	  }
	  list.add(array[i]);
	  backtrack(result, list, array);
	  list.remove(list.size() - 1);
	}
      }
    }

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
		  
      System.out.println();	
      System.out.print("Please enter the actual values in the array: ");
      for (int i = 0; i < array.length; i++) {
	array[i] = input.nextInt();
      }
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      result = permute(array);
      System.out.println();
      System.out.println("A solution set is: ");
      System.out.println('[');
      for(List<Integer> innerList : result) {
	System.out.println(innerList + " ");
      }
      System.out.println(']');
    }
  }
