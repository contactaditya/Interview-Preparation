import java.util.Arrays;
import java.util.Scanner;

public class AllPossiblePathsInABoard {
	
  public static int numberOfPaths(int rows, int columns) {      
    // Create a 2D table to store results of subproblems	  
    int count[][] = new int[rows][columns];
  
    // Count of paths to reach any cell in first column is 1  
    for (int i = 0; i < rows; i++) {
      count[i][0] = 1;  
    }
    
    // Count of paths to reach any cell in first row is 1      
    for (int j = 0; j < columns; j++) {
      count[0][j] = 1;  
    }  
  
    // Calculating the total possible paths in which a player can complete the game
    for (int i = 1; i < rows; i++) {
     for (int j = 1; j < columns; j++) {
       count[i][j] = count[i-1][j] + count[i][j-1] + count[i-1][j-1];    
     }          
    } 

    return count[rows-1][columns-1];
  }	

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter number of rows in the board: ");
    int rows = input.nextInt();   
	    
    System.out.print("\n");
    System.out.print("Enter number of columns in the board: ");
    int columns = input.nextInt();   
		  	
    int path = numberOfPaths(rows, columns);
	    
    System.out.print("\n");	    
    System.out.println("The total number of ways a player can complete the game is: " + path);
  }
}
