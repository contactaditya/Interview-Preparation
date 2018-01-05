import java.util.*;
import java.io.*;

 public class CyclicRotation {
	  
   public static int[] cyclicRotation(int[] array, int numberOfRotations){
      int[] result = new int[array.length];   
		    
      for(int i=0; i<array.length; i++) {
	 result[(i+numberOfRotations)%array.length] = array[i];  
      }
	      
      return result;  
   }
	
   public static void printArray(int[] array) {
      System.out.println();		
      System.out.print("The array after rotation in the right direction is: ");   
      for(int i=0; i<array.length; i++) {     
        System.out.print(array[i] + " ");
      }	  
   }

   public static void main(String[] args) {     
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of elements in the array: ");
      int lengthOfArray = input.nextInt();
      int[] array = new int[lengthOfArray];    
      System.out.println();	
      System.out.print("Enter the number of rotations in the array: ");
      int numberOfRotations = input.nextInt();
      System.out.println();	
      System.out.print("Please enter the elements in the array: ");
      for(int i=0;i<lengthOfArray;i++) {  
        array[i] = input.nextInt();
      }  
      
      int result[] = cyclicRotation(array, numberOfRotations);
      printArray(result);
   }
 }
