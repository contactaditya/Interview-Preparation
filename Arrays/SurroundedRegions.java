import java.util.*;
import java.io.*;

  public class SurroundedRegions {
	  
    public static void solve(char[][] board) {
      if(board == null || board.length == 0) {
	return;      
      }
      for(int i = 0; i < board.length; i++) { 
        for(int j = 0; j < board[0].length; j++) {
	  if(i == 0 || i == board.length-1 || j == 0 || j == board[0].length-1) {
            if(board[i][j] == 'O') {
              dfs(i, j, board);
            }
          }	
	}
      }
      for(int i = 0; i < board.length; i++) {
	for(int j = 0; j < board[0].length; j++) {
	  if(board[i][j] == '*') {
	    board[i][j] ='O';
	  }
	  else {
	    board[i][j] = 'X';
	  }
	}
      }
    }	  

    private static void dfs(int i, int j, char[][] board) {
      if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
	return;
      }  
      if(board[i][j] == 'X' || board[i][j] == '*') {
	return;
      }
      board[i][j] = '*';
      if(i+1 < board.length) {
	dfs(i+1, j, board);
      }
      if(i-1 > 0) {
	dfs(i-1, j, board);
      }
      if(j+1 < board[0].length) {
	dfs(i, j+1, board);
      } 
      if(j-1 > 0) {
	dfs(i, j-1, board);
      }
    }

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Please enter the number of rows in the board: ");
      int x = input.nextInt();  
      System.out.println();
      System.out.print("Please enter the number of columns in the board: ");
      int y = input.nextInt();  
      char[][] board = new char[x][y];
      System.out.println();
      System.out.println("Please enter the actual values in the board: ");
      for(int i=0; i < x; i++) {
        for(int j=0; j < y; j++){
          board[i][j] = input.next().charAt(0);
        }
      }
	  
      solve(board); 
      System.out.println();
      System.out.println("The board after flipping all the 'O's into 'X's in the surrounded region is: ");
      for(int i = 0; i < x; i++) {
	for(int j = 0; j < y; j++) {
	  System.out.print(board[i][j] + " ");
	}
	System.out.println();
      }
    }
  } 
