import java.util.*;

 public class ZeroMatrix { 	
	 
   public static void setZeroes(int[][] array) {
      boolean[] row = new boolean[array.length]; 
      boolean[] column = new boolean[array[0].length];  
	  
      for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[0].length; j++) { 	
          if(array[i][j] == 0) {
            row[i] = true;
            column[j] = true;
          }
	}
      }
	  
      for (int i = 0; i < row.length; i++) {
	if(row[i]) {  
	  nullifyRow(array, i);	  
	}
      }
	  
      for (int j = 0; j < array[0].length; j++) { 
	if(column[j]) {  
	  nullifyColumn(array, j);	
	}
      }
   }
	  
   public static void nullifyRow(int array[][], int row) {
      for (int j = 0; j < array[0].length; j++) {   
         array[row][j] = 0;
      }
   }
	  
   public static void nullifyColumn(int array[][], int column) {
      for (int i = 0; i < array.length; i++) {   
	 array[i][column] = 0;
      }
   }
	
   private static void printMatrix(int[][] array) {
      System.out.println();
      System.out.println("The matrix after entire row and column are set to 0 is: "); 
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
	  
      setZeroes(array); 
      printMatrix(array);
   }
 } 
