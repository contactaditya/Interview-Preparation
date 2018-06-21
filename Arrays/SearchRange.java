import java.util.*;
import java.io.*;

  public class SearchRange {
	  
    public static ArrayList<Integer> searchRange(final List<Integer> a, int b) {
      ArrayList<Integer> result = new ArrayList<Integer>();   
      int low, up;
		
      low = lowerBound(a, 0, a.size() - 1, b);
      if (low == -1) {
        result.add(-1);
	result.add(-1);
	return result;
      }

      up = upperBound(a, 0, a.size() - 1, b);
	  
      result.add(low);
      result.add(up);
		
      return result;
    }	  
	
    public static int lowerBound(final List<Integer> a, int start, int end, int number) {
      int steps = end - start + 1;
      int mid; 
      int low = -1;
      int value;	
      
      while (steps > 0) {
        mid = (start + end)/2;
	value = a.get(mid); 
	if (number < value) {
          end = mid - 1;
        } else if (number > value) {
          start = mid + 1;
        } else {
          low = mid;
          end = mid - 1;	
        }
	steps /= 2;
      }
		
      return low;	
    }
	
    public static int upperBound(final List<Integer> a, int start, int end, int number) {
      int steps = end - start + 1; 
      int mid;
      int up = end + 1;
      int value;		
		
      while (steps > 0) {
        mid = (start + end)/2;
	value = a.get(mid); 
	if (number < value) {
	  end = mid - 1;
        } else if (number > value) {
	  start = mid + 1;
	} else {
	  up = mid;
	  start = mid + 1;	
	}
	steps /= 2;    
      }
		
      return up;
    }

    public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the list: ");
      int number = input.nextInt();  
      List<Integer> a = new ArrayList<Integer>();	
			
      System.out.println();	
      System.out.print("Please enter the elements of the list: ");
      for (int i = 0; i < number; i++) {
	a.add(input.nextInt());
      }
      
      Collections.sort(a);
      
      System.out.println();
      System.out.print("Enter the given target value: ");
      int b = input.nextInt();   
      
      ArrayList<Integer> result = new ArrayList<Integer>();    
      
      result = searchRange(a, b);

      System.out.println();	
      System.out.print("The starting and ending position of the given target value is: " + result);
    }
  }
