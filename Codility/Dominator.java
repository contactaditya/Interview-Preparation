import java.util.*;
import java.io.*;

  public class Dominator {
	  
	public static int findDominator(int[] array, int N) {
	  HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
	  if(array.length == 1) {
		return 0;
	  }
      
      for (int i = 0; i < array.length; i++) {
        if (map.containsKey(array[i])) {
          if (map.get(array[i]) >= array.length/2) {
            return i;
          } else {
            map.put(array[i], map.get(array[i]) + 1);
          }
        } else {
          map.put(array[i], 1);
        }
      }
	   
	  return -1;  
	}

	public static void main(String[] args) { 	 
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of elements in the array: ");
      int lengthOfArray = input.nextInt();
      int[] array = new int[lengthOfArray];    
      System.out.println();	
      System.out.print("Please enter the elements in the array: ");
      for(int i=0;i<lengthOfArray;i++) {  
        array[i] = input.nextInt();
      }    
  
      int dominator = findDominator(array, array.length);
      System.out.println();	
      System.out.println("The dominator of the array is: " + dominator);	
	}
  }
