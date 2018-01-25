import java.util.*;
import java.io.*;

  public class CountNonDivisible {
	  
    private static int[] countNonDivisible(int[] array) {
      int count[] = new int[array.length * 2 + 1];
      // Calculate occurences of each number in the array
      for (int number : array) {
	count[number]++;
      }
      // Calculate how many of its divisors are in the array
      int[] divisorNums = new int[count.length];
      for (int i = 1; i * i < divisorNums.length; i++) {
	for (int j = i * i; j < divisorNums.length; j += i) {
	  divisorNums[j] += count[i];
	  if (j != i * i) {
	    divisorNums[j] += count[j/i];
	  }
	}
      } 	
      // Subtract the number of divisors from the number of elements in the array
      int[] result = new int[array.length];
      for (int i = 0; i < result.length; i++) {
	result[i] = array.length - divisorNums[array[i]];
      }
      return result;
    }  	  
	  
    private static int[] countNonDivisible1(int[] array) {
      int count[] = new int[array.length];
      for (int i=0; i < array.length; i++) {
        for (int j=0; j < array.length; j++) {
    	  if(array[i] % array[j] != 0) {
            count[i]++;   	   	
    	  }
        }
      }
    	
      return count;
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
	  
      int countNonDivisible[] = countNonDivisible(array);
      System.out.println();	
      System.out.print("The sequence of integers representing the amount of non-divisors are: ");
      for (int i=0; i < countNonDivisible.length; i++) {
	System.out.print(countNonDivisible[i] + " ");
      }  
    }
  }
