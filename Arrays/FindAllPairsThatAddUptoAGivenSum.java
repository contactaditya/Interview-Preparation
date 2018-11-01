import java.util.*;
import java.io.*;

  public class FindAllPairsThatAddUptoAGivenSum {
	  
	public static void findThePairs(int array[], int sum){
	  Set<Integer> set = new HashSet<Integer>(); 
      for(int i = 0; i < array.length; i++) {
    	int temp = sum - array[i];  
    	// checking for condition 
        if (temp >= 0 && set.contains(temp)) {
          System.out.println();	
          System.out.println("The pair with the given sum " + sum + " is [" + array[i] + ", " + temp + "]"); 	
        } else {
          set.add(array[i]);
        }
      }
	}
	
	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int number = input.nextInt();  
	  int array[] = new int[number];
			  
	  System.out.println();	
	  System.out.print("Please enter the actual numbers in the array which are between -50 and 50: ");
      for (int i = 0; i < array.length; i++) {
		array[i] = input.nextInt();
	  }
      
      System.out.println();	
	  System.out.print("Enter the sum: ");
	  int sum = input.nextInt();  
	  
	  findThePairs(array, sum);
	  input.close();
	}
  }
