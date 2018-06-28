import java.util.*;
import java.io.*;

  public class CompareVersion { 	
	  
    public static int compareVersion(String version1, String version2) {     
      if (version1 == null || version2 == null || version1.length() == 0 || version2.length() == 0) {
	return 0;
      }
      int i = 0;
      int j = 0;
      while (i < version1.length() || j < version2.length()) {   
        double val1 = 0, val2 = 0;
        while (i < version1.length() && version1.charAt(i) != '.') {
          val1 = val1 * 10 + ((double) version1.charAt(i) - '0');
          i++;
        }
        while (j < version2.length() && version2.charAt(j) != '.') {
          val2 = val2 * 10 + ((double) version2.charAt(j) - '0');
          j++;
        }  
        if (val1 < val2) {
          return -1;
        }
        else if (val1 > val2) {
          return 1;
        }
        i++;
        j++;  
      }

      return 0;
    }  
	  
    public static int compareVersion1(String version1, String version2) {  
      String[] levels1 = version1.split("\\.");
      String[] levels2 = version2.split("\\.");
      int length = Math.max(levels1.length, levels2.length);
      for (int i=0; i < length; i++) {
	Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
	Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
	int compare = v1.compareTo(v2);
	if (compare != 0) {
	  return compare;
	}  
      }

      return 0;
    }  

    public static void main(String[] args) {       
      String a = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the first version: ");
      a = input.nextLine();  
      System.out.println();	
      String b = new String();	  
      System.out.print("Enter the second version: ");
      b = input.nextLine();
	  
      int result = compareVersion(a, b);
      System.out.println();
      if(result == 1) {
    	System.out.println("Version 1 is greater than Version 2.");  
      } else if(result == -1) {
    	System.out.println("Version 2 is greater than Version 1.");    
      } else {
    	System.out.println("Version 1 is same as Version 2.");  
      }
    }
  }
