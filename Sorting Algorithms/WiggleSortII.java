import java.util.*;
import java.io.*;

 public class WiggleSortII {
	 
	public static void wiggleSort(int[] array) {
	  if (array == null || array.length <= 1) {
	     return;
	  }
	  Arrays.sort(array);
      int n = array.length;
      
      int[] temp = new int[n];
      int left = (n - 1) / 2;
      int right = n - 1;
      
      for (int i = 0; i < n; i++) {
        if ((i & 1) == 0) {
          temp[i] = array[left];
          left--;
        } else {
          temp[i] = array[right];
          right--;
        }
      }
      System.arraycopy(temp, 0, array, 0, n);
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

	   wiggleSort(array);
	   System.out.println();
	   System.out.print("The array after wiggle sort is: ");
	   for (int i=0; i < array.length; i++) {
		 System.out.print(array[i] + " ");
	   }
	}
 }
