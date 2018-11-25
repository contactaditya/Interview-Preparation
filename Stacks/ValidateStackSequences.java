import java.util.*;
import java.io.*;
 
  public class ValidateStackSequences {
	  
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
	  java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
	  int i = 0;
	  // For each value, push it to the stack. Then, greedily pop values from the stack if they are the next values to pop.
	  for (int x : pushed) {
	    stack.push(x);
        while (!stack.empty() && i < pushed.length && stack.peek() == popped[i]) {
          stack.pop();
          i++;
        }    
	  }
		
	  return i == popped.length;     
	}

	public static void main(String[] args) { 	 
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the pushed sequence: ");
	  int number = input.nextInt();  
	  int pushed[] = new int[number];
		  
	  System.out.println();	
	  System.out.print("Please enter the actual numbers: ");
	  for (int i = 0; i < pushed.length; i++) {
	    pushed[i] = input.nextInt();
	  }
		  
	  System.out.println();	
	  System.out.print("Enter number of elements in the popped sequence: ");
	  int number1 = input.nextInt();  
	  int popped[] = new int[number1];
	  
	  System.out.println();	
	  System.out.print("Please enter the actual numbers: ");
	  for (int i = 0; i < popped.length; i++) {
		popped[i] = input.nextInt();
	  }
	  
	  System.out.println();
	  if(validateStackSequences(pushed, popped)) {
		System.out.println("Yes this could have been the result of a sequence of push and pop operations on an initially empty stack.");
	  }
	  else {
	    System.out.println("No this could not have been the result of a sequence of push and pop operations on an initially empty stack.");  
	  }  
      input.close();
	}
  }
