import java.util.*;
import java.io.*;

 public class PermutationsII {
	 
    public static List<List<Integer>> permuteUnique(int[] array) {
	  List<List<Integer>> result = new ArrayList<List<Integer>>();	
	  if (array == null || array.length == 0) {
	    return result;
	  }
	  Arrays.sort(array);
	  backtrack(result, new ArrayList<>(), array, new boolean[array.length]);	
	  return result;    
	}	 

    private static void backtrack(List<List<Integer>> result, List<Integer> list, int[] array, boolean[] used) {
	  if(list.size() == array.length) {
		result.add(new ArrayList<>(list));
	  } 
	  else {
	    for(int i = 0; i < array.length; i++) { 
		  if(used[i] || i > 0 && array[i] == array[i-1] && !used[i - 1]) {
		    continue; // This element already exists, skips
		  }
		  used[i] = true; 
		  list.add(array[i]);
		  backtrack(result, list, array, used);
		  used[i] = false; 
		  list.remove(list.size() - 1);
		}
	  }
	} 
    
    public static List<List<Integer>> permuteUnique1(int[] array) {
	  List<List<Integer>> result = new ArrayList<List<Integer>>();	
	  if (array == null || array.length == 0) {
	    return result;
	  }
	  Arrays.sort(array);
	  backtrack1(array, result, 0, array.length-1);	
	  return result;    
	}	 

    private static void backtrack1(int[] array, List<List<Integer>> result, int begin, int end) {
	  if(begin > end) {
		result.add(new ArrayList<Integer>() {{ 
		for (int i : array) { 
		  add(i);
		}
		}});
	  }
	  else {
	    for(int i = begin; i <= end; i++) { 
		  if(!isDuplicate(array, begin, i)) {
			swap(array,i,begin);
            backtrack1(array, result, begin+1, end); 
            swap(array,i,begin);
		  }
		}
	  }
	} 
    
    public static boolean isDuplicate(int[] array, int begin, int i) {
      for(int a=begin; a<i; a++) {
        if(array[a] == array[i]) {
           return true;
        }
      }
      return false;
    }
    
	public static void swap(int[] array, int i, int j) {
      int buffer = array[i];
      array[i] = array[j];
      array[j] = buffer;
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
	   result = permuteUnique(array);
	   System.out.println();
	   System.out.println("A solution set is: ");
	   System.out.println('[');
	   for(List<Integer> innerList : result) {
		 System.out.println(innerList + " ");
	   }
	   System.out.println(']');
	}
 }
