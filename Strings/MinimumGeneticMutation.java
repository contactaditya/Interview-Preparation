import java.util.*;
import java.io.*;

  public class MinimumGeneticMutation {
	  
    public static int minMutation(String start, String end, String[] bank) {
      if(start.equals(end)) {
	return 0;
      }
      Set<String> bankSet = new HashSet<String>();
      for(String b : bank) {
	bankSet.add(b);
      }
	        
      char[] charSet = new char[]{'A', 'C', 'G', 'T'};
      int level = 0;
      Set<String> visited = new HashSet<String>();
      java.util.Queue<String> queue = new LinkedList<String>();
      queue.offer(start);
      visited.add(start);
      
      while(!queue.isEmpty()) {
        int size = queue.size();
        while(size-- > 0) {
          String current = queue.poll();
          if(current.equals(end)) {
            return level;
          }
          char[] currentArray = current.toCharArray();
          for(int i = 0; i < currentArray.length; i++) {
            char old = currentArray[i];  
            for(char c : charSet) {
              currentArray[i] = c;
              String next = new String(currentArray);
              if(!visited.contains(next) && bankSet.contains(next)) {
                visited.add(next);
                queue.offer(next);
              }
            }
            currentArray[i] = old;
          }
        }
        level++;
      }
      return -1;        
    }  

    public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      String start = new String();	  
      System.out.print("Enter the start mutation: ");
      start = input.nextLine();
	  
      System.out.println();	
      String end = new String();	  
      System.out.print("Enter the end mutation: ");
      end = input.nextLine();
	  
      System.out.println();	
      System.out.print("Enter number of mutations in the gene bank: ");
      int numbers = input.nextInt();   
      String bank[] = new String[numbers];    
      System.out.println();
      input.nextLine();
      System.out.print("Please enter the actual valid gene mutations: ");
      System.out.println();
      for (int i = 0; i < numbers; i++) {
	bank[i] = input.nextLine(); 
      }

      int minimumNumberOfMutations = minMutation(start, end, bank);
      System.out.println();	
      System.out.println("The minimum number of mutations needed to mutate from " + start + " to " + end + " are: " + minimumNumberOfMutations);	
    }
  }
