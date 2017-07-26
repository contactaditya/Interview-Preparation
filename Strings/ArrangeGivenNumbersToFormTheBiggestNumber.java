import java.util.*;
import java.io.*;

 public class ArrangeGivenNumbersToFormTheBiggestNumber {    
	 
	public static String printLargest(String[] array) {
					   
	   // Comparator to decide which string should come first in concatenation
	   Comparator<String> comp = new Comparator<String>(){
		 @Override
		 public int compare(String string1, String string2) {
		   String s1 = string1 + string2;
		   String s2 = string2 + string1;
		   return s2.compareTo(s1); // reverse order here, so we can do append() later
		 }
	   };
	   
	   Arrays.sort(array, comp);
	   StringBuilder sb = new StringBuilder();
	   for(String s: array) {
          sb.append(s);
	   }
	   

	   String result = sb.toString();
	   if (result.length() > 0 && result.charAt(0) == '0') {
		 return "0";
	   }
	   
	   return result;
    }	

	public static void main(String[] args) { 	   
	   Scanner input = new Scanner(System.in);
	   System.out.print("Enter number of elements in the array: ");
	   int numbers = input.nextInt();   
	   String array[] = new String[numbers];
	    
	   System.out.println();
	   System.out.print("Please enter the actual values in the array: ");
	   for (int i = 0; i < numbers; i++) {
		 array[i] = input.next(); 
	   }
	   
	   String largest = printLargest(array);
	   
	   System.out.println();
	   System.out.print("The biggest number that can be formed from the given number is: " + largest);	

	}
 }
