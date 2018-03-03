import java.util.*;

  public class CheckPermutation {   
	 
    public static String sort(String string) {
      char[] content = string.toCharArray();
      java.util.Arrays.sort(content);
      return new String(content);
    }
   	 
    public static boolean checkPermutation(String string1, String string2) {
      if(string1.length() != string2.length()) {
        return false;
      }
	  		  
      return sort(string1).equals(sort(string2));	  
    }
  
    public static boolean checkPermutation1(String string1, String string2) {
      if(string1.length() != string2.length()) {
	return false;
      }
	
      int[] letters = new int[128];
	
      for(int i = 0; i < string1.length(); i++) {
	letters[string1.charAt(i)]++;	
      }
	
      for(int i = 0; i < string2.length(); i++) {
	letters[string2.charAt(i)]--;
	if(letters[string2.charAt(i)] < 0) {
	  return false;   
	}	   
      }
	  		  
      return true;  
    }

    public static void main(String[] args) { 
      String string1 = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the first string: ");
      string1 = input.next(); 
	 
      System.out.println();
      String string2 = new String();	  
      System.out.print("Enter the second string: ");
      string2 = input.next(); 
	
      boolean anagram = checkPermutation(string1, string2);
	 
      System.out.println();
	 
      if(anagram) {
	System.out.print("One of the string is a permutation of the other.");	
      }
	    
      else {
	System.out.print("The strings are not permutation of each other.");	
      }
    }
  }
