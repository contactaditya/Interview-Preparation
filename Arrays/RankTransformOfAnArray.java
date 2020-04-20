import java.util.*;
import java.io.*;

  public class RankTransformOfAnArray {
	
    public static int[] arrayRankTransform(int[] array) {
      int result[] = new int[array.length];
      int sortedArray[] = new int[array.length];
      
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for(int i = 0; i < array.length; i++) {
        sortedArray[i] = array[i];
      }
      
      Arrays.sort(sortedArray);
      
      int rank = 1;
      for(int j = 0; j < sortedArray.length; j++) {
        if(!map.containsKey(sortedArray[j])) {
          map.put(sortedArray[j], rank);
          rank++;
        }
      }
      
  	  // Retrive the values for getting ranks in correct order.
      for(int i = 0; i< result.length; i++){
        result[i] = map.get(array[i]);
      }
     
      return result;	
    }	

	public static void main(String[] args) { 
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
	
      System.out.println();	
      System.out.println("Please enter the elements in the array: ");
      for (int i = 0; i < array.length; i++) {
        array[i] = input.nextInt();
      }
	
      System.out.println();	
      int[] result = arrayRankTransform(array);
      System.out.print("The rank transform of the array is: ");  
      for (int i=0; i < result.length; i++) {
	    System.out.print(result[i] + " ");
      }	  
      input.close();
	}
  }
