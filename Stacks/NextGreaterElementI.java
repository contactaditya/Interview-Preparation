import java.util.*;
import java.io.*;

 public class NextGreaterElementI {
	 
	public static int[] nextGreaterElement(int[] array1, int[] array2) {
	   Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // map from x to next greater element of x
	   java.util.Stack<Integer> stack = new java.util.Stack<Integer>();	
	   for (int number : array2) {
         while (!stack.isEmpty() && stack.peek() < number) {
           map.put(stack.pop(), number);
         }
         stack.push(number);
       }   
	   for (int i = 0; i < array1.length; i++) {
		 array1[i] = map.getOrDefault(array1[i], -1);
	   }
		
	   return array1;    
	} 

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number of elements in the first array: ");
	  int number1 = input.nextInt();  
	  int array1[] = new int[number1];
					
	  System.out.println();	
	  System.out.print("Please enter the elements in the first array: ");
	  for (int i = 0; i < array1.length; i++) {
		array1[i] = input.nextInt();
	  }
	  System.out.println();	
	  System.out.print("Enter the number of elements in the second array: ");
	  int number2 = input.nextInt();  
	  int array2[] = new int[number2];
					
	  System.out.println();	
	  System.out.print("Please enter the elements in the second array: ");
	  for (int i = 0; i < array2.length; i++) {
		array2[i] = input.nextInt();
	  }
	
	  int result[] = nextGreaterElement(array1, array2);
	  System.out.println();	
	  System.out.print("The next greater numbers for array1's elements in the corresponding places of array2 are: ");
	  for (int i=0; i < result.length; i++) {
		System.out.print(result[i] + " ");
	  }	  
	}
 }
