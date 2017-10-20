import java.util.*;

 public class LongestIncreasingSubsequence {

   public static void LongestIncreasingSubsequence(int[] array) {
      if(array.length == 0 || array == null) {
        return;  
      }
  
      int n = array.length; 
      int LIS[] = new int[n];
      int max = 0;
      ArrayList<Integer> elements = new ArrayList<>();
 
      for (int i = 0; i < n; i++ ) {
        LIS[i] = 1;
      } 
  
      for(int i = 1; i < n; i++) {
       for (int j = 0; j < i; j++) {
         if(array[i] > array[j] && LIS[i] < LIS[j] + 1) {
           LIS[i] = LIS[j] + 1; 
         }	   
       }
      }
 
      for(int i = 0; i < n; i++) {
        if(LIS[i] > max) {
          max = LIS[i];  
        }
      }
   
      for(int i = n-1; i >= 0; i--) {
        if(LIS[i] == max) {
          elements.add(array[i]);   
          max = max - 1;
          if(max == 0) {
            break;
          }
        }
      }	
 
      Collections.reverse(elements);
      System.out.println(); 
      System.out.print("The Longest Increasing Subsequence is: " + elements); 
 
   }
 
   public static void LongestIncreasingSubsequence1(int[] array) {
     if(array.length == 0 || array == null) {
       return;  
     }
	  
     int length = array.length; 
     int LIS[] = new int[length]; 
     int max = 0;
     ArrayList<Integer> list = new ArrayList<>();
 
     for(int number: array) {
       int i = Arrays.binarySearch(LIS, 0, max, number);
       if (i < 0) {
         i = -(i + 1);
       }
       LIS[i] = number;
       if (i == max) {
         max++;
       }
     }
     System.out.println(); 
     System.out.println();
     System.out.print("The size of Longest Increasing Subsequence is: " + max);
   } 
  
   public static void LongestIncreasingSubsequence2(int array[]) {
  
     int parent[]= new int[array.length]; //Tracking the predecessors/parents of elements of each subsequence.
     int increasingSub[]= new int[array.length + 1]; //Tracking ends of each increasing subsequence.
     int length = 0; //Length of longest subsequence.
      
     for(int i=0; i<array.length; i++) { //Binary search
       int low = 1;
       int high = length;
       while(low <= high) {
         int mid = (int) Math.ceil(low + (high-low)/2);
              
         if(array[increasingSub[mid]] < array[i]) { 
           low = mid + 1;
         }
         else {
           high = mid - 1;
         }
       }
          
       int position = low;
       //update parent/previous element for LIS
       parent[i] = increasingSub[position-1];
       //Replace or append
       increasingSub[position] = i;
          
       //Update the length of the longest subsequence.
       if(position > length) {
        length = position;
       }
     }
      
     //Generate LIS by traversing parent array
     int LIS[] = new int[length];
     int k = increasingSub[length];
     for(int j = length-1; j >= 0; j--) {
       LIS[j] = array[k];
       k = parent[k];
     }
     
     System.out.println();
     System.out.println();
     System.out.print("The Longest Increasing Subsequence is: "); 
        
     for(int i=0; i<length; i++) {
       System.out.print(LIS[i] + " ");
     }     
   }

   public static void main(String[] args) { 	
     Scanner input = new Scanner(System.in);
     System.out.print("Enter number of elements in the array: ");
     int numbers = input.nextInt();   
     int array[] = new int[numbers];
    
     System.out.print("\n");
     System.out.print("Please enter the actual values in the array: ");
     for(int i = 0; i < numbers; i++) {
       array[i] = input.nextInt(); 
     }
  
     LongestIncreasingSubsequence(array);
   
     LongestIncreasingSubsequence1(array);
  
     LongestIncreasingSubsequence2(array);
   }
 }
