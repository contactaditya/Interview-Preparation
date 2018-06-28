import java.util.*;
import java.io.*;

  public class BuddyStrings {  
	 
    public static boolean buddyStrings(String A, String B) {   
      if (A.equals(B)) {
        int[] count = new int[26];
        for (int i = 0; i < A.length(); i++) {
          count[A.charAt(i) - 'a']++;
        }

        for (int c : count) {
          if (c > 1) {
            return true;
          }
        }
       
        return false;
      } else {
        int first = -1, second = -1;
        for (int i = 0; i < A.length(); i++) {
          if (A.charAt(i) != B.charAt(i)) {
            if (first == -1) {
              first = i;
            }
            else if (second == -1) {
              second = i;
            }
            else {
              return false;
            }
          }
        }
        return (second != -1 && A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first)); 
      }
    }

    public static void main(String[] args) {   
      String A = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the first string: ");
      A = input.nextLine();  
      System.out.println();	
      String B = new String();	  
      System.out.print("Enter the second string: ");
      B = input.nextLine();
	  
      boolean result = buddyStrings(A, B);
      System.out.println();
      if(result) {
	System.out.println("Yes we can swap two letters in " + A + " so that the result equals " + B);  
      }
      else {
	System.out.println("No we cannot swap two letters in " + A + " so that the result equals " + B);  
      }
    }
  }
