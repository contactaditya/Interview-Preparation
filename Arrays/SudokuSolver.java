import java.util.*;
import java.io.*;

  public class SudokuSolver {
	  
	public static void solveSudoku(char[][] board) {
      if(board == null || board.length == 0) {
	    return;
      }	        
      solve(board);    
	  System.out.println();
	  System.out.println("The solution to the sudoku puzzle is: ");
	  for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 9; j++) {
		  System.out.print(board[i][j] + " ");
	    }
	    System.out.println();
	  }	
	}

	private static boolean solve(char[][] board) {
      for(int i = 0; i < board.length; i++) {
        for(int j = 0; j < board[0].length; j++) {
          if(board[i][j] == '.') { 
            for(char c = '1'; c <= '9'; c++) {
              if(isValid(board, i, j, c)) {
                board[i][j] = c; // Put c in this cell	  
                if(solve(board)) {
                  return true; 
                }
                else {
                  board[i][j] = '.'; 
                } 
              }
        	}
            return false;
          }
        }
	  }
	  return true;
	}

	private static boolean isValid(char[][] board, int row, int column, char c) {
	  for(int i = 0; i < 9; i++) {
        if(board[i][column] != '.' && board[i][column] == c) {
          return false; // check row
        }
        if(board[row][i] != '.' && board[row][i] == c) {
          return false; // check column
        }
        if(board[3 * (row / 3) + i / 3][3 * (column / 3) + i % 3] != '.' && board[3 * (row / 3) + i / 3][3 * (column / 3) + i % 3] == c) {
          return false; // check 3 * 3 block
        }
      }
		
	  return true;
	}

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);	 	 
	  char board[][] = new char[9][9];
      System.out.println("Please enter the elements in the board array: ");
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
	      board[i][j] = input.next().charAt(0);
        }
      }
	  
      solveSudoku(board);
      input.close();
	}
  }
