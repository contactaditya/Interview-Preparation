import java.util.*;
import java.io.*;

  public class DistributeCandies {
	  
	public static int distributeCandies(int[] candies) {
	  HashSet<Integer> set = new HashSet<Integer>();
	  for (int candy : candies) {
	    set.add(candy);
	  }
	  return Math.min(set.size(), candies.length/2);	      
	}	  

	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of elements in the array: ");
      int lengthOfArray = input.nextInt();
      int[] candies = new int[lengthOfArray];    
      System.out.println();	
      System.out.print("Please enter the elements in the array: ");
      for(int i=0;i<lengthOfArray;i++) {  
    	candies[i] = input.nextInt();
      }   
  
      int distributeCandies = distributeCandies(candies);
      System.out.println();	
      System.out.println("The maximum number of kinds of candies the sister could gain are: " + distributeCandies);	
	}
  }
