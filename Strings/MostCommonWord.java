import java.util.*;
import java.io.*;

  public class MostCommonWord {
	  
    public static String mostCommonWord(String paragraph, String[] banned) {
      paragraph += ".";	
      String answer = "";
      int ansfrequency = 0;
      
      Set<String> banset = new HashSet<String>();
      for (String word : banned) {
    	banset.add(word);
      }
      Map<String, Integer> count = new HashMap<String, Integer>();
      StringBuilder word = new StringBuilder();
      for (char c : paragraph.toCharArray()) {
        if (Character.isLetter(c)) {
          word.append(Character.toLowerCase(c));
        } else if (word.length() > 0) {
            String finalword = word.toString();
            if(!banset.contains(finalword)) {
              count.put(finalword, count.getOrDefault(finalword, 0) + 1);  
              if(count.get(finalword) > ansfrequency) {
        	answer = finalword;
        	ansfrequency = count.get(finalword);  
              }
            }
            word = new StringBuilder();
        }
      }
			
      return answer;      
    }	  

    public static void main(String[] args) {    
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of banned words: ");
      int numbers = input.nextInt();   
      String banned[] = new String[numbers];    
      System.out.println();
      input.nextLine();
      System.out.print("Please enter the banned words: ");
      System.out.println();
      for (int i = 0; i < numbers; i++) {
	banned[i] = input.nextLine(); 
      }
      System.out.println();	
      String paragraph = new String();	  
      System.out.print("Enter the paragraph: ");
      paragraph = input.nextLine();
		  
      String mostCommonWord = mostCommonWord(paragraph, banned);
      System.out.println();	
      System.out.print("The most frequent word that is not in the list of banned words is: " + mostCommonWord);
    }
  }
