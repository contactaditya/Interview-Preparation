import java.util.*;
import java.io.*;

  public class NumberOfBoomerangs {
	  
	public static int numberOfBoomerangs(int[][] points) {
	  int count = 0;	
	  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	  for (int[] point1 : points) {
		for (int[] point2 : points) {
	      int distance = getDistance(point1, point2);  
	      
	      Integer value = map.get(distance);
	      if (value != null) {
            count += 2 * value;
            map.put(distance, value + 1);
          } else {
            map.put(distance, 1);
          }    
	    }
        map.clear();
	  }
		
	  return count;      
	}	  
	
	public static int getDistance(int a[], int b[]) {
	  int dx = a[0] - b[0];
	  int dy = a[1] - b[1];	
		
	  return dx*dx + dy*dy;
	}

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number of points in the plane: ");
	  int x = input.nextInt();  
	  int[][] array = new int[x][2];
	  System.out.println();
	  System.out.println("Please enter the actual points in the plane: ");
	  for(int i=0; i < x; i++) {
        for(int j=0; j < 2; j++) {
          array[i][j] = input.nextInt();
        }
      }
	  int numberOfBoomerangs = numberOfBoomerangs(array);	  
      System.out.println();
      System.out.println("The number of boomerangs in the n points in the plane are: " + numberOfBoomerangs);
	}
  }
