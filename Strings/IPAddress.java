import java.util.*;
import java.io.*;

  public class IPAddress {
	  
    public static List<String> restoreIpAddresses(String string) {  
      if (string.length() < 3 || string.length() > 12) {
	return new ArrayList<String>();
      }
      return convert(string);
    }	

    private static List<String> convert(String string) {
      List<String> list = new ArrayList<String>();
      int size = string.length();

      String stringNew = string;
      for (int i = 1; i < size - 2; i++) {
    	for (int j = i + 1; j < size - 1; j++) {
    	  for (int k = j + 1; k < size; k++) {
    	    stringNew = stringNew.substring(0, k) + "." + stringNew.substring(k);
    	    stringNew = stringNew.substring(0, j) + "." + stringNew.substring(j);
    	    stringNew = stringNew.substring(0, i) + "." + stringNew.substring(i); 
            if (isValid(stringNew)) {
              list.add(stringNew);
            }
            stringNew = string;
    	  }
    	}
      }
      Collections.sort(list, new Comparator<String>() {
        public int compare(String o1, String o2) {
          String a1[] = o1.split("[.]");
    	  String a2[] = o2.split("[.]");
    	 
          int result = -1;
    	  for (int i = 0; i < 4 && result != 0; i++) {
    	    result = a1[i].compareTo(a2[i]);
    	  }
    	  return result;
    	}
      });
       
      return list;
    }
	
    private static boolean isValid(String ip) {  
      String array[] = ip.split("[.]");
      for (String string : array) {
        int i = Integer.parseInt(string);
        if (string.length() > 3 || i < 0 || i > 255) {
          return false;
        }
        if (string.length() > 1 && i == 0) {
          return false;
        }
        if (string.length() > 1 && i != 0 && string.charAt(0) == '0') {
          return false;
        }
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
      System.out.println("All possible valid IP address combinations from the given string " + string + " are: " + result);  
    }
  }
