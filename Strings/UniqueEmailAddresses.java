import java.util.*;
import java.io.*;

  public class UniqueEmailAddresses {
	  
	public static int numUniqueEmails(String[] emails) {
	  Set<String> set = new HashSet<String>();
	  for (String email : emails) {
	    set.add(transform(email));
	  }
	  return set.size();      
	}

	private static String transform(String email) {  
	  int a = email.indexOf('@');
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < a; i++) {
        char c = email.charAt(i);  
        if(c != '.') {
          if(c == '+') {
            sb.append(email.substring(a));
            break;  
          } else {
        	sb.append(c);  
          }
        }
      }

	  return sb.toString();
	}

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter number of email addresses: ");
      int numbers = input.nextInt();   
      String emails[] = new String[numbers];
		    
      System.out.println();
      input.nextLine();
      System.out.print("Please enter the actual email addresses: ");
      System.out.println();
      for (int i = 0; i < numbers; i++) {
	    emails[i] = input.nextLine(); 
      }
    
      int result = numUniqueEmails(emails);
      System.out.println();
      System.out.println("The number of different email addresses that actually receive mails are: " + result);
      input.close();
	}
  }
