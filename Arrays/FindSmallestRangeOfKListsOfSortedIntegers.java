import java.util.*;
import java.io.*;

 public class FindSmallestRangeOfKListsOfSortedIntegers {

    public static int[] smallestRange(List<List<Integer>> array) {
      int maxValue = Integer.MIN_VALUE, maxIndex = 0;
      int current[] = new int[array.size()];
   
      for(int i = 0; i < array.size(); i++) {
    	if (array.get(i).get(current[i]) > maxValue) {
          maxIndex = i;
          maxValue = array.get(i).get(current[i]);
        }
      }
      int range[] = new int[2];
      range[0] = 0; range[1] = 0;
      int result = Integer.MAX_VALUE;
      boolean flag = true;
      while (flag) {
        int minIndex = 0, minValue = Integer.MAX_VALUE;
        for (int i = 0; i < array.size(); i++) {
          while (current[i] + 1 < array.get(i).size() && array.get(i).get(current[i] + 1) <= maxValue) {
             current[i]++;
          }
          if (array.get(i).get(current[i]) < minValue) {
            minIndex = i;
            minValue = array.get(i).get(current[i]);
          }
        }
        if (maxValue - minValue < result)  {
          result = maxValue - minValue;
          range[0] = minValue;
          range[1] = maxValue;
        }
        if (current[minIndex] == array.get(minIndex).size() - 1) {
          flag = false;
        } else {
          current[minIndex]++;
          maxIndex = minIndex;
          maxValue = array.get(maxIndex).get(current[maxIndex]);
        }
      }
      return range; 
	}	 

	public static void main(String[] args) {
	   Scanner input = new Scanner(System.in);
	   System.out.print("Enter the number of lists: ");
	   int numberOfLists = input.nextInt();	   
	   List<List<Integer>> array = new ArrayList<List<Integer>>();
	   for (int i = 0; i < numberOfLists; i++) {
		 System.out.println();  
	     System.out.print("Enter the number of elements in the list: ");
		 int numberOfElements = input.nextInt();
	     System.out.println();
	     System.out.print("Please enter the actual elements in the list: ");
	     ArrayList<Integer> list = new ArrayList<Integer>();
	     for (int j = 0; j < numberOfElements; j++) {
	        list.add(input.nextInt());
		 }	
	     array.add(list);
	   }		  

	   int smallestRange[] = smallestRange(array);
	   System.out.println();
	   System.out.print("The smallest range that includes at least one number from each of the k lists is: ");
	   for(int i = 0; i < smallestRange.length; i++){
	     System.out.print(smallestRange[i] + " ");
	   }
	}
 }
