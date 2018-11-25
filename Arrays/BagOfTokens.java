import java.util.*;
import java.io.*;

  public class BagOfTokens {
	  
	public static int bagOfTokensScore(int[] tokens, int P) { 
	  Arrays.sort(tokens);
      int result = 0, points = 0, i = 0, j = tokens.length - 1;
      while (i <= j) {
        if (P >= tokens[i]) {
          P -= tokens[i++];
          result = Math.max(result, ++points);
        } else if (points > 0) {
          points--;
          P += tokens[j--];
        } else {
          break;
        }
      }
		
      return result;      
	}

	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of tokens: ");
	  int number = input.nextInt();  
	  int tokens[] = new int[number];
	
	  System.out.println();	
	  System.out.print("Please enter the value of the tokens: ");
	  for (int i = 0; i < tokens.length; i++) {
		tokens[i] = input.nextInt();
	  }
	  
	  System.out.println();
	  System.out.print("Enter the number of points: ");
	  int P = input.nextInt();  
	
	  System.out.println();	
	  int largestNumberOfPoints = bagOfTokensScore(tokens, P);
	  System.out.println("The largest number of points we can have after playing any number of tokens are: " + largestNumberOfPoints);  
      input.close(); 
	}
  }
