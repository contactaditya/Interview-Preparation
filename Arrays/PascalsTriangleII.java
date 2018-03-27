import java.util.*;
import java.io.*;

  public class PascalsTriangleII {
	  
	public static List<Integer> getRow(int rowIndex) {
	  List<Integer> result = new ArrayList<Integer>();    
	  result.add(1);
	  for (int i = 1; i <= rowIndex; i++) {
	    // last index is reserved for 1, which we insert in the first loop  
	    for (int j = i - 1; j >= 1; j--) {
		  int temp = result.get(j - 1) + result.get(j);
		  result.set(j, temp);
		}
	    result.add(1);
	  }
	  
	  return result;
	}  

	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the index of the row of the Pascal's Triangle: ");
	  int numberOfRows = input.nextInt();   	
	  List<Integer> result = new ArrayList<Integer>();
	  result = getRow(numberOfRows);
	  System.out.println();
	  System.out.println("The kth row of the Pascal's triangle is: " + result);
	}
  }
