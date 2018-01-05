import java.util.*;
import java.io.*;

  public class BinaryGap {
	  
	public static int getBinaryGap(int number) {
	  return getBinaryGap(number, 0, 0);
	} 
	
	public static int getBinaryGap(int number, int maxGap, int currentGap) {
	  if (number == 0) {
	    return maxGap;
	  }
	  else if (number % 2 == 0) {
	    return getBinaryGap(number/2, maxGap, currentGap + 1);
	  }
	  else {
	    return getBinaryGap(number/2, Math.max(maxGap, currentGap), 0);
	  }
	}
	
	public static int getBinaryGap1(int number) {
	  int currentGap = 0;
	  int maxGap = 0;
	  
	  while(number > 0) {
	    if (number % 2 == 0) {
	      currentGap++;
	    }
	    else {
	      maxGap = Math.max(maxGap, currentGap);
	      currentGap = 0;
	    }
	    number /= 2;    
	  }
	  
	  return maxGap;
    } 

	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();  

	  int longestBinaryGap = getBinaryGap1(number);
	  System.out.println();	
	  System.out.print("The length of the longest binary gap is: " + longestBinaryGap);
	}
  }
