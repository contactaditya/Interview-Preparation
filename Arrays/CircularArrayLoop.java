import java.io.*;
import java.util.*;

  public class CircularArrayLoop {    
	
    public static boolean circularArrayLoop(int[] array) {
      if(array == null || array.length == 0) {
    	return false;
      }
      for (int i = 0; i < array.length; i++) {
        int current = i;    
        if(array[current] == 0) {
          continue;
        }
        while (array[current] != 0) {
          // pay attention to steps, which is the next index, forward or backward.
          int index =  array[current] > 0 ? ((current + array[current]) % array.length) : (array.length - Math.abs((current + array[current]) % array.length)) % array.length;
          array[current] = 0;
          current = index;
        }  
        
        if (current == i) {
          return true;
        }
      }
            
      return false;
    }	

    public static void main(String[] args) { 
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
	
      System.out.println();	
      System.out.print("Please enter the elements of the array: ");
      for (int i = 0; i < array.length; i++) {
	array[i] = input.nextInt();
      }
	  
      boolean circularArrayLoop = circularArrayLoop(array);
      System.out.println();	
	  
      if(circularArrayLoop) {
	System.out.println("There is a circular array loop.");  
      }
      else {
	System.out.println("There is no circular array loop.");    
      }
    }
  }

