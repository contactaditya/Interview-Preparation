import java.util.*;
import java.io.*;

  public class BitwiseORsOfSubarrays {
	  
    public static int subarrayBitwiseORs(int[] array) {
      Set<Integer> answer = new HashSet<Integer>();
      Set<Integer> current = new HashSet<Integer>();
      current.add(0);
      for (int x : array) {
        Set<Integer> current2 = new HashSet<Integer>();
        for (int y : current) {
          current2.add(x | y);
        }
        current2.add(x);
        current = current2;
        answer.addAll(current);
      }
      
      return answer.size();      
    }

    public static void main(String[] args) { 	   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
		
      System.out.println();	
      System.out.print("Please enter the elements of the array: ");
      for (int i = 0; i < array.length; i++) {
	array[i] = input.nextInt();
      }
	  
      int result = subarrayBitwiseORs(array); 
      System.out.println("The number of possible Bitwise ORs of the Subarrays is: " + result);  
    }
  }
