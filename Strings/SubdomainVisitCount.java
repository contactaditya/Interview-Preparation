import java.util.*;
import java.io.*;

  public class SubdomainVisitCount {
	
    public static List<String> subdomainVisits(String[] cpdomains) {
      Map<String, Integer> counts = new HashMap<String, Integer>();
      for (String domain : cpdomains) {
        String[] cpinfo = domain.split("\\s+");
        String[] fragments = cpinfo[1].split("\\.");
        int count = Integer.valueOf(cpinfo[0]);
        String current = "";
        for (int i = fragments.length - 1; i >= 0; i--) {
          current = fragments[i] + (i < fragments.length - 1 ? "." : "") + current;
          counts.put(current, counts.getOrDefault(current, 0) + count);
        }
      }
      List<String> answer = new ArrayList<String>();
	  
      for (String domain : counts.keySet()) {
        answer.add("" + counts.get(domain) + " " + domain);
      }
		
      return answer;      
    }

    public static void main(String[] args) { 	  
      Scanner input = new Scanner(System.in); 
      System.out.print("Enter number of elements in the array: ");
      int numbers = input.nextInt();   
      String cpdomains[] = new String[numbers];
		    
      System.out.println();
      input.nextLine();
      System.out.print("Please enter the actual values in the array: ");
      System.out.println();
      for (int i = 0; i < numbers; i++) {
	cpdomains[i] = input.nextLine(); 
      }
      List<String> result = new ArrayList<String>();
      result = subdomainVisits(cpdomains); 
      System.out.println();
      System.out.println("The sentence where every word is a valid word is: " + result);
    }  
  }
