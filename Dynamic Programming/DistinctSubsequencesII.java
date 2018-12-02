import java.io.*;
import java.util.*;

  public class DistinctSubsequencesII {
	  
    public static int distinctSubseqII(String string) {	
      int end[] = new int[26]; // Represents the count of subsequence ends with a particular character
      int result = 0, added = 0, mod = (int)1e9 + 7;
      for (char c : string.toCharArray()) {
        added = (result + 1 - end[c - 'a']) % mod;
        result = (result + added) % mod;
        end[c - 'a'] = (end[c - 'a'] + added) % mod;
      }
		
      return (result + mod) % mod;      
    }

    public static int distinctSubsequenceII(String string) {	
      int MOD = 1_000_000_007;
      int N = string.length();
      int[] dp = new int[N + 1];
      dp[0] = 1; // Empty substring has only one subsequence 

      int[] last = new int[26];
      Arrays.fill(last, -1);
	  
      for (int i = 0; i < N; i++) {
        int x = string.charAt(i) - 'a';
        dp[i+1] = dp[i] * 2 % MOD;
        // If current character has appeared before, then remove all subsequences ending with previous occurrence. 
        if (last[x] >= 0) {
          dp[i+1] -= dp[last[x]];
        }
        dp[i+1] %= MOD;
        last[x] = i; // Mark occurrence of current character 
      }

      dp[N]--;
      if (dp[N] < 0) {
    	dp[N] += MOD; 
      }
      
      return dp[N];
    }
	
    public static void main(String[] args) { 	  
      String string = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      string = input.nextLine();  
      int numDistinct = distinctSubsequenceII(string);
      System.out.println();
      System.out.println("The number of distinct non-empty subsequences of " + string + " are: " + numDistinct); 
      input.close();
    }
  }
