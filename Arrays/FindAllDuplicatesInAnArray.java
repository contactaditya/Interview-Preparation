import java.io.*;
import java.util.*;

 public class FindAllDuplicatesInAnArray {
	
   public static List<Integer> findDuplicates(int array[]) {
       List<Integer> result = new ArrayList<Integer>();
       for (int i = 0; i < array.length; ++i) {
         int index = Math.abs(array[i])-1;
         if (array[index] < 0) {
            result.add(Math.abs(index+1));
         }
         array[index] = -array[index];
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
     List<Integer> duplicates = new ArrayList<Integer>();
     duplicates = findDuplicates(array);  
     System.out.println();	 
     System.out.print("The following numbers are duplicates in the array: " + duplicates);
   }
 }

