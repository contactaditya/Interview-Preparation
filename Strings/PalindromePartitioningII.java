import java.util.*;

  public class PalindromePartitioningII {  
	  
	public static int minCut(String string) {
	  char[] c = string.toCharArray();
	  int n = c.length;
	  int[] cut = new int[n]; // Minimum number of cuts needed for palindrome partitioning of substring
	  boolean[][] palindrome = new boolean[n][n]; // pal[i][j] = true if substring string[i..j] is palindrome, else false
	  
	  for(int i = 0; i < n; i++) {
	    int min = i;
	    for(int j = 0; j <= i; j++) {	  
	      if(c[j] == c[i] && (j + 1 > i - 1 || palindrome[j + 1][i - 1])) {
	    	palindrome[j][i] = true;  
            min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
          }
        }
	    cut[i] = min;
	  }
	  
	  return cut[n - 1];
    }

	public static void main(String[] args) { 
	  String string = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string = input.next();    
	  
	  System.out.println();   
	  int result = minCut(string); 
	  System.out.println();
	  System.out.println("The minimum cuts needed for a palindrome partitioning of the " + string + " are: " + result);
	}
  }
