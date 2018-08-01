import java.util.*;
import java.io.*;

  public class KthLargest {
	private static java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<Integer>();
	private static int k;
	
	public KthLargest(int k, int[] array) {
	  this.k = k;
	  for (int number : array) {
	    add(number);
	  }    
	}
	    
	public static int add(int value) {
      pq.offer(value);
      if (pq.size() > k) {
        pq.poll();
      }
		
	  return pq.peek();
	}
	    
	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the kth largest element whose value you want to find: ");
	  int k = input.nextInt();   
	  
	  System.out.println();
	  System.out.print("Enter number of elements in the array: ");
	  int numbers = input.nextInt();   
	  int array[] = new int[numbers];
					    
	  System.out.println();
	  System.out.print("Please enter the actual values in the array: ");
	  for (int i = 0; i < numbers; i++) {
		array[i] = input.nextInt(); 
	  }

	  KthLargest kthLargest = new KthLargest(k, array);
	  int result = kthLargest.add(5); // returns 5
	  System.out.println();
	  System.out.print("The kth largest element in the stream is: " + result);
	}
  }
