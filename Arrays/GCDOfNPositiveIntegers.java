import java.util.*;
import java.io.*;

   public class GCDOfNPositiveIntegers {
	  
     public static int gcd(int a, int b) {
       if(a == 0) {
	 return b;      
       }      
	      
       return gcd(b % a, a);      
     }    

     // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
     public static int generalizedGCD(int number, int[] array) {
       int result = array[0];
       for(int i = 1; i < array.length; i++) {
	 result = gcd(array[i], result);  
       }
	      
       return result;
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
	 
       int result = generalizedGCD(numbers, array);

       System.out.println();	
       System.out.print("The GCD of N positive integers in the array is: " + result);
     }
   }
