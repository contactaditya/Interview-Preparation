import java.util.*;
import java.io.*;

  public class CountingBits {
	  
	public static int[] countBits(int number) {
	  int[] answer = new int[number + 1];	
	  int offset = 1;
	  for(int i = 1; i <= number; i++) {
	    answer[i] = answer[i & (i - 1)] + 1;
	  }
		
	  return answer;      
	}	  

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();   
	  
	  countBits(number);
	  int result[] = countBits(number);
	  System.out.println();	
	  System.out.print("The number of 1's in the binary representation of the " + number + " are: ");
	  for(int i = 0; i < result.length; i++) {
		System.out.print(result[i] + " ");
	  }
	}
  }
