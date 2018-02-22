import java.util.*;
import java.io.*;

  public class MaximumXOROfTwoNumbersInAnArray {
	 
    public static int findMaximumXOR(int[] array) {
      int max = 0, mask = 0;
      for(int i = 31; i >= 0; i--) {	
    	mask = mask | (1 << i);  
    	Set<Integer> set = new HashSet<Integer>();  
    	for(int number : array) {
          set.add(number & mask);
        }  
    	int temp = max | (1 << i);
    	for(int prefix : set) {
          if(set.contains(temp ^ prefix)) {
            max = temp;
            break;
          }
        }	
      }
      
      return max;      
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
	  
      int maximumXOR = findMaximumXOR(array);
      System.out.println();	
      System.out.print("The maximum XOR of two numbers in the array is: " + maximumXOR);

    }
  }
