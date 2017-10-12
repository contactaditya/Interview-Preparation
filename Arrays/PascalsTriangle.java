import java.util.*;
import java.io.*;

  public class PascalsTriangle {
	 
	public static List<List<Integer>> generate(int numberOfRows) {
	   List<List<Integer>> allrows = new ArrayList<List<Integer>>();
	   ArrayList<Integer> row = new ArrayList<Integer>();
	   for(int i=0;i<numberOfRows;i++) {
		 row.add(0, 1);
		 for(int j=1;j<row.size()-1;j++) {
		   row.set(j, row.get(j)+row.get(j+1));
		 }
		 allrows.add(new ArrayList<Integer>(row));
	   }
	   return allrows;     
	}	  

	public static void main(String[] args) {
	   Scanner input = new Scanner(System.in);
	   System.out.print("Enter the number of rows of Pascal's Triangle: ");
	   int numberOfRows = input.nextInt();   	
	   List<List<Integer>> result = new ArrayList<List<Integer>>();
	   result = generate(numberOfRows);
	   System.out.println();
	   System.out.println("The Pascal Triangle for " + numberOfRows + " is as follows: " + result);
	}
  }
