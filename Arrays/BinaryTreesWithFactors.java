import java.util.*;
import java.io.*;

  public class BinaryTreesWithFactors {
	  
    public static int numFactoredBinaryTrees(int[] array) { 
      long MOD = (long) Math.pow(10, 9) + 7;
      long result = 0L;
      Arrays.sort(array);
   
      Map<Integer, Long> dp = new HashMap<Integer, Long>();
      for (int i = 0; i < array.length; i++) {
        dp.put(array[i], 1L);
        for (int j = 0; j < i; j++) {
          if (array[i] % array[j] == 0 && dp.containsKey(array[i] / array[j])) { 
        	dp.put(array[i], (dp.get(array[i]) + dp.get(array[j]) * dp.get(array[i] / array[j])) % MOD);
          }
        }	
      }
      long answer = 0;
      for (long x : dp.values()) {
    	result = (result + x) % MOD;
      }
      return (int) result;   
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
      int numberOfBinaryTree = numFactoredBinaryTrees(array);
      System.out.println();
      System.out.print("The number of binary trees we can make are: " + numberOfBinaryTree);
    }
  } 
