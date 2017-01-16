import java.io.*;
import java.util.*;

 public class ShuffleAnArray {
	private static int array[];
	private static int shuffle[];
	private static Random random;
	
	public ShuffleAnArray() {
       this.array = array;
       this.shuffle = shuffle;
       random = new Random();
    }
	
	/** Returns a random shuffling of the array. */
    public static int[] shuffle(int[] array) {
      if(array == null) {
         return null;
      }
      shuffle = array.clone();
      for(int i = 0; i < shuffle.length; i++) {
        int randomPosition = random.nextInt(shuffle.length);
        swap(shuffle, i, randomPosition);
      }
      return shuffle;   
    }	
    
    private static void swap(int array[], int left, int right) {
       int temp = array[left]; 
       array[left] = array[right]; 
       array[right] = temp; 
    }	
    
    /** Resets the array to its original configuration and return it. */
    
    public int[] reset() {
       return array;
    }

	public static void main(String[] args) { 	
	  ShuffleAnArray arrayshuffle  = new ShuffleAnArray();	
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the first array: ");
	  int number = input.nextInt();  
	  array = new int[number];
	
	  System.out.println();	
	  System.out.print("Please enter the elements of the array: ");
	  for (int i = 0; i < array.length; i++) {
	    array[i] = input.nextInt();
      }
	  
	  int result[] = new int[array.length];
		
	  result = shuffle(array);
	  System.out.print("\n");  
	  System.out.print("The array after shuffling is: ");
	  for(int i = 0; i < result.length; i++) {
		System.out.print(result[i] + " ");  
	  }
   }
}
