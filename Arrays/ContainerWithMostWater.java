import java.util.*;
import java.io.*;

  public class ContainerWithMostWater {
	
    public static int maxArea(int[] height) {
	  int maxArea = 0, left = 0, right = height.length - 1;
	  while (left < right) {
	    maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
        if (height[left] < height[right]) {
          left++;
        }
        else {
          right--;
        }
      }
    
	  return maxArea;  
    }	

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int number = input.nextInt();  
	  int height[] = new int[number];
	
	  System.out.println();	
	  System.out.print("Please enter the elements in the array: ");
	  for (int i = 0; i < height.length; i++) {
	    height[i] = input.nextInt();
	  }
	  
	  int maxArea = maxArea(height);
	  System.out.println();	
	  System.out.print("The maximum area that can be formed between the vertical lines using the shorter line as length and the distance between the lines as the width of the rectangle forming the area is: " + maxArea);
	}
  }
