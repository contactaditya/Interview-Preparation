import java.util.*;
import java.io.*;

  public class MinimumPathSumInATriangle {
	  
	public static int minimumTotal(List<List<Integer>> triangle) {
	  int minimumPathSum[] = new int[triangle.size() + 1];	
	  if(triangle.size() == 0) {
		return 0;
	  }
		
	  for (int i=triangle.size() - 1; i>=0; i--) {
		List<Integer> nextRow = triangle.get(i);  
	    for (int j=0; j<triangle.get(i).size(); j++) {
		  minimumPathSum[j] = Math.min(minimumPathSum[j], minimumPathSum[j+1]) + nextRow.get(j);
	    }
	  }
		
	  return minimumPathSum[0];      
	}	  

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of rows in the triangle: ");
	  int numberOfRowsInTheTriangle = input.nextInt();   
	   
	  List<List<Integer>> triangle = new ArrayList<List<Integer>>();
	  for (int i = 0; i < numberOfRowsInTheTriangle; i++) {
		List<Integer> rows = new ArrayList<Integer>();  
		System.out.println(); 
		System.out.print("Please enter the number of elements in the row: ");
		int numberOfElements = input.nextInt();   
	    System.out.println(); 
	    System.out.print("Please enter the actual values of the rows: ");	  
	    for (int j = 0; j < numberOfElements; j++) {
		  rows.add(input.nextInt());
	    }
	    triangle.add(rows);
	  }
	 
	  int minimumPathSum = minimumTotal(triangle); 
	  System.out.println();
	  System.out.println("The minimum path sum from top to bottom in a triangle is: " + minimumPathSum);
	
	}
  }
