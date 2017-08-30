import java.util.*;
import java.io.*;

  public class FindAnArrayOfAntiDiagonalsOfASquareMatrix {
	  
    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
		
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       if (a == null || a.size() == 0) {
    	  return result;
       }
       
       int offset = 0;
       
       for(int i = 0; i < 2 * a.size() - 1; i++) {
    	 if(i < a.size()) {
    	   offset = 0;
    	 }
    	 else {
    	   offset = i - a.size() + 1;	 
    	 }  
    	 ArrayList<Integer> row = new ArrayList<Integer>();
    	 for (int j = offset; j <= i - offset; j++) {
		   row.add(a.get(j).get(i - j));
 	     }
    	 result.add(row);
       }
    	
       return result;
    }  

	public static void main(String[] args) {
      ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();	
	  Scanner input = new Scanner(System.in);
	  System.out.print("Please enter the number of rows in the square matrix: ");
	  int x = input.nextInt();  
	  System.out.println();
	  System.out.print("Please enter the number of columns in the square matrix: ");
      int y = input.nextInt();  
	  System.out.println();
	  System.out.println("Please enter the actual values in the matrix: ");
	  for(int i=0; i < x; i++) {
	   ArrayList<Integer> temp = new ArrayList<Integer>();
       A.add(temp);  
	   for(int j=0; j < y; j++) {  
		 temp.add(input.nextInt());      
	   } 
	  }
	  
	  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();	
	  
	  result = diagonal(A);
	  
	  System.out.println();	
	  System.out.print("The array of the anti diagonals of the square matrix is: ");
	  System.out.println();	
	  for(ArrayList<Integer> t : result) {
        System.out.println(t);
      }
	   		
	}
  }
