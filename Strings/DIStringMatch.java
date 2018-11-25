import java.util.*;
import java.io.*;

  public class DIStringMatch {
	  
	public static int[] diStringMatch(String string) {
	  int increase = 0, decrease = string.length();
	  int[] answer = new int[string.length() + 1];
	  for (int i = 0; i < string.length(); i++) {
		if(string.charAt(i) == 'I') {
		  answer[i] = increase++;
		} else if (string.charAt(i) == 'D') {
	      answer[i] = decrease--;
		}
	  }
	  answer[string.length()] = increase;
		
	  return answer;      
	}

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  String string = new String();	
	  System.out.print("Enter the string: ");
	  string = input.nextLine();  
	  int topKFrequent[] = diStringMatch(string);
	  System.out.println();
	  System.out.print("The solution set is: ");
	  for (int i = 0; i < topKFrequent.length; i++) {
	    System.out.print(topKFrequent[i] + " ");
	  }
	  input.close();
	}
  }
