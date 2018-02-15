import java.util.*;
import java.io.*;

  public class ValidTriangleNumber {
	  
	public static int triangleNumber(int[] array) {
	  if (array == null || array.length < 3) {
	     return 0;
	  }	
	  int count = 0;
	  Arrays.sort(array);
	  for (int i = 0; i < array.length; i++) {
	    int left = 0;
	    int right = i - 1;
	    while (left < right) {
	      if (array[left] + array[right] > array[i]) {
            count += right - left;
            right--;
          } else {
            left++;
          }
	    }
	  }
	  return count;       
    }  

	public static void main(String[] args) { 	 
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int number = input.nextInt();  
	  int array[] = new int[number];
	
	  System.out.println();	
	  System.out.print("Please enter the elements in the array: ");
	  for (int i = 0; i < array.length; i++) {
		array[i] = input.nextInt();
	  }
	
	  System.out.println();	
	  int validTriangle = triangleNumber(array);
	  System.out.print("The number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle are: " + validTriangle);  
	}
  }
