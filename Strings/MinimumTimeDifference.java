import java.util.*;
import java.io.*;

  public class MinimumTimeDifference {
	  
    public static int findMinDifference(List<String> timePoints) {
      boolean array[] = new boolean[24*60];
      int min = 24*60, max = 0;
      for(String time : timePoints) {
	int hour1 = (time.charAt(0) - '0') * 10 + time.charAt(1) - '0';
        int minute1 = (time.charAt(3) - '0') * 10 + time.charAt(4) - '0';
                    
        if(array[hour1 * 60 + minute1]) {
          return 0;
        }
        array[hour1 * 60 + minute1] = true;
      }
	  
      int previous = 0, first = Integer.MAX_VALUE;
      int last = Integer.MIN_VALUE;
      int result = Integer.MAX_VALUE;

      for (int i = 0; i < 24*60; i++) {
        if (array[i]) {
          if (first != Integer.MAX_VALUE) {
            result = Math.min(result, i - previous);
          }
          first = Math.min(first, i);
          last = Math.max(last, i);
          previous = i;
        }
      }

      return Math.min(result, first + 1440 - previous);
    }	  

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Please enter the number of elements in the list: ");
      int numberOfElements = input.nextInt();
      System.out.println();

      System.out.println("Please enter the time in Hour:Minutes format: ");
      ArrayList<String> timePoints = new ArrayList<String>();
      for (int i = 0; i < numberOfElements; i++) {
	timePoints.add(input.nextLine());
      }		 
      int minDifference = findMinDifference(timePoints); 
      System.out.println();
      System.out.println("The minimum minutes difference between any two time points in the list is: " + minDifference);
    }
  }
