import java.util.*;
import java.io.*;

  public class PlusOne1 { 	
	  
    public static ArrayList<Integer> plusOne(ArrayList<Integer> list) { 
      int carry = 1;
      int number;
      for(int i = list.size() - 1; i >= 0; i--) {
	number = list.get(i);
	number += carry;
        carry = 0;
        if (number == 10) {
          number = 0;
          carry = 1;
        } 
        list.set(i, number);
      }
	  
      ArrayList<Integer> result = new ArrayList<Integer>();
	  
      if (carry == 1) {
        result.add(1);
      }
	  
      for (int x : list) {
        if (x == 0 && result.size() == 0) {
	  continue;
	}
	result.add(x);
      }
		    
      return result;	     
    }
	
    public static ArrayList<Integer> plusOne1(ArrayList<Integer> list) { 
      ArrayList<Integer> result = new ArrayList<Integer>(list);
      int carry = 1;
      for(int i = list.size() - 1; i >= 0; i--) {
	if (carry == 0) {
	  // no need to check remaining digits
	  break;
	}
	int digit = list.get(i);
	// plus 
	int number = digit + carry;
	if (number >= 10) {
	  carry = number / 10;
	  digit = number % 10;
	} else {
	  carry = 0;
	  digit = number;
	}
	result.set(i, digit);
      }
		  
      if (carry != 0) {
	result.add(0, 1);
      }
      // removing leading zeros
      int index = 0;
      while (index < result.size() && result.get(index) == 0) {
	result.remove(index);
      }
			    
      return result;	     
    }
		
    public static void main(String[] args) { 	 
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of digits in the array: ");
      int number = input.nextInt();  
      ArrayList<Integer> list = new ArrayList<Integer>();	
				
      System.out.println();	
      System.out.print("Please enter the elements of the digits: ");
      for (int i = 0; i < number; i++) {
	list.add(input.nextInt());
      }
	      
      input.close();
      ArrayList<Integer> result = new ArrayList<Integer>();
		 
      result = plusOne1(list); 
      System.out.println();
      System.out.print("The number after adding 1 is: " + result);
    }
  }
