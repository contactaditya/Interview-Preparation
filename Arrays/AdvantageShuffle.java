import java.util.*;
import java.io.*;

  public class AdvantageShuffle {
	  
	public static int[] advantageCount(int[] A, int[] B) {
	  Arrays.sort(A);
      int[] result = new int[A.length];
      // Sort the value of B in decreasing order
      java.util.PriorityQueue<int[]> pq= new java.util.PriorityQueue<int[]>(new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
          return b[0] - a[0];
        }
      });
      // Initialize the value of Priority Queue with B
      for (int i = 0; i < A.length; i++) {
    	pq.add(new int[]{B[i], i});
      }
      int low = 0, high = A.length - 1;
      while(!pq.isEmpty()) {
        int[] current = pq.poll();
        int index = current[1], value = current[0]; // We store the value and index of the biggest element of B
        if (A[high] > value) {
          result[index] = A[high--]; // If A[high] > value then it means A can satisfy current value of B
        }
        else {
          result[index] = A[low++]; // B cannot be satisfied we just put the smallest element in the slot
        }
      }

	  return result;      
	}	  

	public static void main(String[] args) {       
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int A[] = new int[number];
		  
      System.out.println();	
      System.out.print("Please enter the actual values of the element in the first array: ");
      for (int i = 0; i < A.length; i++) {
	    A[i] = input.nextInt();
      }
		    
      int B[] = new int[number];
		  
      System.out.println();	
      System.out.print("Please enter the actual values of the element in the second array: ");
      for (int i = 0; i < B.length; i++) {
	    B[i] = input.nextInt();
      }
		  
      int result[] = new int[A.length + B.length];
		  
      result = advantageCount(A, B);
      System.out.println();	
      System.out.print("The permutation of A that maximizes its advantage with respect to B is: ");
      for(int i = 0; i < result.length; i++) {
	    System.out.print(result[i] + " ");
      }
	}	
  }
