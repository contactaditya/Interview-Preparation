import java.util.*;
import java.io.*;

  public class OneThreeTwoPattern {

	public static List<List<Integer>> find132pattern(int[] array) {  
	  List<List<Integer>> result = new ArrayList<List<Integer>>();
	  int element = 0;
	  if (array.length < 3) {
        return result;
	  }
	  int min[] = new int[array.length];
	  min[0] = array[0]; 
	  for (int i = 1; i < array.length; i++) {
        min[i] = Math.min(min[i - 1], array[i]);
        element = min[i];
	  }
	  for (int j = array.length - 1, k = array.length; j >= 0; j--) {
	    if(array[j] > min[j]) {
	      while (k < array.length && array[k] <= min[j]) {
            k++;	
	      }
	      if(k < array.length && array[k] < array[j]) {
	    	List<Integer> list = new ArrayList<Integer>();  
	    	list.add(element);
	    	list.add(array[j]);
	    	list.add(array[k]);
	    	result.add(list);
	      }
	      array[--k] = array[j];
	    }  
	  }
	  
	  return result;      
	}
	  
	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
	 
      System.out.println();	
      System.out.print("Please enter the number in the array: ");
      for (int i = 0; i < array.length; i++) {
        array[i] = input.nextInt();
      }
			      
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      result = find132pattern(array); 
	  
      System.out.println();
      System.out.println("The solution set with all the 132 patterns is: ");
      System.out.println('[');
      for(List<Integer> innerList : result) {
 	    System.out.println(innerList + " ");
      }
      System.out.println(']');
	}
  }
