import java.util.*;

public class IsUnique {
	 
  public static boolean isUniqueChars(String string) {
	if(string.length() > 128) {
	   return false;	
	}
	
	boolean[] char_set = new boolean[128];
	
	for(int i = 0;i < string.length(); i++) {
	   int value = string.charAt(i);
	   if(char_set[value]) {
		  return false;
	   }
	   
	   char_set[value] = true;
	}
	  
    return true;	  
  }
	
  public static void main(String[] args) {  
	String string = new String();	  
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the string: ");
    string = input.next(); 
  
    boolean isUnique = isUniqueChars(string);
    
    System.out.println();
    
    if(isUnique) {
      System.out.print("The string has all unique characters.");	
    }
    
    else {
      System.out.print("The string does not have all unique characters.");	
    }

  }
}
