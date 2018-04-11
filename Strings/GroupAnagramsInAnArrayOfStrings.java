import java.util.*;
import java.io.*;

 public class GroupAnagramsInAnArrayOfStrings {
	  
   public static List<List<String>> groupAnagrams(String[] string) {
     if (string == null || string.length == 0) {
       return new ArrayList<List<String>>();		
     }
     Map<String, List<String>> answer = new HashMap<String, List<String>>();
     for (String s : string) {
       char[] charArray = s.toCharArray();
       Arrays.sort(charArray);
       String key = String.valueOf(charArray);
       if (!answer.containsKey(key)) { 
         answer.put(key, new ArrayList());
       }
       answer.get(key).add(s);
     }
	   
     return new ArrayList(answer.values());     
   }	  

   public static void main(String[] args) {   
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the number of words in the list: ");
     int numberOfWords = input.nextInt();
     System.out.println();
     input.nextLine();
     System.out.println("Please enter the actual words in the list: ");
     ArrayList<String> list = new ArrayList<String>();
     for (int i = 0; i < numberOfWords; i++) {
       list.add(input.nextLine());
     }		   
     String[] array = list.toArray(new String[0]);
     List<List<String>> result = new ArrayList<List<String>>();
     System.out.println();
     result = groupAnagrams(array);
     System.out.println("The anagrams after being grouped together: " + result);
   }
 }
