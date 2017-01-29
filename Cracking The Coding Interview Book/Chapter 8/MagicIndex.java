import java.util.*;

 public class MagicIndex {
	 
  public static int magicFast(int array[]) {
     return magicFast(array, 0, array.length - 1);
  }	 
	 
  public static int magicFast(int array[], int start, int end) {
     if(end < start) {
       return -1;
     }
	 
     int midIndex = (start + end) / 2;
     int midValue = array[midIndex];
	 
     if(midValue == midIndex) {
	return midIndex; 
     }
	   
     int leftIndex = Math.min(midIndex - 1, midValue);  
     int left = magicFast(array, start, leftIndex);
     if(left >= 0) {
	return left; 
     }
	
    int rightIndex = Math.max(midIndex + 1, midValue);
    int right = magicFast(array, rightIndex, end);
	 
    return right;
  }	 

 public static void main(String[] args) { 	
    Scanner input = new Scanner(System.in);
    System.out.print("Enter number of elements in the array: ");
    int numbers = input.nextInt();   
    int array[] = new int[numbers];
      
    System.out.print("\n");
    System.out.print("Please enter the actual values in the array: ");
    for (int i = 0; i < numbers; i++) {
       array[i] = input.nextInt();
    }
	 
    int magicIndex = magicFast(array);
	  
    System.out.println();
    System.out.println("The magic index in the array is at: " + magicIndex);
   }
 }
