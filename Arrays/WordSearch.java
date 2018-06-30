import java.util.*;
import java.io.*;

 public class WordSearch {
	 
   public static boolean exist(char[][] board, String word) {
     int m = board.length;
     int n = board[0].length;
	   
     boolean result = false;
     for(int i=0; i<m; i++) {
       for(int j=0; j<n; j++) {
	 if(dfs(board,word,i,j,0)) {
	   result = true;
	 }
       }
     }  
     return result;   
   }
	       
   public static boolean dfs(char[][] board, String word, int i, int j, int k) {
     int m = board.length;
     int n = board[0].length;
	   
     if(i<0 || j<0 || i>=m || j>=n) {
	return false;
     }
	   
     if(board[i][j] == word.charAt(k)) {
        char temp = board[i][j];
	board[i][j]='#';
	if(k==word.length()-1) {
	  return true;
	} else if(dfs(board,word,i-1,j,k+1) || dfs(board,word,i+1,j,k+1) || dfs(board,word,i,j-1,k+1) || dfs(board,word,i,j+1,k+1)) {
	  return true;
	}
       board[i][j]=temp;
     } 
     return false;
   }   	  

   public static void main(String[] args) {  
     Scanner input = new Scanner(System.in);
     System.out.print("Enter number of rows in the board: ");
     int rows = input.nextInt();  
     System.out.println();	
     System.out.print("Enter number of columns in the board: ");
     int columns = input.nextInt();  
	 
     char boggle[][] = new char[rows][columns];
				
     System.out.println();	
     System.out.println("Please enter the elements in the boggle array: ");
     for (int i = 0; i < rows; i++) {
       for (int j = 0; j < columns; j++) {
	 boggle[i][j] = input.next().charAt(0);
       }
     }
	  
     String word = new String();	
     System.out.println();	
     System.out.print("Enter a word which you want to check whether it exists in the grid: ");
     word = input.next();  
	  
     boolean result = exist(boggle, word);
     System.out.println();
     if(result) {
       System.out.println("The word " + word + " exists in the grid.");  
     }
     else {
       System.out.println("The word " + word + " does not exist in the grid.");  
     }
   }
 }
