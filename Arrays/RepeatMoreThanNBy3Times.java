import java.io.*;
import java.util.*;

  public class RepeatMoreThanNBy3Times {
	
    public static int repeatedNumber(final List<Integer> list) {
      int count1 = 0, count2 = 0;
      int first = Integer.MAX_VALUE; 
      int second = Integer.MAX_VALUE; 
      
      for (int i = 0; i < list.size(); i++) {
        if (first == list.get(i)) { 
          count1++;   
        }
        else if (second == list.get(i)) {
          count2++;
        }
        else if (count1 == 0) { 
          count1++; 
          first = list.get(i); 
        } 
        else if (count2 == 0) { 
          count2++; 
          second = list.get(i); 
        } 
        else { 
          count1--; 
          count2--; 
        } 
      }
      count1 = 0; 
      count2 = 0; 
      for (int i = 0; i < list.size(); i++) { 
        if (list.get(i) == first) { 
          count1++; 
        }
        else if (list.get(i) == second) { 
          count2++; 
        }
      }  
      if (count1 > list.size() / 3) { 
        return first; 
      }
      if (count2 > list.size() / 3) { 
        return second; 
      }
	  
      return -1;
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
		  
      int repeatedNumber = repeatedNumber(list); 
      System.out.println();	
      System.out.print("The integer that occurs more than n/3 times in the array is: " + repeatedNumber);
      input.close();
    }
  }
