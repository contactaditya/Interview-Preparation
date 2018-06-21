import java.util.*;
import java.io.*;

  public class SingleNonDuplicate1 { 
	
	public static int singleNumber(final List<Integer> list) {
	  int number = list.get(0); 	
	  for (int i = 1; i < list.size(); i++) {
	    number = number ^ list.get(i);
	  }	
	  return number; 
	}

	public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the list: ");
      int number = input.nextInt();  
      List<Integer> list = new ArrayList<Integer>();	
			
      System.out.println();	
      System.out.print("Please enter the elements of the list: ");
      for (int i = 0; i < number; i++) {
	    list.add(input.nextInt());
      }
      
      int singleNumber = singleNumber(list); 
      System.out.println();	
      System.out.print("The only element that appears only once in the list is: " + singleNumber);
	}
  }
