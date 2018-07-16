import java.io.*;
import java.util.*;

  public class SlidingWindowMaximum1 {
	  
    public static ArrayList<Integer> slidingMaximum(final List<Integer> list, int sizeOfSlidingWindow) { 	 
      if (list == null || sizeOfSlidingWindow <= 0) {
        return new ArrayList<Integer>();
      }	
  	   
      int n = list.size();
      ArrayList<Integer> result = new ArrayList<Integer>();
      int index = 0;
  	   
      // Create a Double Ended Queue, queue that will store indexes of array elements. The queue will store indexes of useful elements in every window and it will maintain decreasing order of values from front to rear in queue, i.e., array[queue.front[]] to array[queue.rear()] are sorted in decreasing order
  	  
      Deque<Integer> queue = new ArrayDeque<Integer>();
      for (int i = 0; i < n; i++) { 
        // remove numbers out of range k   
        while (!queue.isEmpty() && queue.peek() < i - sizeOfSlidingWindow + 1) {
  	  queue.poll();
        }
        // remove smaller numbers in k range as they are useless
        while (!queue.isEmpty() && list.get(queue.peekLast()) < list.get(i)) {
  	  queue.removeLast();
        } 
        // queue contains index... r contains content
        queue.offer(i);
        if(i >= sizeOfSlidingWindow - 1) {
   	  result.add(list.get(queue.peek()));
        }	      
      }
      return result; 
    }  

    public static void main(String[] args) { 	
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the list: ");
      int number = input.nextInt();  
      ArrayList<Integer> list = new ArrayList<Integer>();	
			
      System.out.println();	
      System.out.print("Please enter the elements of the list: ");
      for (int i = 0; i < number; i++) {
	list.add(input.nextInt());
      }
      
      System.out.println();	
      System.out.print("Enter the size of the sliding window: ");
      int sizeOfSlidingWindow = input.nextInt();      
      ArrayList<Integer> result = new ArrayList<Integer>();	 
      
      result = slidingMaximum(list, sizeOfSlidingWindow); 
      System.out.println();	
      System.out.print("The maximum sliding window is: " + result);
    }
  }
