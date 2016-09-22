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
   if(max==0) {
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
	  
 int n = array.length; 
 int LIS[] = new int[n]; 
 int max = 0;
 ArrayList<Integer> list = new ArrayList<>();
 
 for(int number: array) {
  if(list.size() == 0 || number>list.get(list.size() - 1)) {
    list.add(number);
  } 
  else {
   int low = 0;
   int high = list.size() - 1;
   
   while(low<high) {
    int mid = low + (high - low)/2;
    if(list.get(mid) < number) {
      low = mid + 1;
    }
    else {
      high = mid - 1;	 
    }
   }
   list.set(high, number);    
  }
 }
 
 System.out.println(); 
 System.out.println();
 System.out.print("The size of Longest Increasing Subsequence is: " + list.size());
} 
 
 static int CeilIndex(int input[], int T[], int end, int key) {
  int start = 0;
  int middle;
  int length = end;
  while (start <= end) {
   middle = start + (end - start)/2;
   if (middle < length && input[T[middle]] < key && key <= input[T[middle+1]]) {
     return middle+1;
   }
   else if (input[T[middle]] < key) {
     start = middle+1;   
   }
   else { 
     end = middle-1; 
   }
  }
 return -1;
 } 
 
 public static void LongestIncreasingSubsequence2(int[] array) {
  int size = array.length;
		  
  int[] T  = new int[size];
  int[] R  = new int[size];
  
  for(int i=0; i < R.length ; i++) {
    R[i] = -1;
  }

  T[0] = 0;
  int length = 0; 

  for (int i = 1; i < size; i++) {
   
   if (array[T[0]] > array[i]) { // if array[i] is less than 0th value of T then replace it there.
     T[0] = i;
   }
   else if (array[i] > array[T[length]]) { // if array[i] is greater than last value of T then append it in T
    length++;
    T[length] = i;
    R[T[length]] = T[length - 1];
   }

   else { //do a binary search to find ceiling of array[i] and put it there.         
    int index = CeilIndex(array, T, length, array[i]);
    T[index] = i;
    R[T[index]] = T[index-1];
  }
 }
  
  int index = T[length];
  System.out.println(); 
  System.out.println();
  System.out.print("The Longest Increasing Subsequence is: ");
  while(index != -1) {
   System.out.print(array[index] + " ");
   index = R[index];
  }
 } 
 
 public static void LongestIncreasingSubsequence3(int array[]) {
  
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
  for(int j=length-1; j>=0; j--) {
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
  
  LongestIncreasingSubsequence3(array);

 }
}
