import java.util.*;
import java.io.*;

  public class LemonadeChange {
	   
	public static boolean lemonadeChange(int[] bills) {
	  int five = 0, ten = 0;
	  for (int bill : bills) {
        if (bill == 5) {
          five++;
        }
        else if (bill == 10) {
          five--;
          ten++;
        } 
        else if (ten > 0) {
          ten--;
          five--;
        } 
        else {
          five -= 3;
        } 
        if (five < 0) {
          return false;
        }
      }
   	
	  return true;      
	}	  

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of customers: ");
	  int numbers = input.nextInt();   
	  int bills[] = new int[numbers];
	    
	  System.out.println();
	  System.out.print("Please enter the actual value of the bill of every customer: ");
	  for (int i = 0; i < numbers; i++) {
		bills[i] = input.nextInt(); 
	  }
	   
	  boolean result = lemonadeChange(bills);
	  
	  System.out.println();
	  
      if(result) {
        System.out.print("Yes we can provide every customer with correct change.");	
      }
      else {
        System.out.print("No we cannot provide every customer with correct change.");	
      }
	}
  }
