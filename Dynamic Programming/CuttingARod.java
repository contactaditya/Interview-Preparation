import java.util.*;
import java.io.*;

 public class CuttingARod {
	
   public static int cuttingARod(int[] price, int length) {
     int value[] = new int[length+1];
     value[0] = 0;
     // Build the table val[] in bottom up manner and return the last entry from the table
     for (int i = 1; i<=length; i++) {
       int maximumValue = Integer.MIN_VALUE;
       for (int j = 0; j < i; j++) {
         maximumValue = Math.max(maximumValue, price[j] + value[i-j-1]);
       }
       value[i] = maximumValue;
     }  
     return value[length];
   }

   public static void main(String[] args) { 	
     Scanner input = new Scanner(System.in);
     System.out.print("Enter number of elements in the first array: ");
     int number = input.nextInt();  
     int price[] = new int[number];
	
     System.out.println();	
     System.out.print("Please enter the different values of prices of all pieces of the rod: ");
     for (int i = 0; i < price.length; i++) {
       price[i] = input.nextInt();
     }
	  
     int size = price.length;
     int maximumValue = cuttingARod(price, size);
     System.out.println();	
     System.out.print("The maximum value obtained by cutting the rod and selling the pieces is: " + maximumValue);
   }
 }
