import java.util.*;
import java.io.*;

  public class MinimumIndexSumOfTwoLists {
	  
	public static String[] findRestaurant(String[] list1, String[] list2) {
	  HashMap<String, Integer> map = new HashMap<String, Integer>();
	  for (int i = 0; i < list1.length; i++) {
        map.put(list1[i], i);
	  }
	  List<String> result = new ArrayList<String>();
	  int minSum = Integer.MAX_VALUE, sum;
	  for (int j = 0; j < list2.length && j <= minSum; j++) {
        if (map.containsKey(list2[j])) {
          sum = j + map.get(list2[j]);
          if(sum < minSum) {
            result.clear();
            result.add(list2[j]);
            minSum = sum;
          } else if (sum == minSum) {
            result.add(list2[j]);
          }
        }
	  }
		
	  return result.toArray(new String[result.size()]);      
	}	  

	public static void main(String[] args) { 	   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the first list: ");
	  int numberOfElementsInFirstList = input.nextInt();   
	  String list1[] = new String[numberOfElementsInFirstList];
		    
	  System.out.println();
	  input.nextLine();
	  System.out.print("Please enter the actual values in the array: ");
	  System.out.println();
	  for (int i = 0; i < numberOfElementsInFirstList; i++) {
		list1[i] = input.nextLine(); 
	  }
	   
	  System.out.print("Enter number of elements in the second list: ");
	  int numberOfElementsInSecondList = input.nextInt();   
	  String list2[] = new String[numberOfElementsInSecondList];
		    
	  System.out.println();
	  input.nextLine();
	  System.out.print("Please enter the actual values in the array: ");
	  System.out.println();
	  for (int i = 0; i < numberOfElementsInSecondList; i++) {
		list2[i] = input.nextLine(); 
	  }
	   
	  String restaurant[] = findRestaurant(list1, list2);
	  System.out.println();
	  System.out.print("The restaurant they both like and have the least index sum is: ");
	  for (int i = 0; i < numberOfElementsInFirstList; i++) {
		System.out.println(restaurant[i] + " ");
	  }
	}
  }
