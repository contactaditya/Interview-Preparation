import java.util.*;
import java.io.*;

  public class RomanToInteger {
	  
    public static int romanToInt(String string) { 
      int array[] = new int[string.length()];
      for(int i = 0; i < string.length(); i++) {	
        switch(string.charAt(i)) {
          case 'M': array[i] = 1000;
                    break;
          case 'D': array[i] = 500;
          	    break;
          case 'C': array[i] = 100;
          	    break;
          case 'L': array[i] = 50;
          	    break;
          case 'X': array[i] = 10;
          	    break;
          case 'V': array[i] = 5;
          	    break;
          case 'I': array[i] = 1;
          	    break;
        }
      }
      int sum=0;
      for(int i = 0; i < array.length-1; i++) {
        if(array[i] < array[i+1]) {
          sum -= array[i];
        }
        else {
          sum += array[i];
        }
      }
      return sum + array[array.length-1];
    }

    public static void main(String[] args) {     
      Scanner input = new Scanner(System.in);
      String string = new String();	
      System.out.print("Enter the string: ");
      string = input.nextLine(); 
      
      int result = romanToInt(string);
      System.out.println();
      System.out.print("The roman numeral " + string + " in integer form is: " + result);
    }
  }
