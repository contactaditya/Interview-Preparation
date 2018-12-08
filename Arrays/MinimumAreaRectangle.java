import java.util.*;
import java.io.*;

  public class MinimumAreaRectangle {
	  
	public static int minAreaRectangle(int[][] points) {
      Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
      for (int[] p : points) {
        if (!map.containsKey(p[0])) {
          map.put(p[0], new HashSet<Integer>());
        }
        map.get(p[0]).add(p[1]);
      }
      int min = Integer.MAX_VALUE;
      for (int[] p1 : points) {
        for (int[] p2 : points) {
          if (p1[0] == p2[0] || p1[1] == p2[1]) {
            continue; // if have the same x or y
          }
          if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) { 
            min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1])); // find other two points
          }
        }
      }
		
	  return min == Integer.MAX_VALUE ? 0 : min;      
	}
	
	public static int minAreaRectangle1(int[][] points) {
	  Arrays.sort(points, new Comparator<int[]>() {
	    public int compare(int[] a, int[] b) {
	      return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
	    }
	  });
	  
	  Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
      for (int[] p : points) {
        if (!map.containsKey(p[1])) {
          map.put(p[1], new HashSet<Integer>());
        }
          
        map.get(p[1]).add(p[0]);
      }
      int min = Integer.MAX_VALUE;
      for (int i=0; i < points.length - 1; i++) {
        int[] p1 = points[i], p2 = points[i+1];
        // The two points are not on the same x axis.
        if (p1[0] != p2[0]) {
          continue;
        }
        // Get height
        int height = p2[1] - p1[1];
        
        // Use y1 of p1 to get the other x1 that has the same y1.
        for (int x : map.get(p1[1])) {
          if (x == p1[0]) {
            continue;
          }
          // Get width.
          // If there is an x2 also has the same y2 as p2.
          if (map.get(p2[1]).contains(x)) {
            int width = Math.abs(x - p1[0]);
            min = Math.min(min, height * width);
          }
        }
      }
	  return min == Integer.MAX_VALUE ? 0 : min;      
    }	

	public static void main(String[] args) { 	 
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number of points in the xy-plane: ");
	  int x = input.nextInt();  
	  int[][] points = new int[x][2];
	  System.out.println();
	  System.out.println("Please enter the actual points in the plane: ");
	  for(int i = 0; i < x; i++) {
	    for(int j = 0; j < 2; j++) {
	      points[i][j] = input.nextInt();
	    }
	  }
	  
	  int minAreaRectangle = minAreaRectangle(points); 
	  System.out.println();
	  System.out.print("The minimum area of a rectangle formed from these points, with sides parallel to the x and y axes is: " + minAreaRectangle);
	  input.close();
	}
  }
