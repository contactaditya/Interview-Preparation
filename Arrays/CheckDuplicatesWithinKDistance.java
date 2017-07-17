import java.util.*;
import java.io.*;

  public class CheckDuplicatesWithinKDistance { 
	
    public static boolean checkDuplicatesWithinKDistance(int array[], int k) {
      /** Base case: when K is greater than array size **/
      if (k > array.length || array.length == 1) {
        return false;
      }
      HashSet<Integer> set = new HashSet<Integer>();
      for (int i = 0; i < array.length; i++) {
       // If already present n hash, then we found a duplicate within k distance.
	if (set.contains(array[i])) {
	  System.out.println();	
	  System.out.println("The duplicate that is present within k distance is: " + array[i]);	
          return true;  
	}
	set.add(array[i]);
	    
	// Remove the k+1 distant item
        if (i >= k) {
          set.remove(array[i-k]);
        }   
      }
      return false;
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
       System.out.print("Please enter a number k which is smaller than the size of the array: ");
       int k = input.nextInt();   
       boolean checkDuplicates = checkDuplicatesWithinKDistance(array, k);
       System.out.println();
       if(checkDuplicates) {
	 System.out.println("There are duplicates which are within k distance.");
       }
       else {
	 System.out.println("All duplicates are more than k distance away.");  
       }
    }
  }
