import java.util.*;
import java.io.*;

  public class IsomorphicStrings {
	
	public static boolean isIsomorphic(String s, String t) { 
	  if(s == null || t == null) {
        return false;
	  }
 
      if(s.length() != t.length()) {
    	return false;	  
      }
      
      Map<Character, Character> map = new HashMap<Character, Character>();
      for(int i=0; i<s.length(); i++) {
        char c1 = s.charAt(i);
        char c2 = t.charAt(i);
   
        if(map.containsKey(c1)) {
          if(map.get(c1) != c2) { // if not consistant with previous ones
            return false;
          } 
        } else {
          if(map.containsValue(c2)) { //if c2 is already being mapped
            return false;
          }
          map.put(c1, c2);
        }
      }  
 
      return true;      
	}	  

	public static void main(String[] args) { 
	  String s = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the first string: ");
	  s = input.nextLine();  
	  System.out.println();	
	  String t = new String();	  
	  System.out.print("Enter the second string: ");
	  t = input.nextLine();
		  
	  boolean isIsomorphic = isIsomorphic(s, t);
	  System.out.println();
	  if(isIsomorphic) {
		System.out.println("Yes the strings " + s + " and " + t + " are isomorphic.");  
	  }
      else {
    	System.out.println("No the strings " + s + " and " + t + " are not isomorphic.");   
	  }
	}
  }
