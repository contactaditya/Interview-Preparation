import java.io.*;
import java.util.*;

 public class FindTheClosestPalindrome {   
	 
   public static String nearestPalindromic(String number) { 
	  if (number.equals("1")) {
        return "0";
	  }
	  
	  // If replication is used to generate the palindromic number, we should always replicate the first half to the second half. In this implementation, we've stored such a number in a at a difference of diff1 from the number.

      String a = mirroring(number);
      long diff1 = Long.MAX_VALUE;
      diff1 = Math.abs(Long.parseLong(number) - Long.parseLong(a));
      if (diff1 == 0) {
        diff1 = Long.MAX_VALUE;
      }
      
      // Now, whenever we find a 0 near the middle index, in order to consider the palindromes which are lesser than n, we subtract a 1 from the first half of the number to obtain a new palindromic half.
      
      StringBuilder s = new StringBuilder(number);
      int i = (s.length() - 1)/2;
      while (i >= 0 && s.charAt(i) == '0') {
        s.replace(i, i + 1, "9");
        i--;
      }
      if (i == 0 && s.charAt(i) == '1') {
        s.delete(0, 1);
        int mid = (s.length() - 1) / 2;
        s.replace(mid, mid + 1, "9");
      } else {
        s.replace(i, i + 1, "" + (char)(s.charAt(i) - 1));
      }
      String b = mirroring(s.toString());
      long diff2 = Math.abs(Long.parseLong(number) - Long.parseLong(b));
      
      // Now, whenever we find a 9 near the middle index, we need to consider the numbers larger than the current number. We add a 1 to the first half. 

      s = new StringBuilder(number);
      i = (s.length() - 1) / 2;
      while (i >= 0 && s.charAt(i) == '9') {
        s.replace(i, i + 1, "0");
        i--;
      } 
      if (i < 0) {
        s.insert(0, "1");
      } else {
        s.replace(i, i + 1, "" + (char)(s.charAt(i) + 1));
      }
      String c = mirroring(s.toString());
      long diff3 = Math.abs(Long.parseLong(number) - Long.parseLong(c));
	  
      if (diff2 <= diff1 && diff2 <= diff3) {
        return b;
      }
      if (diff1 <= diff3 && diff1 <= diff2) {
        return a;
      }
      else {
        return c;
      }
   }	

	public static String mirroring(String number) {
	  String x = number.substring(0, (number.length())/2);
	  return x + (number.length() % 2 == 1 ? number.charAt(number.length()/2) : "") + new StringBuilder(x).reverse().toString();
    }

	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  String number = input.nextLine();  
			  
	  String closestPalindrome = nearestPalindromic(number); 
	  System.out.println();
	  System.out.println("The closest integer which is a palindrome is: " + closestPalindrome);
	}
 }
