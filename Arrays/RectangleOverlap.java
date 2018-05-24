import java.util.*;
import java.io.*;

  public class RectangleOverlap {
	  
	public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
	  // width is the intersection of the rectangles projected onto the x-axis, and height is the same for the y-axis
	  return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) && Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));  
	}	  

	public static void main(String[] args) {      
	  Scanner input = new Scanner(System.in);
      int array[] = new int[4];
		  
      System.out.print("Please enter the sides of the first rectangle: ");
      for (int i = 0; i < array.length; i++) {
	    array[i] = input.nextInt();
      }
		    
      int array1[] = new int[4];
		  
      System.out.println();	
      System.out.print("Please enter the sides of the second rectangle: ");
      for (int i = 0; i < array1.length; i++) {
	    array1[i] = input.nextInt();
      }
		  	  
      boolean result = isRectangleOverlap(array, array1);
      System.out.println();	
	  if(result) {
	    System.out.print("The two rectangles do overlap.");
	  }
	  else {
		System.out.print("The two rectangles do not overlap.");  
	  }
	}
  }
