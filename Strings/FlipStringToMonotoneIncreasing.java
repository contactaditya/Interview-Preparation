import java.util.*;
import java.io.*;

  public class FlipStringToMonotoneIncreasing {
	  
    public static int minFlipsMonoIncreasing(String string) {
      int ldp[] = new int[string.length()], rdp[] = new int[string.length()];
      char s[] = string.toCharArray();
      int l = 0, r = 0;
      for (int i = 0, j = s.length - 1; i < s.length; i++, j--) {
	ldp[i] = l;
        rdp[j] = r;
	if (s[i] == '1') {
	  l++;
	}
        if (s[j] == '0') {
          r++;
        }
      }
      int result = Integer.MAX_VALUE;
      for (int i = 0; i < s.length; i++) {
        result = Math.min(result, ldp[i] + rdp[i]);
      }
      return result;
    }

    public static void main(String[] args) {   
      String string = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      string = input.next(); 
      int length = minFlipsMonoIncreasing(string);
      System.out.println();
      System.out.print("The minimum number of flips to make " + string + " monotone increasing are: " + length);
      input.close();
    }
  } 
