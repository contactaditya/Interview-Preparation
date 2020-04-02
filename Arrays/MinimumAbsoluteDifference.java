import java.util.*;
import java.io.*;

 public class MinimumAbsoluteDifference {
	
    public static List<List<Integer>> minimumAbsDifference(int[] array) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();	
      if(array.length == 0){
        return result;
      }
      List<Integer> list = new ArrayList<Integer>();
      
      Arrays.sort(array);
      int minimumDifference = Integer.MAX_VALUE;
      int difference = 0;
      
      // Find the value of the minimum difference in the array
      for(int i = 0; i < array.length - 1; i++) { 
        minimumDifference = Math.min(array[i + 1] - array[i], minimumDifference); 
      }
      
      // If the differene between any two array elements is equal to the minimum difference then they are added to the array
      for(int i = 0;i < array.length-1; i++) {
        if(array[i + 1] - array[i] == minimumDifference) {
          result.add(Arrays.asList(array[i], array[i + 1]));
        }
      }
     
      return result; 
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
	  result = minimumAbsDifference(array); 
	  System.out.println();
	  System.out.print("The solution set is: ");
	  System.out.print('[');
	  for(List<Integer> innerList : result) {
		System.out.print(innerList + ",");
	  }
	  System.out.println(']');
	  input.close();
	}
 }
