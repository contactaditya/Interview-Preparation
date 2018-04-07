import java.util.*;
import java.io.*;

 public class PrimeSum {
	 
   public static ArrayList<Integer> primeSum(int number) {
     ArrayList<Integer> result = new ArrayList<Integer>();
     if(number < 2) {
       return result;  
     }
       
     int first = 2;
     int second = number - first;
     while(first <= second){
       second = number - first;

       if(isPrime(second) == true && isPrime(first)){
         result.add(first);
         result.add(second);
         return result;
       }
       first++;
     }
     return result;
   } 
    
   public static boolean isPrime(int number) { 	
     if(number < 2) {
       return false;  
     }
     for(int i=2; i<=Math.sqrt(number); i++) {
       if(number % i==0) {
         return false;
       }
     }
     return true;
   }

   public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     System.out.print("Enter an even number greater than 2: ");
     int number = input.nextInt();  
     ArrayList<Integer> result = new ArrayList<Integer>();
			
     result = primeSum(number);
     System.out.println();	
     System.out.print("The two prime numbers whose sum will be equal to given number: " + result);
   }
 }
