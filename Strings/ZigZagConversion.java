import java.util.*;
import java.io.*;

  public class ZigZagConversion {
	  
	public static String convert(String string, int numberOfRows) {
	  if (numberOfRows == 1) {
		return string;
	  }
	  List<StringBuilder> rows = new ArrayList<StringBuilder>();
	  // First Row
	  for (int i = 0; i < Math.min(numberOfRows, string.length()); i++) {
        rows.add(new StringBuilder());
	  }
	  int currentRow = 0;
      boolean goingDown = false;
      // Rows between
      for (char c : string.toCharArray()) {
        rows.get(currentRow).append(c);
        if (currentRow == 0 || currentRow == numberOfRows - 1) {
          goingDown =! goingDown;
        }
        currentRow += goingDown ? 1 : -1;
      }
      
      // Last Row
      StringBuilder result = new StringBuilder();
      for (StringBuilder row : rows) {
    	result.append(row);
      }
      return result.toString();
	}	  

	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  String string = new String();	
	  System.out.print("Enter the string: ");
	  string = input.nextLine();  
	  System.out.println();
	  System.out.print("Enter the number of rows: ");
	  int numberOfRows = input.nextInt();  
	  String result = convert(string, numberOfRows);
	  System.out.println();
	  System.out.print("The string after Zig Zag Conversion is: " + result);
	}
  } 
