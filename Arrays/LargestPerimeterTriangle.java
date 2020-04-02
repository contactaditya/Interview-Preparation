import java.util.*;
import java.io.*;

 public class LargestPerimeterTriangle {
	 
   public static int largestPerimeter(int[] array) {
     int largestPerimeter = 0;	
     if(array.length < 3) {
	return 0; 
     }
	  
     Arrays.sort(array);
	  
     for(int i = 0; i < array.length - 2; i++) {
       if((array[i] + array[i + 1]) > array[i + 2]) {
	 largestPerimeter = array[i] + array[i + 1] + array[i + 2];
       }
     }

     return largestPerimeter;     
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
	  
     int largestPerimeter = largestPerimeter(array);
     System.out.println();
     System.out.print("The largest perimeter of the triangle is: " + largestPerimeter);
   }
 }
