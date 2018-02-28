import java.util.*;
import java.io.*;

  public class RelativeRanks {
	  
	public static String[] findRelativeRanks(int[] array) {
	  String[] result = new String[array.length];	
	  if(array == null || array.length == 0) {
		return new String[0];
	  }
	  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	  for(int i = 0; i < array.length; i++){
        map.put(array[i], i);
      }
	  Arrays.sort(array);
	  for (int i = 0; i < array.length; i++) {
        if (i == array.length-1) {
          result[map.get(array[i])] = "Gold Medal";
        }
        else if (i == array.length-2) {
          result[map.get(array[i])] = "Silver Medal";
        }
        else if (i == array.length-3) {
          result[map.get(array[i])] = "Bronze Medal";
        }
        else {
          result[map.get(array[i])] = (array.length - i) + "";
        }
      }
	
	  return result;      
	}	  

	public static void main(String[] args) { 	 
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int numbers = input.nextInt();   
	  int array[] = new int[numbers];

	  System.out.println();
	  System.out.print("Please enter the actual values in the array: ");
	  for (int i = 0; i < numbers; i++) {
		array[i] = input.nextInt();
	  }
	  	  
	  String result[] = findRelativeRanks(array);
	  System.out.println();	
	  System.out.print("The relative ranks and the people with the top three highest scores, who will be awarded medals: Gold Medal, Silver Medal and Bronze Medal are: ");
	  System.out.print("[");	
	  for (int i=0; i < result.length; i++) {
		if(i != result.length - 1) {  
		  System.out.print(result[i] + ", ");
		}
		else {
		  System.out.print(result[i] + "]");	
		}
	  }
	}
  }
