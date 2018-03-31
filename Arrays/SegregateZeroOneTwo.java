import java.io.*;
import java.util.*;

public class SegregateZeroOneTwo {    
	 
  public static void segregateZeroOneTwo(int[] array) {
    int low = 0, high = array.length - 1;
    int mid = 0, temp=0;
    while(mid <= high) {
      switch (array[mid]) {
         case 0: temp =  array[low];
                 array[low]  = array[mid];
                 array[mid] = temp;
                 low++;
                 mid++;
                 break;
         case 1: mid++;
         	 break;
         case 2: temp = array[mid];
         	 array[mid] = array[high];
                 array[high] = temp;
                 high--;
                 break;         
      }
    } 
  }
   
  public static void main(String[] args) {    
    Scanner input = new Scanner(System.in);
    System.out.print("Enter number of elements in the array: ");
    int number = input.nextInt();  
    int array[] = new int[number];
			
    System.out.println();	
    System.out.print("Please enter the actual values in the array which are either 0 or 1 or 2: ");
    for (int i = 0; i < array.length; i++) {
      array[i] = input.nextInt();
    }
				 
    segregateZeroOneTwo(array);
    System.out.print("\n");
			    
    System.out.print("The array after segregation is: ");
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
  }
}
