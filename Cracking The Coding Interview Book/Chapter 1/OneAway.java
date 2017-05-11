import java.util.*;

public class OneAway {  
	
  public static boolean oneEditAway(String string1, String string2) {
      if(string1.length() == string2.length()) {
	 return oneEditReplace(string1, string2);
      }
      else if (string1.length() + 1 == string2.length()) {
	 return oneEditInsert(string1, string2);	
      }
      else if (string1.length() - 1 == string2.length()) {
	 return oneEditInsert(string2, string1);		
      }

    return false;  
  }
  
  public static boolean oneEditReplace(String string1, String string2) {
     boolean foundDifference = false;  
     for(int i = 0; i < string1.length(); i++) {
       if(string1.charAt(i) != string2.charAt(i)) {
	 if(foundDifference) {
	    return false;
	 }
        foundDifference = true;
       }
     }	  
    return true;
  }
  
  public static boolean oneEditInsert(String string1, String string2) {
     int index1 = 0; 	   
     int index2 = 0; 
     
     while(index2 < string2.length() && index1 < string1.length()) {
        if(string1.charAt(index1) != string2.charAt(index2)) {
          if(index1 != index2) {
             return false;
          }
        index2++;  	
        }
        
       else {
         index1++; 	
         index2++; 	
       }
     } 
    return true;  
  }
	
  public static void main(String[] args) { 	  
    String string = new String();	  
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the first string: ");
    string = input.nextLine(); 
    
    System.out.println();
    
    String string1 = new String();	  
    System.out.print("Enter the second string: ");
    string1 = input.nextLine(); 
    
    boolean isOneEdit = oneEditAway(string, string1);
    System.out.println();
    System.out.println(string + ", " + string1 + ": " + isOneEdit);
	
  }
}
