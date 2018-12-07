import java.util.*;
import java.io.*;

  public class FindTheIndexCharacterInABinaryStringObtainedAfterNIterations {
	  
	public static int findCharacter(int n, int m, int i) {
	  int distance = (int)Math.pow(2, n); 
      int blockNumber = i/distance; 
	  int remaining = i % distance; 
	  
	  int s[] = new int[32]; 
	  int x = 0; 
	  
	  // binary representation of M 
	  for (; m > 0; x++) { 
	    s[x] = m % 2; 
	    m = m / 2; 
	  } 
	  
	  int root = s[x - 1 - blockNumber]; 
	  if (remaining == 0) { 
	    return root; 
	  } 
	  boolean flip = true; 
	  while (remaining > 1) { 
	    if ((remaining & 1) > 0) { 
	      flip = !flip; 
	    } 
	    remaining = remaining >> 1; 
	  } 
	  if (flip) { 
	    if (!(root > 0)) { 
	      return root; 
	    }
	  } 
	  else { 
	    return root; 
	  }
	  return root; 
	}

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the decimal number: ");
	  int m = input.nextInt();  
	  System.out.println();	
	  System.out.print("Enter the number of iterations: ");
	  int n = input.nextInt();  
	  System.out.println();	
	  System.out.print("Enter the index of the character: ");
	  int i = input.nextInt();  
		  
	  int indexCharacter = findCharacter(m, n, i);
	  System.out.println();	
	  System.out.println("The ith index character in the string after nth iteration is: " + indexCharacter); 
	  input.close();
	}
  }
