import java.util.*;
import java.io.*;

 public class DecodeWays {
	 
   public static int numDecodings(String string) {
      if(string == null || string.length() == 0) {
	 return 0;
      } 
      int n = string.length();
      int[] dp = new int[n+1];
      dp[0] = 1;
      for(int i = 1; i <= n; i++) {
        if(string.charAt(i-1) >= '1' && string.charAt(i-1) <= '9') {
          dp[i] = dp[i-1];  
        }
        if(i > 1) {
          if(string.charAt(i-2) == '1' || string.charAt(i-2) == '2' && string.charAt(i-1) <= '6') {
            dp[i] += dp[i-2];
          }
        }
      }
      return dp[n];     
   }	 

   public static void main(String[] args) {   
      String string = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enstring = input.nextLine(); 
      int totalNumberOfWays = numDecodings(string);
      System.out.println();
      System.out.println("The total number of ways to decode the encoded message containing digits are: " + totalNumberOfWays);  
   }
 }
