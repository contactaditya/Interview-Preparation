import java.util.*;
import java.io.*;

 public class LongestSubstringWithoutRepeatingCharacters {
	
   public static int lengthOfLongestSubstring(String string) {
      int n = string.length();
      Set<Character> set = new HashSet<>();
      int ans = 0, i = 0, j = 0;
      
      while (i < n && j < n) {  	  
       // Trying to extend the range [i, j]
        if (!set.contains(string.charAt(j))) {
          set.add(string.charAt(j++));
          ans = Math.max(ans, j - i);
        }
        else {
           set.remove(string.charAt(i++));
        } 	  
      }
   return ans;
  }
   
   public static int lengthOfLongestSubstringOptimized(String string) {
      int n = string.length();
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      int ans = 0;
     // Trying to extend the range [i, j]      
      for (int j = 0, i = 0; j < n; j++) {  	  
	if (map.containsKey(string.charAt(j))) {
	   i = Math.max(map.get(string.charAt(j)), i);
	}
        ans = Math.max(ans, j - i + 1);
        map.put(string.charAt(j), j + 1);
      }
   return ans;
  }

 public static void main(String[] args) {  
    String string = new String();	  
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the string: ");
    string = input.nextLine(); 
    int length = lengthOfLongestSubstringOptimized(string);
    System.out.println();
    System.out.println("The longest substring without repeating characters is: " + length);
	  
  }
}
