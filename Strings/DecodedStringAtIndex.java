import java.util.*;
import java.io.*;

  public class DecodedStringAtIndex {
	  
	public static String decodeAtIndex(String string, int K) {
	  long size = 0;
	  
	  // Find size = length of decoded string
      for (int i = 0; i < string.length(); i++) {
        char c = string.charAt(i);
        if (Character.isDigit(c)) {
          size *= c - '0';
        }
        else {
          size++;
        }
      }
      
      for (int i = string.length() - 1; i >= 0; i--) {
        char c = string.charAt(i);
        K %= size; // Whenever the decoded string would equal some word repeated d times, we can reduce K to K % (size)
        if (K == 0 && Character.isLetter(c)) {
          return Character.toString(c);
        }
        // If we see a digit string[i] it means the size of the decoded string after parsing size / Integer(S[i])
        if (Character.isDigit(c)) {
          size /= c - '0';
        }
        else {
          size--;
        }
      }
		
      throw null;    
	}

	public static void main(String[] args) {   
	  String string = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string = input.nextLine(); 
	  System.out.println();
	  System.out.print("Enter the index: ");
	  int K = input.nextInt(); 
	  	  
	  String result = decodeAtIndex(string, K);
	  System.out.println();
	  System.out.println("The K-th letter (1 indexed) in the decoded string is: " + result);  
	  input.close();
	}
  }
