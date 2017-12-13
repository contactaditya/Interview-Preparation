import java.util.*;
import java.io.*;

  public class RangeSumQueryImmutable {
	  
	private int[] sum;  
	  
    public RangeSumQueryImmutable(int[] array) {
      sum = new int[array.length + 1];
      for (int i = 0; i < array.length; i++) {
    	sum[i + 1] = sum[i] + array[i];
      }	      
	}
	    
	public int sumRange(int i, int j) {
	  return sum[j + 1] - sum[i];      
	}  

	public static void main(String[] args) {     
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number of elements in the array: ");
	  int n = input.nextInt();
	  int array[] = new int[n];
	  System.out.println();	
	  System.out.print("Please enter the elements in the array: ");
	  for(int x = 0; x < n; x++) {
	    array[x] = input.nextInt();
	  }
	  System.out.println();	
	  System.out.print("Enter the lower indice of the array: ");
	  int i = input.nextInt();  
		
	  System.out.println();	
	  System.out.print("Enter the upper indice of the array: ");
	  int j = input.nextInt();  
	  
	  RangeSumQueryImmutable object = new RangeSumQueryImmutable(array);
	  int result = object.sumRange(i,j);
		  
	  System.out.println();
	  System.out.println("The sum of the elements between indices " + i + " and " + j + " (i ≤ j), inclusive is: " + result);
	}
  }
