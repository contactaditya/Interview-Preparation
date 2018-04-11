import java.util.*;
import java.io.*;

  public class ExcelSheetColumnTitle {
	
    public static String convertToTitle(int number) {
      StringBuilder result = new StringBuilder();
      while(number>0) {
	number--;
	result.insert(0, (char)('A' + number % 26));
	number /= 26;
      }

      return result.toString();     
    }	

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();  
      String result = convertToTitle(number);
      System.out.println();	
      System.out.println("The corresponding column title as it appears in an Excel sheet is: " + result);	
    }
  }
