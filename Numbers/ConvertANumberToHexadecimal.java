import java.util.*;
import java.io.*;

  public class ConvertANumberToHexadecimal {
	  
    static char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};	  
	  
    public static String toHex(int number) { 
      if(number == 0) {
	return "0";
      }
      String result = "";
      while(number != 0){
        result = map[(number & 15)] + result; 
        number = (number >>> 4);
      }
      return result;    
    }	 
	
    public static void main(String[] args) {       
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();  

      String result = toHex(number);
      System.out.println();	
      System.out.print("The number " + number + " in hexadecimal form is: " + result);

    }
  }
