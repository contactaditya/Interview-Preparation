import java.util.*;
import java.io.*;

  public class NextGreaterElementII {
	  
     public static int[] nextGreaterElements(int[] array) {
        int[] result = new int[array.length];
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        for (int i = 2 * array.length - 1; i >= 0; --i) {
          while (!stack.empty() && array[stack.peek()] <= array[i % array.length]) {
            stack.pop();
          }
          result[i % array.length] = stack.empty() ? -1 : array[stack.peek()];
          stack.push(i % array.length);
        }
        return result;    
     }	  

     public static void main(String[] args) {   
        Scanner input = new Scanner(System.in);
	System.out.print("Enter the elements in the array: ");
	int number = input.nextInt();  
	int array[] = new int[number];
					
	System.out.println();	
	System.out.print("Please enter the elements in the array: ");
	for (int i = 0; i < array.length; i++) {
	  array[i] = input.nextInt();
	}

	int result[] = nextGreaterElements(array);
	System.out.println();	
	System.out.print("The next greater number for every element in the array is: ");
	for (int i=0; i < result.length; i++) {
	  System.out.print(result[i] + " ");
	}	  
     }
  } 
