import java.util.*;
import java.io.*;

  public class GroupsOfSpecialEquivalentStrings {
	
    public static int numSpecialEquivGroups(String[] string) {
      Set<String> set = new HashSet<String>();	
      for (String S : string) {
        set.add(encode(S));
      }
      return set.size();      
    }

    private static String encode(String string) {
      char[] even = new char[string.length()/2 + string.length() % 2];
      char[] odd = new char[string.length()/2];
	  
      for(int i = 0; i < string.length(); i++) {
	if(i % 2 == 0) {
	  even[i/2] = string.charAt(i);
	}
        else {
          odd[(i-1)/2] = string.charAt(i);  
        }
      }
		
      Arrays.sort(even);
      Arrays.sort(odd);
      return new String(even) + new String(odd);
   }

    public static void main(String[] args) { 	 
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of words: "); 
      int numbers = input.nextInt();   
      String string[] = new String[numbers];
		    
      System.out.println();
      input.nextLine();
      System.out.print("Please enter the actual words: ");
      System.out.println();
      for (int i = 0; i < numbers; i++) {
	string[i] = input.nextLine(); 
      }
	  
      int result = numSpecialEquivGroups(string);
      System.out.println();
      System.out.println("The number of groups of special-equivalent strings from the array is: " + result);
    }
  }
