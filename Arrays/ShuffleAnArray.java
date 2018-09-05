import java.io.*;
import java.util.*;

  public class ShuffleAnArray {
    private int array[];
	private int shuffle[];
	private Random random;
		
	public ShuffleAnArray(int[] array) {
      this.array = array;
      shuffle = array.clone();
      random = new Random();
    }
	
	/** Returns a random shuffling of the array. */
    public int[] shuffle() {
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
    
    private void swap(int array[], int left, int right) {
      int temp = array[left]; 
      array[left] = array[right]; 
      array[right] = temp; 
    }	
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
      return array;
    }

	public static void main(String[] args) { 	
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int number = input.nextInt();  
	  int[] array = new int[number];
	
	  System.out.println();	
	  System.out.print("Please enter the elements of the array: ");
	  for (int i = 0; i < array.length; i++) {
	    array[i] = input.nextInt();
      }
	  
	  ShuffleAnArray arrayshuffle  = new ShuffleAnArray(array);	
	  
	  int result[] = new int[array.length];
		
	  result = arrayshuffle.shuffle();
	  System.out.println();	
	  System.out.print("The array after shuffling is: ");
	  for(int i = 0; i < result.length; i++) {
		System.out.print(result[i] + " ");  
	  }
	  System.out.println();	
	  int result1[] = new int[array.length];
      result1 = arrayshuffle.reset();
	  
	  System.out.println();	
	  System.out.print("The array after reset is: ");
	  for(int i = 0; i < result1.length; i++) {
		System.out.print(result1[i] + " ");  
	  }
	  System.out.println();	
	  
	  int result2[] = new int[array.length];
	  
	  result2 = arrayshuffle.shuffle();
	  System.out.println();	
	  System.out.print("The array after shuffling is: ");
	  for(int i = 0; i < result2.length; i++) {
		System.out.print(result2[i] + " ");  
	  }
	  input.close();
    }
  }
