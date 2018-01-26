import java.util.*;
import java.io.*;

  public class CountSemiprimes {
	  
    public static int[] countSemiprimes(int N, int[] P, int[] Q) {
      boolean[] notPrime = notPrime(N);
      boolean[] semiPrime = semiPrime(N, notPrime);	
      int[] result = new int[P.length];
	  
      int[] sum = new int[N + 1];
      int index = 0;
      for (int i = 1; i <= N; i++) {
	sum[i] = sum[i - 1] + (semiPrime[i] ? 1 : 0);
	while (index < Q.length && i >= Q[index]) {
           result[index] = sum[Q[index]] - sum[P[index] - 1];
           index++;
	}
      }
		
      return result;  
    }

    private static boolean[] semiPrime(int number, boolean[] notPrime) {
      boolean semiPrime[] = new boolean[number+1];		  
      for(int p = 2; p*p <= number; p++) {
        if(!notPrime[p]) {
	  semiPrime[p * p] = true;	

          for(int i = p*(p+1); i <= number; i += p) {
	    if(!notPrime[i/p]) {
	      semiPrime[i] = true;	
	    }
	  } 
        }
      }
					      
      return semiPrime;   
    }

    private static boolean[] notPrime(int number) {   
      boolean notPrime[] = new boolean[number+1];
      notPrime[0] = notPrime[1] = true;
	  
      for(int p = 2; p*p <= number; p++) {
        if(!notPrime[p]) {
	  for(int i = p*p; i <= number; i += p) {
	    notPrime[i] = true;	 
	  } 
	}
      }
				      
      return notPrime;   
    }

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int P[] = new int[number];
	  
      System.out.println();	
      System.out.print("Please enter the elements in the first array: ");
      for(int i = 0; i < P.length; i++) {
	 P[i] = input.nextInt();
      }
	 
      int Q[] = new int[number]; 
      System.out.println();	
      System.out.print("Please enter the elements in the second array: ");
      for(int i = 0; i < Q.length; i++) {
	 Q[i] = input.nextInt();
      }
	  
      System.out.println();	
      System.out.print("Enter an integer which indicates the upper end of the range: ");
      int N = input.nextInt();  
	  
      int result[] = countSemiprimes(N, P, Q);
	  
      System.out.println();		
      System.out.print("The number of semi primes within specified ranges is as follows: ");   
      for(int i=0; i < result.length; i++) {     
        System.out.print(result[i] + " ");
      }	  
    }
  }
