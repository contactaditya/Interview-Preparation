import java.io.*;
import java.util.*;

public class FirstNonRepeatedCharacter { 
	
  public static Character firstNonRepeatedCharacter(String string) {
    if(string == null) {
       return null;	
    }
		
    LinkedHashMap<Character, Integer> hashmap = new LinkedHashMap<Character, Integer>();  
		
    for(int i = 0; i< string.length(); i++) {  
       if(string.charAt(i) != ' ') {  
         if(hashmap.get(string.charAt(i)) != null) {  
           hashmap.put(string.charAt(i), hashmap.get(string.charAt(i)) + 1);  
         } else {  
           hashmap.put(string.charAt(i), 1);  
         }  
       }  
    }  
		
    for(Character character : hashmap.keySet()) {		
       if(hashmap.get(character) == 1) {
	  return character;
       }
    }
    return null;
  }

  public static void main(String[] args) { 
    String string = new String();	  
    Scanner input = new Scanner(System.in); 
    System.out.print("Enter the string: ");
    string = input.next(); 
	  
    Character character = firstNonRepeatedCharacter(string);
	  
    System.out.println();
	  
    if(character != null) {  
       System.out.println("First Non Repeated Character in the string is: " + character);
    } else {
       System.out.println("No non repeated characters are found"); 
    }
  }
}
