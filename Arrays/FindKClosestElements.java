import java.util.*;
import java.io.*;

  public class FindKClosestElements {
	
    public static List<Integer> findClosestElements(int[] array, int k, int x) {
       int low = 0, high = array.length - k;
       while (low < high) {
	 int mid = low + (high-low)/2;
	 if (x - array[mid] > array[mid+k] - x) { // From mid~mid+k there are k+1 elements
	   low = mid + 1; 
	 }
	 else {
	   high = mid;
	 }
       }
	    
       Integer boxedArray[] = Arrays.stream(array).boxed().toArray(Integer[]::new);
	    
       List<Integer> integerList= Arrays.asList(boxedArray);
	    
       return integerList.subList(low, low + k);
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
	System.out.println();
	System.out.print("Enter the number of closest elements that you want to find the array: ");
	int k = input.nextInt();  
	   
	System.out.println();
	System.out.print("Enter the number from which you want to find the closest element: ");
	int x = input.nextInt();  
	   
	List<Integer> result = new ArrayList<Integer>();
	   
        result = findClosestElements(array, k, x);
	System.out.println();
	System.out.print("The " + k + " closest element to " + x + " in the array are: " + result);
    }
  }
