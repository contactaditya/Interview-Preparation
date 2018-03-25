import java.io.*;
import java.util.*;

public class PowerSet {   
	
   public static void printPowerSet(char array[]) { 
     int n = array.length;
   
     System.out.println();
     System.out.println("The actual power set is: ");
   
     // Run a loop for printing all 2^n subsets one by one
     for (int i = 0; i < (1<<n); i++) {
       System.out.print("{");
       for (int j = 0; j < n; j++) {  
         // Run a loop for printing all 2^n subsets one by one
         if ((i & (1 << j)) > 0) {
           System.out.print(array[j] + "");  
         }   
       }  
       System.out.println("}");
     }
   }

   public static void main(String[] args) { 	
     Scanner input = new Scanner(System.in);
     System.out.print("Enter number of characters in the set: ");
     int number = input.nextInt();  
     char array[] = new char[number];
  
     System.out.println();	
     System.out.print("Please enter the actual characters: ");
     for (int i = 0; i < array.length; i++) {
       array[i] = input.next().charAt(0);
     }
    	   	
     printPowerSet(array);
   }
}
