import java.util.*;
import java.io.*;

  public class MajorityElement {   
	   
   public static int majorityElement(int array[]) {
      if (array.length == 0) {
        return 0;  
      }
      int result = 0, count = 0;
      
      for(int i = 0; i < array.length; i++) {
        if(count == 0) {
          result = array[i];
          count = 1;
        } else if(result == array[i]) {
           count++;
        } else {
           count--;
        }
      }
 
      return result;  
   }

   public static void main(String[] args) {   
       Scanner input = new Scanner(System.in);
       System.out.print("Enter number of elements in the array: ");
       int numbers = input.nextInt();   
       int array[] = new int[numbers];

       System.out.print("\n");
       System.out.print("Please enter the actual values in the array: ");
       for (int i = 0; i < numbers; i++) {
	  array[i] = input.nextInt();
       }
	
       int majorityElement = majorityElement(array); 
       System.out.println();	
       System.out.print("The majority element that appears more than n/2 times in the array is: " + majorityElement);
   }
}
