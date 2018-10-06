import java.io.*;
import java.util.*;

  public class WordSubsets {
	  
    public static List<String> wordSubsets(String[] A, String[] B) {
      List<String> result = new ArrayList<String>();
      int[] bmax = count("");
      for (String b : B) {
    	int[] bCount = count(b);  
    	for (int i = 0; i < 26; i++) {
          bmax[i] = Math.max(bmax[i], bCount[i]);
    	}
      }
      
      search: for (String a : A) {
        int[] aCount = count(a);  
        for (int i = 0; i < 26; i++) {
          if (aCount[i] < bmax[i]) {
            continue search;
          }
        }
        result.add(a);
      }
      
      return result;      
    }	  
	
    public static int[] count(String string) {
      int[] answer = new int[26];
      for (char c : string.toCharArray()) {
        answer[c - 'a']++;
      }
      return answer;
    }	

    public static void main(String[] args) {     
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int numbersA = input.nextInt();   
      String A[] = new String[numbersA];
		    
      System.out.println();
      input.nextLine();
      System.out.print("Please enter the actual values in the array: ");
      System.out.println();
      for (int i = 0; i < numbersA; i++) {
	A[i] = input.nextLine(); 
      }
      
      System.out.println();
      System.out.print("Enter number of elements in the array: ");
      int numbersB = input.nextInt();   
      String B[] = new String[numbersB];
		    
      System.out.println();
      input.nextLine();
      System.out.print("Please enter the actual values in the array: ");
      System.out.println();
      for (int i = 0; i < numbersB; i++) {
	B[i] = input.nextLine(); 
      }
      
      List<String> result = new ArrayList<String>();
      result = wordSubsets(A, B);
      System.out.println();
      System.out.println("The list of all universal words in the array A is: " + result);
      input.close();
    }
  }
