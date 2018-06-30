import java.util.*;

public class RemoveDuplicatesFromSortedArray {
	
  public static HashSet<Integer> removeDuplicates(int array[]) {
    int count = 0;	
    HashSet<Integer> result = new HashSet<Integer>();
    for (int i = 0; i < array.length; i++) {
      result.add(array[i]);
    }
	  
    return result;
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
	  
    Arrays.sort(array);
	  
    HashSet<Integer> duplicates = new HashSet<Integer>();
    duplicates = removeDuplicates(array); 
    System.out.println();	
    System.out.print("The array without any duplicates is: " + duplicates);	  	  
  }
} 
