import java.util.*;
import java.io.*;

  public class HammingDistance {
	  
	public static int hammingDistance(int x, int y) {
	  int result = x^y;	
      int count = 0;
      do {
        count += result & 1;
        result = result >> 1;
      } while(result != 0);
              
      return count;
	}	  

	public static void main(String[] args) {        
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the first integer: ");
	  int x = input.nextInt();  
	  System.out.println();	
	  System.out.print("Enter the second integer: ");
	  int y = input.nextInt();  
	  
	  int hammingDistance = hammingDistance(x, y);
	  System.out.println();	
	  System.out.print("The hamming distance is: " + hammingDistance);
	}
  }
