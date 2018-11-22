import java.util.*;
import java.io.*;

  public class ReorderLogFiles {
	  
    public static String[] reorderLogFiles(String[] logs) {
      String[] result = new String[logs.length];
      List<String> digitLog = new ArrayList<String>();
      Map<String, String> charLog = new TreeMap<String, String>();
      for(String string : logs) {
        if(isDigit(string)) {
          digitLog.add(string);
        } else {
          String log = extractLog(string);
          charLog.put(log, string);
        }
      }
      int i = 0;
      for(String key : charLog.keySet()) {
    	result[i++] = charLog.get(key);
      }
      for(String d : digitLog) {
    	result[i++] = d;
      }
      
      return result;      
    }

    private static boolean isDigit(String string) {
      int index = 0;
      while(string.charAt(index) != ' ') {
	index++;
      }
      return Character.isDigit(string.charAt(index + 1));
    }

    private static String extractLog(String string) {
      int index = 0;
      while(string.charAt(index) != ' ') {
	index++;
      }
      return string.substring(index + 1);
    }

    public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);	  
      System.out.print("Enter number of logs in the array: ");
      int numbers = input.nextInt();   
      String logs[] = new String[numbers];
		    
      System.out.println();
      input.nextLine();
      System.out.println("Please enter the actual values in the logs: ");
      for (int i = 0; i < numbers; i++) {
	logs[i] = input.nextLine(); 
      }
	    
      String result[] = reorderLogFiles(logs); 
      System.out.println();
      System.out.print("The final order of the logs is: ");
      System.out.print("[");
      for (int i = 0; i < result.length; i++) {
    	if(i < result.length - 1) {  
    	  System.out.print(result[i] + ", ");
    	} else {
    	  System.out.print(result[i] + "]");
    	}
      }
      input.close();
    }
  }
