import java.util.*;
import java.io.*;

  public class ShiftingLetters {
	  
    public static String shiftingLetters(String string, int[] shifts) {
      StringBuilder result = new StringBuilder();
      int X = 0;
      // Let X be the number of times the current ith character is shifted
      for (int shift : shifts) {
        X = (X + shift) % 26;
      }
      for (int i = 0; i < string.length(); i++) {
        int index = string.charAt(i) - 'a';
        result.append((char) ((index + X) % 26 + 97));
        X = Math.floorMod(X - shifts[i], 26);
      }
	  
      return result.toString();
    } 

    public static void main(String[] args) {    
      String string = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      string = input.next();  

      System.out.println();
      System.out.print("Enter number of elements in the array: ");
      int numbers = input.nextInt();   
      int shifts[] = new int[numbers];
      
      System.out.println();	
      System.out.print("Please enter the elements of the array: ");
      for (int i = 0; i < shifts.length; i++) {
	shifts[i] = input.nextInt();
      }
      
      String result = shiftingLetters(string, shifts);
      System.out.println();
      System.out.print("The final string after all such shifts to " + string  + " are applied : " + result);
    }
  }
