import java.io.*;
import java.util.*;

 public class SegregateOddEven {
	 
    public static void segregateOddEven(int[] array) {
      int left = 0, right = array.length - 1;
      while(left < right) {
    	 /* Increment left index while we see 0 at left */
         while (array[left] % 2 == 0 && left < right) {
           left++; 
         }
         /* Decrement right index while we see 1 at right */
         while (array[right] % 2 == 1 && left < right) {
            right--;
         }
         if (left < right) {
           int temp = array[left];
           array[left] = array[right];
           array[right] = temp;
           left++;
           right--;
         }  
      }
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
			
	   segregateOddEven(array);
	   System.out.print("\n");
		    
	   System.out.print("The array after segregation is: ");
	   for (int i = 0; i < array.length; i++) {
         System.out.print(array[i] + " ");
       }
	}
 }
