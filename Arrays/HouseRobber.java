import java.util.*;
import java.io.*;

  public class HouseRobber {
	  
     public static int rob(int[] array) {
        int rob = 0; // max money that you can get if you rob the current house
        int notrob = 0; // max money that you can get if you do not rob the current house
        for(int i=0; i < array.length; i++) {
	  int currob = notrob + array[i]; // If you rob current house, previous house must not be robbed
	  notrob = Math.max(rob, notrob); // If you do not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
	  rob = currob;
        }
	return Math.max(rob, notrob);
     }  

     public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.print("Enter number of elements in the array: ");
	int number = input.nextInt();  
	int array[] = new int[number];
		
	System.out.println();	
	System.out.print("Please enter the elements of the array: ");
	for (int i = 0; i < array.length; i++) {
	  array[i] = input.nextInt();
	}
		  
	int maxAmountOfMoneyThatYouCanRob = rob(array);
	System.out.println();	
	System.out.print("The maximum amount of money you can rob tonight without alerting the police is: " + maxAmountOfMoneyThatYouCanRob);
     }
  }
