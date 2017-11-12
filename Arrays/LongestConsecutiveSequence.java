import java.util.*;
import java.io.*;

  public class LongestConsecutiveSequence {
	  
	public static int longestConsecutive(int[] array) { 
	   if(array.length == 0 || array == null) {
	     return 0;  
	   }
	   Arrays.sort(array);

       int longestStreak = 1;
       int currentStreak = 1;
       for (int i = 1; i < array.length; i++) {
         if (array[i] != array[i-1]) {
           if (array[i] == array[i-1]+1) {
             currentStreak += 1;
           }
           else {
             longestStreak = Math.max(longestStreak, currentStreak);
             currentStreak = 1;
           }
         }
       }

       return Math.max(longestStreak, currentStreak);
	}	  

	public static void main(String[] args) {    
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int numbers = input.nextInt();   
      int array[] = new int[numbers];

      System.out.println();
      System.out.print("Please enter the actual values in the array: ");
      for(int i = 0; i < numbers; i++) {
    	array[i] = input.nextInt(); 
      }

      int longestConsecutiveSequence = longestConsecutive(array);
      System.out.println();
      System.out.print("The length of the longest consecutive elements sequence is: " + longestConsecutiveSequence);
      
	}
  }
