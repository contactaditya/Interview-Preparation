import java.util.*;
import java.io.*;
 
  public class LeadersInAnArray { 	
	
    public static void printLeaders(int array[]) { 
      int maxFromRight = array[array.length - 1];	
      /* Rightmost element is always leader */
      System.out.println();
      System.out.print("All the leaders in the array are: ");
      System.out.print(maxFromRight + " ");
      for (int i = array.length - 2; i >= 0; i--) {
        if(maxFromRight < array[i]) {           
          maxFromRight = array[i];
          System.out.print(maxFromRight + " ");
        }
      }    
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
	   
      printLeaders(array);
	  
    }
  }
