import java.util.*;
import java.io.*;

  public class RandomPickIndex {  
    private static int[] array;
	  
    public RandomPickIndex(int[] array) {
      this.array = array;    
    }
	    
    public static int pick(int target) {
      List<Integer> list = new ArrayList<Integer>();	
      int result = 0;
      for (int i = 0; i < array.length; i++) {
	if(array[i] == target) {
          list.add(i);
	}
      }
      Collections.shuffle(list);
      result = list.get(0);
      return result;
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
      
      System.out.println();
      System.out.print("Enter the value of the target you want to check in the array: ");
      int target = input.nextInt();  
      
      RandomPickIndex random = new RandomPickIndex(array);
      int indexOfTargetNumber = pick(target);
      System.out.println();	
      System.out.print("The index of the given target number is: " + indexOfTargetNumber); 
    }
  }
