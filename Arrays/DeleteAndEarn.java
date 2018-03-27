import java.util.*;
import java.io.*;

  public class DeleteAndEarn {
	  
    public static int deleteAndEarn(int[] array) {   
      int[] count = new int[10001];
      for (int x : array) {
    	count[x]++;
      }
      int avoid = 0, using = 0, previous = -1;
      for (int k = 0; k <= 10000; k++) {
    	if (count[k] > 0) {
          int m = Math.max(avoid, using);
          if (k - 1 != previous) {
            using = k * count[k] + m;
            avoid = m;
          }
          else {
            using = k * count[k] + avoid;
            avoid = m;  
          }
          previous = k;
    	}
      }
		
      return Math.max(avoid, using);      
    }	  

    public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
	
      System.out.println();	
      System.out.print("Please enter the elements of the array: ");
      for (int i = 0; i < array.length; i++) {
	array[i] = input.nextInt();
      }
	  
      int maxPoints = deleteAndEarn(array);
      System.out.println();	
      System.out.print("The maximum number of points you can earn by applying delete operation is: " + maxPoints);
    }
  }
