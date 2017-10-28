import java.util.*;
import java.io.*;

 public class SuperPow {
	 
    private static final int M = 1337; 
	
    public static int superPow(int a, int[] b) {
       a %= M;
       int result = 1;
       for (int i = b.length - 1; i >= 0; i--) {
         result = result * normalPow(a, b[i]) % M;
         a = normalPow(a, 10);
       }
       return result;   
    }	 
	
    public static int normalPow(int a, int b) {
       int result = 1;
       while (b != 0) {
	 if (b % 2 != 0) {
	   result = result * a % M;
	 }
	 a = a * a % M;
	 b /= 2;
       }
       return result;	    
    }	 

    public static void main(String[] args) {   	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int a = input.nextInt();  
      System.out.println();	
      System.out.print("Enter the number of elements in the array: ");
      int numberOfElements = input.nextInt();
      int b[] = new int[numberOfElements];
      System.out.println();	
      System.out.print("Please enter the elements in the array: ");
      for(int i=0; i < numberOfElements; i++) {
	b[i] = input.nextInt();
      }	
      int result = superPow(a, b);

      System.out.println();	
      System.out.print("The value of a^b mod 1337 is: " + result);
    }
 }
