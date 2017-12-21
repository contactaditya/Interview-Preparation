import java.util.*;
import java.io.*;

 public class ValidSudoku {
	 
    public static boolean isValidSudoku(char[][] board) {    
      Set seen = new HashSet();
      for (int i=0; i<9; i++) {
        for (int j=0; j<9; j++) {
          char number = board[i][j];
          if (number != '.') {
            if (!seen.add(number + " in row " + i) || !seen.add(number + " in column " + j) || !seen.add(number + " in block " + i/3 + "-" + j/3)) {
              return false;
            }
          }
        }
      }
      return true;      
    }	 

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of rows in the board: ");
      int rows = input.nextInt();  
      System.out.println();	
      System.out.print("Enter number of columns in the board: ");
      int columns = input.nextInt();  
	 
      char board[][] = new char[rows][columns];
				
      System.out.println();	
      System.out.println("Please enter the elements in the board array: ");
      for (int i = 0; i < rows; i++) {
	for (int j = 0; j < columns; j++) {
	  board[i][j] = input.next().charAt(0);
	}
      }
	  
      boolean isValidSudoku = isValidSudoku(board);
      System.out.println();
      if(isValidSudoku) {
	System.out.println("The sudoku is valid.");  
      }
      else {
	System.out.println("The sudoku is not valid.");  
      }
    }
 }
