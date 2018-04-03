import java.util.*;
import java.io.*;

  public class QueueReconstructionByHeight {
	  
	public static int[][] reconstructQueue(int[][] people) {
	  // Pick up the tallest guy first	
	  Arrays.sort(people,new Comparator<int[]>() {
	    public int compare(int[] p1, int[] p2) {
	      if (p2[0] == p1[0]) {
	    	return p1[1] - p2[1];
	      }
          return p2[0] - p1[0];
	    }
	  });	
		
	  List<int[]> list = new ArrayList<int[]>();
	  for(int[] current : people) {
        list.add(current[1], current);       
      }
      return list.toArray(new int[people.length][]);
    }

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Please enter the number of rows in the queue: ");
	  int x = input.nextInt();  
	  System.out.println();
	  int[][] array = new int[x][2];
	  System.out.println("Please enter the actual values in the queue: ");
	  for(int i=0; i < x; i++) {
        for(int j=0; j < 2; j++){
          array[i][j] = input.nextInt();
        }
      }
	  
	  int[][] result = new int[x][2];
	  result = reconstructQueue(array);
	  System.out.println();
	  System.out.print("The reconstructed queue is: [");
	  for(int i=0; i < x; i++) {
	    System.out.print("[");	
	    for(int j=0; j < 2; j++) {
	      System.out.print(result[i][j] + ",");
	    }
	    System.out.print("]");	 
	    System.out.print("," + " ");
	  }	 
	  System.out.print("]");	 
	}
  }
