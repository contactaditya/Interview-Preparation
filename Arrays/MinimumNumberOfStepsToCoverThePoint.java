import java.util.*;
import java.io.*;

 public class MinimumNumberOfStepsToCoverThePoint {
	 
	public static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
	   int length = 0;
	   int startX = X.get(0);
	   int startY = Y.get(0);
	   
	   if (X.size() <= 1) {
		 return 0;
	   }
	    
	   for (int i = 1; i < X.size(); i++) {
	     int x = Math.abs(startX - X.get(i));
	     int y = Math.abs(startY - Y.get(i));
	     startX = X.get(i);
	     startY = Y.get(i);
	        
	     length += Math.max(x, y);
	   }
				
	   return length;	 
	} 
	
	public static int coverPoints1(ArrayList<Integer> X, ArrayList<Integer> Y) {
	   int length = 0;
	   
	   for (int i = 1; i < X.size(); i++) {
		 length += Math.max(Math.abs(X.get(i) - X.get(i-1)), Math.abs(Y.get(i) - Y.get(i-1))); 
	   }
					
	   return length;	 
	} 

	public static void main(String[] args) {
	   Scanner input = new Scanner(System.in);
	   System.out.print("Enter the number of coordinates in the sequence : ");
	   int number = input.nextInt();
	   System.out.println();
	   System.out.print("Please enter the X coordinates of the sequence of the points in the infinte grid: ");
	   ArrayList<Integer> X = new ArrayList<Integer>();
	   for (int i = 0; i < number; i++) {
	     X.add(input.nextInt());
	   }
	   System.out.println();
	   System.out.print("Please enter the Y coordinates of the sequence of the points in the infinte grid: ");
	   ArrayList<Integer> Y = new ArrayList<Integer>();
	   for (int i = 0; i < number; i++) {
	     Y.add(input.nextInt());
	   }
	   
	   System.out.println();
	   System.out.println("The minimum number of steps in which you can achieve it are: " + coverPoints(X,Y));
	  
	   input.close();
	}
  }
