import java.util.*;
import java.io.*;

  public class HandOfStraights {
	  
	public static boolean isNStraightHand(int[] hand, int W) {
	  Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
      for(int i : hand) {
    	map.put(i, map.getOrDefault(i, 0) + 1);
      }
      for(int i : map.keySet()) {
        int count = map.get(i);
        if(count == 0) {
          continue; 
        }
        for(int j=i; j<i+W; j++) {
          Integer c = map.get(j);
          if(c == null || c < count) {
        	return false;
          }
          map.put(j, c-count);
        }
      }
	  return true;      
	}	  

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int number = input.nextInt();  
	  int hand[] = new int[number];
	
	  System.out.println();	
	  System.out.print("Please enter the elements in the array: ");
	  for (int i = 0; i < hand.length; i++) {
		hand[i] = input.nextInt();
	  }
	  
	  System.out.println();	
	  System.out.print("Enter the number: ");
	  int W = input.nextInt();  
	 
	
	  boolean result = isNStraightHand(hand, W);
	  System.out.println();	
	  if(result) {
	    System.out.print("Yes it is possible to rearrange the cards into groups so that each group is size " + W + ", and consists of " + W + " consecutive cards.");
	  }
	  else {
		System.out.print("No it is not possible to rearrange the cards into groups so that each group is size " + W + ", and consists of " + W + " consecutive cards.");  
	  }
	}
  }
