import java.util.*;
import java.io.*;

  public class RestoreIPAddresses {
	  
	public static List<String> restoreIpAddresses(String string) {
	  List<String> result = new ArrayList<String>();
	  if(string.length() < 4 || string.length() > 12) {
        return result;
      }
      int length = string.length();
      for(int i = 1; i < 4 && i < length - 2 ; i++) {
        for(int j = i + 1; j < i + 4 && j < length - 1; j++) {
          for(int k = j + 1; k < j + 4 && k < length; k++) {
        	String section1 = string.substring(0, i);
            String section2 = string.substring(i, j);
            String section3 = string.substring(j, k);
            String section4 = string.substring(k);	  
            if(isValid(section1) && isValid(section2) && isValid(section3) && isValid(section4)) {
              result.add(section1 + "." + section2 + "." + section3 + "." + section4);
            }
          }
        }
      }
	  return result;
	}
	
	private static boolean isValid(String string) {
      if((string.length() > 1 && string.charAt(0) == '0') || Integer.parseInt(string) > 255) {
        return false;
      }
      
      return true;
    }

	public static void main(String[] args) {     
	  String string = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string = input.nextLine();  
	  
	  List<String> result = new ArrayList<String>();
		  
	  result = restoreIpAddresses(string);
	  System.out.println();
	  System.out.println("All possible valid IP address combinations are: " + result);
	}
  }
