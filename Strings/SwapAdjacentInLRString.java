import java.util.*;
import java.io.*;

  public class SwapAdjacentInLRString {
	  
	public static boolean canTransform(String start, String end) {
	  int right = 0, left = 0;
	  for (int i = 0; i< start.length(); i++) {
	    if (start.charAt(i) == 'R') {
	      right++;
	    }
        if (end.charAt(i) == 'L') {
          left++;
        }
        if (start.charAt(i) == 'L') {
          left--;
        }
        if (end.charAt(i) == 'R') {
          right--;    	
        }
        if ((left < 0 || right != 0) && (left != 0 || right < 0)) {
          return false;
        }
	  }
	  
      if (left == 0 || right == 0) {
        return true;
      }
	     
	  return false;
	}	  
 
	public static void main(String[] args) {      
	  String start = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the smaller string: ");
      start = input.nextLine(); 
	  
      System.out.println();
	   
      String end = new String();	  
      System.out.print("Enter the second string: ");
      end = input.nextLine(); 
	  
      boolean canTransform = canTransform(start, end);
	  
      System.out.println();
	  
      if(canTransform) {
        System.out.print("There exists a sequence of moves to transform from " + start + " to " + end);
      } else {
        System.out.println("There exists no sequence of moves to transform from " + start + " to " + end);  
      }
	}
  }
