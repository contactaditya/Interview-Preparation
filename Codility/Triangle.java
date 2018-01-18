import java.util.*;
import java.io.*;

  public class Triangle {     
	  
	public static int isTriangular(int[] array) {
	  if (array.length < 3) {
		return 0;	
	  }
      Arrays.sort(array);   
      for (int i = 0; i < array.length - 2; i++) {
    	if((long)array[i]+(long)array[i+1] > (long)array[i+2]) {
           return 1;
  	    }
  	  }
  
      return 0;
    }

	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of elements in the array: ");
      int lengthOfArray = input.nextInt();
      int[] array = new int[lengthOfArray];    
      System.out.println();	
      System.out.print("Please enter the elements in the array: ");
      for(int i=0;i<lengthOfArray;i++) {  
        array[i] = input.nextInt();
      }   
  
      int isTriangular = isTriangular(array);
      System.out.println();	
      if(isTriangular == 1) {
        System.out.println("There exists a triangular triplet for this array");
      }
      else {
        System.out.println("There exists no triangular triplet for this array");  
      }
	}
  }
