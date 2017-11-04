import java.io.*;
import java.util.*;

 public class FindAllNumbersDisappearedInAnArray {
	 
	public static List<Integer> findDisappearedNumbers(int[] array) {
	   List<Integer> result = new ArrayList<Integer>();	
	   int n = array.length;
	   for (int i = 0; i < array.length; i++) {
		 array[(array[i]-1) % n] += n; 	
	   }
	   for (int i = 0; i < array.length; i ++) {
		 if (array[i] <= n) {
		   result.add(i+1);	
		 }
	   }
		
	   return result;     
	}	 

	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int number = input.nextInt();  
	  int array[] = new int[number];
			  
	  System.out.println();	
	  System.out.print("Please enter the actual numbers in the array: ");
      for (int i = 0; i < array.length; i++) {
		array[i] = input.nextInt();
	  }
	  List<Integer> disappearedNumbersList = new ArrayList<Integer>();
	  disappearedNumbersList = findDisappearedNumbers(array);  
	  System.out.println();	
	  System.out.print("All the elements that do not appear in the array are: " + disappearedNumbersList);

	}
 }
