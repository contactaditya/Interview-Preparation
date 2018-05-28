import java.util.*;
import java.io.*;

  public class BitwiseANDOfNumbersRange {
	  
	public static int rangeBitwiseAnd(int m, int n) {  
	  int offset = 0;	
      while(m != n) {
    	m >>= 1;
        n >>= 1;
        offset++;
      }
			        
	  return m <<= offset;     
    }	  
	  
	public static int rangeBitwiseAnd1(int m, int n) {  
	  while(m < n) {
		n = n & (n-1);
	  }
	        
	  return n;     
    }	  

	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int m = input.nextInt();  
      
      System.out.println();	
      System.out.print("Enter the number: ");
      int n = input.nextInt();  
      
      int result = rangeBitwiseAnd(m, n);
      System.out.println();	
      System.out.print("The bitwise AND of all numbers in this range is: " + result);
	}
  }
