import java.util.*;
import java.io.*;

  public class MaximizeDistanceToClosestPerson {
	  
	public static int maxDistanceToClosest(int[] seats) {
	  int maxDistanceToClosest = 0;	
	  int N = seats.length;
      int previous = -1, future = 0;

	  for (int i = 0; i < seats.length; i++) {   
	    if (seats[i] == 1) {
          previous = i;
        }
	    else {
          while (future < N && seats[future] == 0 || future < i) {
            future++;
          }
          int left = previous == -1 ? N : i - previous;
          int right = future == N ? N : future - i;
          maxDistanceToClosest = Math.max(maxDistanceToClosest, Math.min(left, right));
        }
	  }
		
	  return maxDistanceToClosest;      
    }	  

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of seats in the row: ");
	  int numbers = input.nextInt();    
	  int seats[] = new int[numbers];
	    
	  System.out.println();
	  System.out.print("Please enter whether a person is sitting in that seat or if the seat is empty using 1 and 0: ");
	  for (int i = 0; i < numbers; i++) {
		seats[i] = input.nextInt();   
	  }
	  
	  int maximumDistanceToTheClosestPerson = maxDistanceToClosest(seats);
	  System.out.println();
	  System.out.print("The maximum distance to closest person is: " + maximumDistanceToTheClosestPerson);
	}
  }
