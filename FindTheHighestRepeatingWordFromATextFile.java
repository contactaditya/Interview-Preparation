import java.util.*;
import java.util.Map.Entry;
import java.io.*;

 public class FindTheHighestRepeatingWordFromATextFile {
	
   public static Map<String, Integer> buildWordMap(String fileName) { 	 
     Map<String, Integer> wordMap = new HashMap<>(); 
     try {
       BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
       String line = null; 
       while ((line = br.readLine()) != null) { 
	 StringTokenizer st = new StringTokenizer(line, " ");		
	 while(st.hasMoreTokens()) {
	   String word = st.nextToken().toLowerCase();
	   if (wordMap.containsKey(word)) { 
	     wordMap.put(word, (wordMap.get(word) + 1)); 
	   } else { 
	     wordMap.put(word, 1); 
	   }   
	 }
       }
     }
     catch (IOException e) { 
       System.err.println("Caught IOException: " + e.getMessage()); 
     } 
     return wordMap;    
   }
    
   public static List<Entry<String, Integer>> sortByValue(Map<String, Integer> wordMap) {
     Set<Entry<String, Integer>> entries = wordMap.entrySet(); 
     List<Entry<String, Integer>> list = new ArrayList<>(entries);
     Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() { 
       @Override 
       public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) { 
    	 return (o2.getValue()).compareTo(o1.getValue()); 
       } 
     });

     return list;
   }
		
   public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     String fileName = new String();	  
     System.out.print("Please enter the path of the file that you want to read: ");	
     fileName = input.next();  	
     Map<String, Integer> wordMap = buildWordMap(fileName); 
     List<Entry<String, Integer>> list = sortByValue(wordMap); 
     System.out.println();
     System.out.println("List of repeated word from file and their count:");
     for (Map.Entry<String, Integer> entry : list) { 
       if (entry.getValue() > 1) { 
	 System.out.println(entry.getKey() + " " + entry.getValue()); 
       } 
     }		
   }
 }
