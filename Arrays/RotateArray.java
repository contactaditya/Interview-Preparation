import java.util.*;
import java.io.*;

 public class RotateArray {
	 
    public static void rotate(int[] array, int k) { 
       if(k > array.length) {
	  k = k % array.length;
       }
       int[] result = new int[array.length];   
		    
       for(int i=0; i<array.length; i++) {
	  result[(i+k)%array.length] = array[i];  
       }
       System.out.println();	
       System.out.print("The contents of the array after rotation are: ");
	    
       for(int i=0; i<array.length; i++) {
          System.out.print(result[i] + " "); 
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
        rotate(array, numberOfRotations);
    }
 }
