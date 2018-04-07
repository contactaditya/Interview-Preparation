import java.io.*;
import java.util.*;

public class SlidingWindowMaximum {
	
  public static int[] maxSlidingWindow(int array[], int k) {
    if (array == null || k <= 0) {
      return new int[0];
    }	
	   
    int n = array.length;
    int result[] = new int[n-k+1];
    int index = 0;
	   
    // Create a Double Ended Queue, queue that will store indexes of array elements. The queue will store indexes of useful elements in every window and it will maintain decreasing order of values from front to rear in queue, i.e., array[queue.front[]] to array[queue.rear()] are sorted in decreasing order
	  
    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) { 
      // remove numbers out of range k   
      while (!queue.isEmpty() && queue.peek() < i - k + 1) {
	queue.poll();
      }
      // remove smaller numbers in k range as they are useless
      while (!queue.isEmpty() && array[queue.peekLast()] < array[i]) {
	queue.pollLast();
      } 
      // queue contains index... r contains content
      queue.offer(i);
      if(i >= k - 1) {
	result[index++] = array[queue.peek()]; 
      }	      
    }
    return result;
  }	 

  public static void main(String[] args) {  
    Scanner input = new Scanner(System.in);
    System.out.print("Enter number of elements in the array: ");
    int number = input.nextInt();  
    int array[] = new int[number];
		  
    System.out.println();	
    System.out.print("Please enter the actual numbers in the array: ");
    for (int i = 0; i < array.length; i++) {
      array[i] = input.nextInt();
    }
	  
    System.out.println();	
    System.out.print("Enter the size of the sliding window: ");
    int sizeOfSlidingWindow = input.nextInt();      
    int slidingWindow[] =  maxSlidingWindow(array, sizeOfSlidingWindow);
    System.out.println();	
    System.out.print("The maximum sliding window is: ");
    for (int i = 0; i < array.length-sizeOfSlidingWindow+1; i++) {
      System.out.print(slidingWindow[i] + " ");
    }
  }
}
