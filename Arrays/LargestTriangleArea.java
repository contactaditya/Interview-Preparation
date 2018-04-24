import java.util.*;
import java.io.*;

  public class LargestTriangleArea {
	  
    public static double largestTriangleArea(int[][] points) { 
      int N = points.length;
      double ans = 0;
      for (int i = 0; i < N; i++) {
        for (int j = i+1; j < N; j++) {
          for (int k = j+1; k < N; k++) {
            ans = Math.max(ans, area(points[i], points[j], points[k]));
          }
        }
      }
    
      return ans;      
    }  
	
    public static double area(int[] P, int[] Q, int[] R) {
      return 0.5 * Math.abs(P[0]*Q[1] + Q[0]*R[1] + R[0]*P[1] - P[1]*Q[0] - Q[1]*R[0] - R[1]*P[0]);
    }

    public static void main(String[] args) { 	 
      Scanner input = new Scanner(System.in);
      System.out.print("Please enter the number of points: ");
      int x = input.nextInt();  
      int[][] points = new int[x][2];
      System.out.println();
      System.out.println("Please enter the actual values of the points: ");
      for(int i=0; i < x; i++) {
        for(int j=0; j < 2; j++){
          points[i][j] = input.nextInt();
        }
      }
	  
      double largestTriangleArea = largestTriangleArea(points); 
      System.out.println();
      System.out.println("The area of the largest triangle that can be formed by any 3 of the points is: " + largestTriangleArea);
    }
  }
