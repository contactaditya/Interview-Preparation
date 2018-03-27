import java.util.*;
import java.io.*;

  public class MaximumLengthOfPairChain {
	  
	public static int findLongestChain(int[][] pairs) {  
	  if (pairs == null || pairs.length == 0) {
		return 0;
	  }
	  Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
	  int current = Integer.MIN_VALUE;
	  int answer = 0;
	  for (int[] pair: pairs) {
		if(current < pair[0]) {
		  current = pair[1];
		  answer++;
		}
	  }
	  return answer;
	}	  

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Please enter the number of rows: ");
	  int x = input.nextInt();  
	  int[][] pairs = new int[x][2];
	  System.out.println();
	  System.out.println("Please enter the actual values: ");
	  for(int i=0; i < x; i++) {
        for(int j=0; j < 2; j++) {
          pairs[i][j] = input.nextInt();
        }
      }
	  
	  int length = findLongestChain(pairs); 
	  System.out.println();
	  System.out.println("The length of the longest chain which can be formed is: " + length);

	}
  }
