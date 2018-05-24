import java.util.*;
import java.io.*;

  class Tuple implements Comparable<Tuple> {
    int x, y, value;
    public Tuple (int x, int y, int value) {
      this.x = x;
      this.y = y;
      this.value = value;
    }
    
    @Override
    public int compareTo (Tuple that) {
      return this.value - that.value;
    }
  }

  public class FindKPairsWithSmallestSums {
	  
    public static List<int[]> kSmallestPairs(int[] array1, int[] array2, int k) {
	  List<int[]> result = new ArrayList<int[]>();
	  if(array1.length == 0 || array2.length == 0) {
        return result;
      }
	  java.util.PriorityQueue<Tuple> pq = new java.util.PriorityQueue<Tuple>();
	  for(int j = 0; j <= array2.length - 1; j++) {
		pq.offer(new Tuple(0, j, array1[0] + array2[j]));
	  }
	  for(int i = 0; i < Math.min(k, array1.length * array2.length); i++) {
        Tuple t = pq.poll();
        result.add(new int[]{array1[t.x], array2[t.y]});
        if(t.x == array1.length - 1) {
          continue;
        }
        pq.offer(new Tuple (t.x + 1, t.y, array1[t.x + 1] + array2[t.y]));
      }
	 
	  return result;       
    }	  

	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the first array: ");
	  int number = input.nextInt();  
	  int array[] = new int[number];
		  
	  System.out.println();	
	  System.out.print("Please enter the actual numbers in the first array: ");
	  for (int i = 0; i < array.length; i++) {
		array[i] = input.nextInt();
	  }
		    
	  Arrays.sort(array);
		  
	  System.out.println();	
	  System.out.print("Enter number of elements in the second array: ");
      int number1 = input.nextInt();  
	  int array1[] = new int[number1];
		  
	  System.out.println();	
	  System.out.print("Please enter the actual numbers in the second array: ");
	  for(int i = 0; i < array1.length; i++) {
		array1[i] = input.nextInt();
	  } 
		  
	  Arrays.sort(array1);
	  
	  System.out.println();
	  System.out.print("Enter the number of pairs that you want to find with the smallest sum: ");
	  int k = input.nextInt();  
	  
	  List<int[]> result = new ArrayList<int[]>();
	  result = kSmallestPairs(array, array1, k);
	  System.out.println();	
	  System.out.print("The " + k + " pairs with the smallest sums are: ");
	  for(int[] array2 : result) {
	    System.out.print(Arrays.toString(array2));
	  }
	}
  }
