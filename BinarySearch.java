import java.io.*;
import java.util.*;

public class BinarySearch {
	
public static int binarySearch(int[] a, int key) {
  int low = 0;
  int high = a.length - 1;
  int mid;
		
  while (low <= high) {
    mid = (low + high) / 2;
    if (a[mid] < key) {
      low = mid + 1;
    } else if (a[mid] > key) {
      high = mid - 1;
    } else {
      return mid;
    }
  }
return -1;
}
	
 public static void main(String[] args) throws NumberFormatException, IOException {
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
   System.out.println("Enter number of elements in the array:");
   int number = Integer.parseInt(br.readLine());
   int array[] = new int[number];
   System.out.println("Please enter the actual values in the array:");
   for (int i = 0; i < number; i++) {
     array[i] = Integer.parseInt(br.readLine());
   }
   System.out.print("The actual values in the array are: ");
   for (int i = 0; i < number; i++) {
     System.out.print(array[i] + " ");
   }
   Arrays.sort(array);
   System.out.print("\n");
   System.out.print("The sorted array is: ");
   for (int i=0; i < array.length; i++) {
     System.out.print(array[i] + " ");
   }
   System.out.print("\n");
   System.out.println("Enter the element to search:");
   int key = Integer.parseInt(br.readLine());
   int index = binarySearch(array,key);
   if (index != -1) {
    System.out.println("Element found at index position: " + index);
   } else {
    System.out.println("Element has not been found");
    }
  }
}	
