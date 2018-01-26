import java.util.*;
import java.io.*;
  
  class compareHashSet {

    public static boolean compare(Set<Integer> set1, Set<Integer> set2) {
       if(set1 == null || set2 == null) {
	  return false;
       }
		
       if(set1.size() != set2.size()) {
	  return false;
       }
		
       if(set1.containsAll(set2)) {
	  return true;
       }
		
       return false;
    }
  }

  public class CommonPrimeDivisors { 	
	  
   public static int getCommonPrimeDivisors(int A[], int B[], int N) {    
     int count = 0;
     for(int i = 0; i < A.length; i++) {
       if(isPrimeDivisorsIncluded(A[i], B[i]) && isPrimeDivisorsIncluded(B[i], A[i])) {
	 count++;
       }
     }
	  
     return count; 
   } 
	
   public static boolean isPrimeDivisorsIncluded(int a, int b) {
     while (true) {
       int common = gcd(a, b);
       if(common == 1) {
	 return a == 1;
       }
       a /= common;
     }
   }
	
   public static int gcd(int a, int b) {
     if (b == 0) {
       return a;  
     }  
		     
     return gcd(b, a%b);			
   }

   public static int getCommonPrimeDivisors1(int A[], int B[], int N) {    
     Set<Integer> primeFactorsinA = new HashSet<Integer>();
     Set<Integer> primeFactorsinB = new HashSet<Integer>();
     int count = 0;
     for(int i = 0; i < A.length; i++) {
       primeFactorsinA = primeFactors(A[i]);
       primeFactorsinB = primeFactors(B[i]);
       System.out.println(primeFactorsinA);
       System.out.println(primeFactorsinB);
       System.out.println();	
       if(compareHashSet.compare(primeFactorsinA, primeFactorsinB)) {
	  count++;
       }
     }
     return count; 
   }  
	
   public static Set<Integer> primeFactors(int number) {
     int n = number;
     Set<Integer> factors = new HashSet<Integer>();
     for(int i = 2; i <= n/i; i++) {
       while (n % i == 0) {
         factors.add(i);
         n /= i;
       }
     }
     if (n > 1) {
       factors.add(n);
     }
     
     return factors;
   }

   public static void main(String[] args) { 	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int N = input.nextInt();  
      int A[] = new int[N];
	  
      System.out.println();	
      System.out.print("Please enter the elements in the first array: ");
      for(int i = 0; i < A.length; i++) {
	 A[i] = input.nextInt();
      }
	 
      int B[] = new int[N]; 
      System.out.println();	
      System.out.print("Please enter the elements in the second array: ");
      for(int i = 0; i < B.length; i++) {
	 B[i] = input.nextInt();
      }
	  	  
      int numberofKPositions = getCommonPrimeDivisors(A, B, N);
	  
      System.out.println();		
      System.out.print("The number of positions K for which the prime divisors of A[K] and B[K] are exactly the same are: " + numberofKPositions);   
   }
 }
