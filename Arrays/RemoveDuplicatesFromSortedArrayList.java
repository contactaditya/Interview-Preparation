import java.util.*;
import java.io.*;

  public class RemoveDuplicatesFromSortedArrayList {
	  
	public static int removeDuplicates(ArrayList<Integer> list) { 	 
	  int index = 1, count = 1;	
	  for (int i = 1; i < list.size(); i++) {
	    if (list.get(i).intValue() == list.get(i - 1) && count < 2) {
	      list.set(index, list.get(i));
	      count++;
	      index++;
	    }
	    else if(list.get(i).intValue() != list.get(i - 1)) {  
	      list.set(index, list.get(i));
		  count = 1;
		  index++;
	    }
	  }   
			  
	  return index;
	}	  

	public static void main(String[] args) { 	 
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the list: ");
      int number = input.nextInt();  
      ArrayList<Integer> list = new ArrayList<Integer>();	
			
      System.out.println();	
      System.out.print("Please enter the elements of the list: ");
      for (int i = 0; i < number; i++) {
	    list.add(input.nextInt());
      }
		  
	  Collections.sort(list);
		  
	  int newLength = removeDuplicates(list); 
	  System.out.println();	
	  System.out.print("The new length of the arraylist such that each element can appear atmost twice is: " + newLength);
	}
  }
