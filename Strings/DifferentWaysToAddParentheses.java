import java.util.*;
import java.io.*;

  public class DifferentWaysToAddParentheses {
	  
	public static List<Integer> differentWaysToCompute(String input) {				
	  return differentWaysToCompute(input, 0, input.length() - 1, new List[input.length()][input.length()]);      
    }   
	  
	public static List<Integer> differentWaysToCompute(String input, int begin, int end, List<Integer> list[][]) {
	  List<Integer> result = new ArrayList<Integer>();	
	  if(list[begin][end] != null) {
		return list[begin][end];
	  }
	  for(int i = begin; i <= end; ++i) {
	    char c = input.charAt(i);	  
	    if(!Character.isDigit(c)) {
	      List<Integer> l1 = differentWaysToCompute(input, begin, i - 1, list);
          List<Integer> l2 = differentWaysToCompute(input, i + 1, end, list); 	
          for(int n1 : l1) {
            for(int n2 : l2) {
              result.add(c == '+' ? (n1 + n2) : c == '-' ? (n1 - n2) : (n1 * n2));  
        	}
          }
	    }
	  }
	  
	  if(result.size() == 0) {
		result.add(Integer.valueOf(input.substring(begin, end + 1)));
	  }
	  
      list[begin][end] = result;
		
	  return result;      
	}  

	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  String string = new String();	
	  System.out.print("Enter the string: ");
	  string = input.next(); 
	  
	  List<Integer> result = new ArrayList<Integer>();
	  result = differentWaysToCompute(string);
	  System.out.println();
	  System.out.println("All possible results from computing all the different possible ways to group numbers and operators are: " + result);	 
	}
  }
