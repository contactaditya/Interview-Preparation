import java.util.*;
import java.io.*;

  public class UniqueLetterString {
	  
	public static int uniqueLetterString(String string) {
	  int result = 0;	
	  if (string == null || string.length() == 0) {
        return result;    
	  }
	  int showLastPosition[] = new int[128];
      int contribution[] = new int[128];
      int current = 0;
      for (int i = 0; i < string.length(); i++) {
        char x = string.charAt(i);
        current -= contribution[x]; 
        contribution[x] = (i - (showLastPosition[x] - 1));
        current += contribution[x]; 
        showLastPosition[x] = i + 1;
        result += current;
      }   
      
      return result;      
	}
	
	public static int uniqueLetterString1(String string) {
	  Map<Character, List<Integer>> index = new HashMap<Character, List<Integer>>();
	  for (int i = 0; i < string.length(); i++) {
	    char c = string.charAt(i);
        index.computeIfAbsent(c, x -> new ArrayList<Integer>()).add(i);
	  }   
	  long answer = 0;
	  for (List<Integer> list : index.values()) {
        for (int i = 0; i < list.size(); i++) {
          long previous = i > 0 ? list.get(i-1) : -1;
          long next = i < list.size() - 1 ? list.get(i+1) : string.length();
          answer += (list.get(i) - previous) * (next - list.get(i));
        }
      }
	      
	  return (int) answer % 1_000_000_007;      
	}	

	public static void main(String[] args) {   
	  String string = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string = input.nextLine(); 
	  int result = uniqueLetterString(string);
	  System.out.println();
	  System.out.println("The number of unique letters over all non empty substrings of " + string + " are: " + result);
      input.close();
	}
  }
