import java.util.*;
import java.io.*;

  public class PositionsOfLargeGroups {

    public static List<List<Integer>> largeGroupPositions(String string) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      int i = 0, N = string.length(); // i is the start of each group
      for(int j = 0; j < N; j++) {
        if (j == N-1 || string.charAt(j) != string.charAt(j+1)) {  
	  // Here, [i, j] represents a group.	
	  if(j - i + 1 >= 3) {
	    result.add(Arrays.asList(new Integer[]{i, j}));  
	  }
	  i = j + 1;
        }
      }
		
      return result;       
    }
	
    public static void main(String[] args) { 	 
      Scanner input = new Scanner(System.in);
      String string = new String();	  
      System.out.print("Enter the string: ");
      string = input.nextLine(); 	  
      List<List<Integer>> result = new ArrayList<List<Integer>>();
	   
      result = largeGroupPositions(string); 
      System.out.println();
      System.out.println("All the positions of the large group are: ");
      System.out.println('[');
      for(List<Integer> innerList : result) {
	System.out.println(innerList + " ");
      }
      System.out.println(']');
    }
  }
