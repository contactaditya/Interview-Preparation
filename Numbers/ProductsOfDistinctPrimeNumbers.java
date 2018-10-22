import java.io.*;
import java.util.*;

  public class ProductsOfDistinctPrimeNumbers {
	   
	public static List<Integer> primeProducts(int number) {
	  List<Integer> result = new ArrayList<Integer>();
	  List<Integer> primeNumbers = new ArrayList<Integer>();
	  for(int i = 0; i < number; i++) {
		if(isPrime(i)) {
		  primeNumbers.add(i);    
		}
      }
	  for(int i = 0; i < primeNumbers.size(); i++) {
		for (int j = i + 1; j < primeNumbers.size(); j++) { 
		  if(primeNumbers.get(i) * primeNumbers.get(j) < number) {
		    result.add(primeNumbers.get(i) * primeNumbers.get(j));    
		  }	
	    }
	  }
	  
	  Collections.sort(result); 
	  return result;
	}
	
	public static boolean isPrime(int number) { 	
	  if(number < 2) {
	    return false;  
	  }
	  for(int i = 2; i <= Math.sqrt(number); i++) {
	    if(number % i == 0) {
	      return false;
	    }
	  }
	  return true;
	}

	public static void main(String[] args) { 
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();   
	  List<Integer> result = new ArrayList<Integer>();
	  result = primeProducts(number);
	  System.out.println();
	  System.out.println("The list of numbers less than " + number + " which are a product of distinct prime numbers is: " + result);
	} 
  }
