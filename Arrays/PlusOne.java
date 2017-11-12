import java.util.*;
import java.io.*;
 
  public class PlusOne {
	  
     public static int[] plusOne(int[] digits) {
	int n = digits.length;
	for(int i=n-1; i>=0; i--) {
	  if(digits[i] < 9) {
	     digits[i]++;
	     return digits;
          }       
	  digits[i] = 0;
	}
		    
	int[] newNumber = new int [n+1];
	newNumber[0] = 1;
		    
	return newNumber;	     
     }	  

     public static void main(String[] args) {   
        Scanner input = new Scanner(System.in);
	System.out.print("Enter number of elements in the array: ");
	int number = input.nextInt();  
	int digits[] = new int[number];
		
	System.out.println();	
	System.out.print("Please enter the elements of the array: ");
	for (int i = 0; i < digits.length; i++) {
	   digits[i] = input.nextInt();
	}
		 
	int plusOne[] = plusOne(digits); 
	System.out.println();
	System.out.print("The array after wiggle sort is: ");
	for (int i=0; i < plusOne.length; i++) {
	   System.out.print(plusOne[i] + " ");
	}  
     }
  }
