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
	   
     List<Integer>[] bucket = new ArrayList[array.length + 1];
	 
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
   
   public static List<Integer> topKFrequent1(int[] array, int k) { 
     List<Integer> result = new ArrayList<Integer>();
     if (array == null || array.length == 0) {
       return result; 
     }
     int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
     for (int i = 0; i < array.length; i++) {
       if (array[i] < min) {
         min = array[i];
       }
       if (array[i] > max) {
         max = array[i];
       }
     }
     int[] frequency = new int[max - min + 1];
     for (int i = 0; i < array.length; i++) {
       frequency[array[i] - min]++;
     }
     List<Integer>[] buckets = new List[array.length + 1];
     for (int i = 0; i < frequency.length; i++) {
       if (buckets[frequency[i]] == null) {
         buckets[frequency[i]] = new ArrayList<Integer>();
       }
       buckets[frequency[i]].add(i + min);
     }
     for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
       if (buckets[i] != null) {
         result.addAll(buckets[i]);
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
     System.out.println();
     System.out.print("Enter the number of most frequent elements that you want the program to return: ");
     int k = input.nextInt();  
	   
     List<Integer> result = new ArrayList<Integer>();
     result = topKFrequent1(array, k);
     System.out.println();
     System.out.print("The solution set is: " + result);
   }
 }
