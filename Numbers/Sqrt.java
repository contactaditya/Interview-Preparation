import java.util.*;
import java.io.*;

  public class Sqrt {
	 
    public static int mySqrt(int number) { 
      if (number == 0) {
	return 0;
      }
      int start = 1, end = number;
      while (start < end) { 
	int mid = start + (end - start) / 2;
	if (mid <= number/mid && (mid + 1) > number/(mid + 1)) { 
	  return mid; 
        }
	else if (mid > number/mid) {
	  end = mid;
	}
	else {
	  start = mid + 1;
	}
      }
	   
      return start;	 
    }
	
    public static int mySqrt1(int number) {
      if (number == 0) {
	return 0;
      }
      long i = number;
      while(i * i > number) {  
	i = (i + number / i) / 2;
      }
      return (int)i;
    } 

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();  
			
      int squareRoot = mySqrt(number);

      System.out.println();	
      System.out.print("The square root of the " + number + " is: " + squareRoot);  
    }
  }
