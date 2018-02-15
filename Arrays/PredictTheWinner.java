import java.util.*;
import java.io.*;

  public class PredictTheWinner {
	  
     public static boolean PredictTheWin(int[] array) {
        int dp[] = new int[array.length];	
	for(int i = array.length; i >= 0; i--) {
	  for (int j = i + 1; j < array.length; j++) {
	     dp[j] = Math.max(array[i] - dp[j], array[j] - dp[j - 1]);	
	  }
	}
		
	return dp[array.length - 1] >= 0;      
     }	  

     public static void main(String[] args) {   
        Scanner input = new Scanner(System.in);
	System.out.print("Enter number of elements in the array: ");
	int numbers = input.nextInt();   
	int array[] = new int[numbers];
		    
	System.out.println();
	System.out.print("Please enter the actual values in the array: ");
	for (int i = 0; i < numbers; i++) {
	  array[i] = input.nextInt(); 
	}

	boolean PredictTheWinner = PredictTheWin(array);
	System.out.println();
	if(PredictTheWinner) {
	  System.out.println("Yes player 1 can win the game.");  
	}
	else {
	  System.out.println("No player 1 will never be the winner.");    
        }
     }
  }
