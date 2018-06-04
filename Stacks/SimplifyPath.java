import java.util.*;
import java.io.*;

  public class SimplifyPath {
	  
    public static String simplifyPath(String path) {  
      Deque<String> stack = new LinkedList<String>();
      Set<String> skip = new HashSet<String>(Arrays.asList("..",".",""));
      for (String token : path.split("/")) {
        if (token.equals("..") && !stack.isEmpty()) {
          stack.pop();  
        } else if(!skip.contains(token)) {
          stack.push(token);
        }
      }
      String result = "";
      for (String dir : stack) {
    	result = "/" + dir + result;	
      }
      return result.isEmpty() ? "/" : result;      
    }	  

    public static void main(String[] args) {    
      Scanner input = new Scanner(System.in);
      String path = new String();	  
      System.out.print("Enter the string: ");
      path = input.nextLine();	
		  
      String result = simplifyPath(path);
      System.out.println();
      System.out.println("The simplified path for the file (Unix-style) is: " + result);
    }
  }
