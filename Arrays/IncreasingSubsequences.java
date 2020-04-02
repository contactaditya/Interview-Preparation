import java.util.*;
import java.io.*;

  public class IncreasingSubsequences {
	  
    public static List<List<Integer>> findSubsequences(int[] array) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      List<Integer> list = new ArrayList<Integer>();
      findSequence(array, 0, result, list);
      return result;    
    }	  

    private static void findSequence(int[] array, int index, List<List<Integer>> result, List<Integer> list) {
      if (index == array.length) {
        if (list.size() > 1) {
          result.add(new ArrayList<>(list));
        }
        return ;
      }
      if (list.isEmpty() || list.get(list.size() - 1) <= array[index]) {
        list.add(array[index]);
        findSequence(array, index + 1, result, list);
        list.remove(list.size() - 1);
      }
      if (list.isEmpty() || list.get(list.size() - 1) != array[index]) {
	findSequence(array, index + 1, result, list);
      }
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
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      result = findSubsequences(array);  
      System.out.println();	 
      System.out.print("All the different possible increasing subsequences of the given array are: ");
      System.out.print('[');
      for(List<Integer> innerList : result) {
	System.out.print(innerList + ", ");
      }
      System.out.print(']');
    }
  }
