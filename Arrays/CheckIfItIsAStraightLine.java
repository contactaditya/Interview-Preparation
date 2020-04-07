import java.util.*;
import java.io.*;

  public class CheckIfItIsAStraightLine {
	
    public static boolean checkStraightLine(int[][] coordinates) {
      double slope = findSlope(coordinates[0], coordinates[1]);
        
      for(int i = 1; i < coordinates.length - 1; i++) {
        double slope1 = findSlope(coordinates[i], coordinates[i + 1]);
        if(slope1 != slope) {
          return false;
        }
      }
		
      return true;  
    }
	
    private static double findSlope(int[] point1, int[] point2) {
      if ((point1[0] - point2[0]) == 0) {
        return 0;
      }
      
      return (double)(point2[1] - point1[1])/(point2[0] - point1[0]);
    }
	
    public static void main(String[] args) { 	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of coordinates in the XY plane: ");
      int number = input.nextInt();
      System.out.println();
      int[][] coordinates = new int[number][2];
      System.out.println("Please enter the actual values of the coordinates: ");
      for(int i=0; i < number; i++) {
        for(int j=0; j < 2; j++) {
	 coordinates[i][j] = input.nextInt();
	}
      }
	   
      System.out.println();	
      if(checkStraightLine(coordinates)) {
	System.out.println("These points make a straight line in the XY plane.");  
      } 
      else {
	System.out.println("These points do not make a straight line in the XY plane.");  
      } 
      input.close();
    }  
  }
