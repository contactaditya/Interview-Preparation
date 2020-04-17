import java.util.*;
import java.io.*;

  public class FindLuckyIntegerInAnArray {
	  
    public static int findLucky1(int[] array) {
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();

      for(int i : array) {
        if(!map.containsKey(i)) {
          map.put(i, 1);
	}
        else {
          map.replace(i, map.get(i) + 1);
        }
      }
	  
      int luckyInteger = -1;
      for(int i = 0; i < array.length; i++) {
        if((map.get(array[i])) == array[i]) {
          luckyInteger = Math.max(array[i], luckyInteger);  
        } 
      }
	  
      return luckyInteger;      
    }	
	
    public static int findLucky(int[] array) {
      int count[] = new int[501];
      for(int i = 0; i < array.length; i++) {
        count[array[i]]++;
      }
      for(int i = 500; i >= 1; i--) {
        if(count[i] == i) {
          return i;
        }
      }
      return -1;  
    }		
  
    public static void main(String[] args) {     
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int numbers = input.nextInt();   
      int array[] = new int[numbers];
	    
      System.out.println();
      System.out.print("Please enter the actual values in the array: ");
      for (int i = 0; i < numbers; i++) {
        array[i] = input.nextInt(); 
      }
      int luckyNumber = findLucky(array);
      System.out.println();
      System.out.print("The lucky integer in the array is: " + luckyNumber);
      input.close();
    }
  }
