import java.util.*;
import java.io.*;

  public class PartitionLabels {
	  
    public static List<Integer> partitionLabels(String string) {       
      int[] last = new int[26]; // index of string where char occurs last
      for (int i = 0; i < string.length(); i++) {
        last[string.charAt(i) - 'a'] = i;
      }
      int startIndex = 0, endIndex = 0; 
      List<Integer> answer = new ArrayList<Integer>();
      for (int i = 0; i < string.length(); i++) {
    	endIndex = Math.max(endIndex, last[string.charAt(i) - 'a']); // If we are at a label that occurs last at some index after j, we'll extend the partition
        // If we are at the end of the partition then we'll append a partition size to our answer, and set the start of our new partition to endIndex + 1
        if (endIndex == i) {
          answer.add(1 + endIndex - startIndex);
          startIndex = endIndex + 1;
        }
      }
      
      return answer;      
    }

    public static void main(String[] args) { 
      Scanner input = new Scanner(System.in);	 
      String string = new String();	
      System.out.print("Enter the string: ");
      string = input.nextLine();      
	   
      List<Integer> result = new ArrayList<Integer>();
      result = partitionLabels(string);
      System.out.println();
      System.out.print("The solution set is: " + result);
    }
  }
