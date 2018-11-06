import java.util.*;
import java.io.*;

  public class FindLargestSubsetWhoseAllElementsAreFibonacciNumbers { 
	  
    public static void findFibSubset(ArrayList<Integer> list) {     
      int max = Collections.max(list); 	
      List<Integer> fib = new ArrayList<Integer>();  
      List<Integer> result = new ArrayList<Integer>(); 
      
      int a = 0, b = 1;
      while (b < max) { 
        int c = a + b; 
        a = b; 
        b = c; 
        fib.add(c); 
      }
      for (int i = 0; i < list.size(); i++) {
      	if(fib.contains(list.get(i))) {
      	  result.add(list.get(i));
      	}
      }
      Collections.sort(result);
      System.out.println();	
      System.out.println("The largest subset from list that contain elements which are Fibonacci numbers is: " + result);   
	}

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);	  		  
      System.out.print("Enter number of elements in the list: ");
      int number = input.nextInt();  
      ArrayList<Integer> list = new ArrayList<Integer>();	
			
      System.out.println();	
      System.out.print("Please enter the elements of the list: ");
      for (int i = 0; i < number; i++) {
    	list.add(input.nextInt());
      }
	   
	  findFibSubset(list);
	  input.close();
	}
  }
