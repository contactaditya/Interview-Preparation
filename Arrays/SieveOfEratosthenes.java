import java.util.*;
import java.io.*;

 public class SieveOfEratosthenes { 
	
   public static void sieveOfEratosthenes(int number) { 
      // Create a boolean array "prime[0..n]" and initialize all entries it as true. A value in prime[i] will finally be false if i is Not a prime, else true.	
      boolean prime[] = new boolean[number+1];
      for(int i=0; i<number; i++) {
         prime[i] = true;
      }
	  
      for(int p = 2; p*p <= number; p++) {
        // If prime[p] is not changed, then it is a prime
        if(prime[p] == true) {
          // Update all multiples of p 
          for(int i = p*2; i <= number; i += p) {
             prime[i] = false;	 
          } 
        }
      }
		  
      // Print all prime numbers
      for(int i = 2; i <= number; i++) {
        if(prime[i] == true) {
          System.out.print(i + " ");
        }
      }
   } 
	 
   public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number below which you want to find out all the prime numbers: "); 
      int number = input.nextInt();  
	  	
      System.out.println();
      System.out.print("Following are the prime numbers below " + number + " are: ");
      sieveOfEratosthenes(number);
   }
 }
