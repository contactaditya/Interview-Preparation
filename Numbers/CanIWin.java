import java.util.*;
import java.io.*;
 
  public class CanIWin {
	  
	public static boolean canIWin(int maxChoosableInteger, int desiredTotal) { 
      if (desiredTotal < 1) {
    	return true;	
	  }
      
      int sum = (1 + maxChoosableInteger) * maxChoosableInteger/2;
      
	  if(sum < desiredTotal) {
		return false;
	  }
	  
	  if(sum == desiredTotal) {
		return maxChoosableInteger % 2 > 0;
	  } else {
        return canWin(maxChoosableInteger, 0, desiredTotal, new Boolean[1 << maxChoosableInteger]);   
	  }
    }

	private static boolean canWin(int n, int state, int remain, Boolean dp[]) {
	  if (dp[state] != null) {
		return dp[state];	
	  }
	  for (int i = n; i >= 1; i--) {
		int pick = 1 << (i - 1); // pick i, set ith bit to 1; 
	    if ((pick & state) != 0) {
		  continue; //if num is picked skip it
	    }
	    if (remain <= i || !canWin(n, state | pick, remain - i, dp)) {
	  	  dp[state] = true;
	      return true;	
	    }
	  }
	  dp[state] = false;
      return false;
	}

	public static void main(String[] args) {     
	  Scanner input = new Scanner(System.in);
	  System.out.print("Please enter maximum choosable integer: ");
	  int maxChoosableInteger = input.nextInt();  
	  System.out.println();
	  System.out.print("Please enter the desired total: ");
	  int desiredTotal = input.nextInt();  
		  
	  boolean samePattern = canIWin(maxChoosableInteger, desiredTotal);
	  System.out.println();
	  if(samePattern) {
		System.out.println("Yes the first player to move can force a win, assuming both players play optimally.");  
	  }
      else {
		System.out.println("No the first player to move cannot force a win, assuming both players play optimally.");  
	  }
	}
  }
