import java.util.*;

 public class RotateMatrix {
	public static boolean rotate(int[][] array) {
	  if(array.length == 0 || array.length != array[0].length) {
		 return false;
	  }
	  int n = array.length;	
	  for(int layer = 0; layer < n/2; layer++) {
		int first = layer;
		int last = n - 1 - layer;
		for(int i = first; i < last; i++) {
		  int offset = i - first; 
		   
		  int top = array[first][i];	 
		  // left -> top
		  array[first][i] = array[last - offset][first];
		  // bottom -> left
		  array[last - offset] [first] = array[last][last - offset];
		  // right -> bottom
		  array[last][last - offset] = array[i][last];
		  // top -> right
		  array[i][last] = top;
			 
	    }
	  }
	  return true;
	}
	
	private static void printMatrix(int[][] array) {
	  System.out.println();
	  System.out.println("The matrix after rotation is: "); 
	  System.out.println();
	  for (int i = 0; i < array.length; i++) {
		for (int j = 0; j < array[i].length; j++) {
		  System.out.print(array[i][j] + " ");
		}
		System.out.println();
	  }	
	}
	
	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Please enter the number of rows in the matrix: ");
	  int x = input.nextInt();  
	  System.out.println();
	  System.out.print("Please enter the number of columns in the matrix: ");
	  int y = input.nextInt();  
	  int[][] array = new int[x][y];
	  System.out.println();
	  System.out.println("Please enter the actual values in the matrix: ");
	  for(int i=0; i < x; i++) {
        for(int j=0; j < y; j++){
          array[i][j] = input.nextInt();
        }
      }
	  
	  boolean rotate = rotate(array); 
	  if(rotate) {
	    printMatrix(array);
	  }
	  else {
		System.out.println();
		System.out.println("The matrix cannot be rotated.");  
	  }
   }
 }
