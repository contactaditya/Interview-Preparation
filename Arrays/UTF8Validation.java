import java.util.*;
import java.io.*;

  public class UTF8Validation {
    private static int[] masks = {128, 64, 32, 16, 8};
	  
    public static boolean validUtf8(int[] data) {
      int length = data.length;
      for (int i = 0; i < length; i++) {
	int current = data[i];
        int type = getType(current);
        if (type == 0) {
          continue;
        } else if (type > 1 && i + type <= length) {
          while (type-- > 1) {
            if (getType(data[++i]) != 1) {
              return false;
            }
          }
        }
	else {
	  return false;  
	}
      }
      return true;      
    }
	
    public static int getType(int number) {
      for (int i = 0; i < 5; i ++) {
        if ((masks[i] & number) == 0) {
          return i;
        }
      }
      return -1;
    }

    public static void main(String[] args) {    
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int data[] = new int[number];
	
      System.out.println();	
      System.out.print("Please enter the elements in the array: ");
      for (int i = 0; i < data.length; i++) {
	data[i] = input.nextInt();
      }
		  
      System.out.println();
      boolean result = validUtf8(data);
      if(result) {
	System.out.println("It is a valid utf-8 encoding.");  
      }
      else {
	System.out.println("It is not an valid utf-8 encoding.");  
      }
    }
  }
