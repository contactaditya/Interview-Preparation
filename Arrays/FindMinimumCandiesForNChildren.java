import java.util.*;
import java.io.*;

  public class FindMinimumCandiesForNChildren {
	  
    public static int candy(ArrayList<Integer> ratings) { 	 
      int[] candies = new int[ratings.size()];
      Arrays.fill(candies, 1);
      for (int i = 1; i < ratings.size(); i++) {
        if(ratings.get(i) > ratings.get(i - 1)) {
	  candies[i] = candies[i - 1] + 1;	
	}
      }
      int sum = candies[ratings.size() - 1];
      for (int i = ratings.size() - 2; i >= 0; i--) {
        if(ratings.get(i) > ratings.get(i + 1)) {
	  candies[i] = Math.max(candies[i], candies[i + 1] + 1);
	}
	sum += candies[i];
      }
				
      return sum;
    }  

    public static void main(String[] args) { 	 
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of children: ");
      int number = input.nextInt();  
      ArrayList<Integer> ratings = new ArrayList<Integer>();	
			
      System.out.println();	
      System.out.print("Please enter the actual ratings of those children: ");
      for (int i = 0; i < number; i++) {
    	ratings.add(input.nextInt());
      }
		  
      int minimumNumberOfCandies = candy(ratings); 
      System.out.println();	
      System.out.print("The minimum candies that must be given to children in the line is: " + minimumNumberOfCandies);
      input.close();
    }
  }
