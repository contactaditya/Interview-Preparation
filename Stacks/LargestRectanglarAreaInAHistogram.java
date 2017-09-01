import java.util.*;
import java.io.*;

  public class LargestRectanglarAreaInAHistogram { 	
	
    public static int getMaxArea(int[] histogram, int n) {
       java.util.Stack<Integer> stack = new java.util.Stack<>();	
       int maximumArea = 0;
       int topOfTheStack = 0;
       int AreaWithTop = 0;
       int i = 0;
       
       // Run through all bars of given histogram
       while(i < n) {
    	 // If this bar is higher than the bar on top stack, push it to stack  
    	 if (stack.empty() || histogram[stack.peek()] <= histogram[i]) {
    	   stack.push(i++);	  
    	 }
    	 else {
    	   topOfTheStack = stack.peek();  // store the top index
    	   stack.pop(); // pop the top
    	   
           // Calculate the area with histogram[topOfTheStack] stack as smallest bar
    	   AreaWithTop = histogram[topOfTheStack] * (stack.empty() ? i : i - stack.peek() - 1);
    	   
    	   if (maximumArea < AreaWithTop) {
    	      maximumArea = AreaWithTop;
    	   }
    	 }
       }
       
       // Now pop the remaining bars from stack and calculate area with every popped bar as the smallest bar
       
       while (stack.empty() == false) {
    	 topOfTheStack = stack.peek();  // store the top index
    	 stack.pop(); // pop the top
    	   
         // Calculate the area with histogram[topOfTheStack] stack as smallest bar
    	 AreaWithTop = histogram[topOfTheStack] * (stack.empty() ? i : i - stack.peek() - 1);
    	   
    	 if (maximumArea < AreaWithTop) {
    	   maximumArea = AreaWithTop;
    	 }
       }
      
       return maximumArea;
    }	

    public static void main(String[] args) { 	  
	Scanner input = new Scanner(System.in);
	System.out.print("Enter number of elements in the array: ");
	int number = input.nextInt();  
	int histogram[] = new int[number];
	
	System.out.println();	
	System.out.print("Please enter the elements in the array: ");
	for (int i = 0; i < histogram.length; i++) {
	  histogram[i] = input.nextInt();
	}
		  
	System.out.println();
	int maxArea = getMaxArea(histogram, histogram.length);
	System.out.print("The largest rectangular area in the given histogram is: " + maxArea);
    }
  }
