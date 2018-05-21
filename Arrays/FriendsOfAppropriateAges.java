import java.util.*;
import java.io.*;

  public class FriendsOfAppropriateAges {
	  
	public static int numFriendRequests(int[] ages) {
	  int totalFriendRequests = 0;	
	  int[] count = new int[121];
	  for(int x : ages) {
		count[x]++;
	  }
	  for (int ageA = 0; ageA <= 120; ageA++) {
	    int countA = count[ageA];
	    for (int ageB = 0; ageB <= 120; ageB++) {
          int countB = count[ageB];
          if (ageA * 0.5 + 7 >= ageB) {
        	continue;
          }
          if (ageA < ageB) {
        	continue;
          }
          if (ageA < 100 && ageB > 100) {
        	continue;
          }
          totalFriendRequests += countA * countB;
          if (ageA == ageB) {
        	totalFriendRequests -= countA;
          }
        }
	  }
		
	  return totalFriendRequests;      
	}	  

	public static void main(String[] args) { 
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of people: ");
	  int numbers = input.nextInt();   
	  int ages[] = new int[numbers];
						    
	  System.out.println();
	  System.out.print("Please enter the actual age of the people: ");
      for (int i = 0; i < numbers; i++) {
		ages[i] = input.nextInt(); 
	  }
	  int totalFriendRequests = numFriendRequests(ages);
	  System.out.println();
	  System.out.print("The total number of friend requests that have been made are: " + totalFriendRequests);
	}
  }
