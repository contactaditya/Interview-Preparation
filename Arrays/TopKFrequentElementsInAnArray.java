import java.util.*;
import java.io.*;

 public class TopKFrequentElementsInAnArray {
	 
	public static List<Integer> topKFrequent(int[] array, int k) {
	   //count the frequency for each element
	   HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	   for(int number : array) {
	     if(map.containsKey(number)) {
	       map.put(number, map.get(number)+1);
	     } else {
	       map.put(number, 1);
	     }
	   }
	   
	   List<Integer>[] bucket = new List[array.length + 1];
	 
	   for(int key : map.keySet()) {
		 int frequency = map.get(key);
		 if (bucket[frequency] == null) {
		   bucket[frequency] = new ArrayList<>();
		 }
		 bucket[frequency].add(key);
	   }
	   
	   List<Integer> result = new ArrayList<Integer>();
	   
	   for (int position = bucket.length - 1; position >= 0 && result.size() < k; position--) {
		  if (bucket[position] != null) {
			result.addAll(bucket[position]);
		  }
		}

	   return result;     
	}	 

	public static void main(String[] args) {
	   Scanner input = new Scanner(System.in);
	   System.out.print("Enter number of elements in the array: ");
	   int numbers = input.nextInt();   
	   int array[] = new int[numbers];
		    
	   System.out.print("\n");
	   System.out.print("Please enter the actual values in the array: ");
	   for (int i = 0; i < numbers; i++) {
		 array[i] = input.nextInt(); 
	   }
	   System.out.println();
	   System.out.print("Enter the number of most frequent elements that you want the program to return: ");
	   int k = input.nextInt();  
	   
	   List<Integer> result = new ArrayList<Integer>();
	   result = topKFrequent(array, k);
	   System.out.println();
	   System.out.print("The solution set is: " + result);
	}
 }
