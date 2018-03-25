import java.util.*;
import java.io.*;

public class TripleStep {
	
   public static int countWays(int steps) {
     int[] memo = new int[steps + 1];
     Arrays.fill(memo, -1);
     return countWays(steps, memo);
   }
	
   public static int countWays(int steps, int[] memo) {
     if(steps < 0) {
       return 0;   
     } else if (steps == 0) {
       return 1; 
     } else if (memo[steps] > -1) {
       return memo[steps]; 
     } else {
       memo[steps] = countWays(steps - 1, memo) + countWays(steps - 2, memo) + countWays(steps - 3, memo);  
       return memo[steps];  
     }
   }

   public static void main(String[] args) { 
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the number of steps in the staircases: ");
     int steps = input.nextInt();
     int ways = countWays(steps);
     System.out.println();
     System.out.print("The number of ways the child can run up the stairs are: " + ways);
   }
}
