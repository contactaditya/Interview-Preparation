import java.util.*;
import java.io.*;

  public class RepeatedDNASequences {
	  
    public static List<String> findRepeatedDnaSequences(String string) {
      Set<String> seen = new HashSet<String>();
      Set<String> repeated = new HashSet<String>();

      for(int i = 0; i <= string.length() - 10; i++) {
        String substring = string.substring(i, i + 10);
        if(!seen.add(substring)) {
          repeated.add(substring);
        }
      }
      
      return new LinkedList<String>(repeated);   
    }	  

    public static void main(String[] args) {   
      String string = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      string = input.nextLine(); 
	  
      List<String> result = new ArrayList<String>();
      result = findRepeatedDnaSequences(string);
      System.out.println();
      System.out.println("All the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule are: " + result);
    }
  }
