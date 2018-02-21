import java.util.*;
import java.io.*;

  public class CanPlaceFlowers {
	  
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {   
      int count = 0;	
      for (int i = 0; i < flowerbed.length; i++) {
        if(flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
          flowerbed[i] = 1;	
          count++;
        }
      }

      return count >= n;      
    }	  

    public static void main(String[] args) { 	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int numbers = input.nextInt();   
      int flowerbed[] = new int[numbers];
	    
      System.out.println();
      System.out.print("Please enter the actual values in the array: ");
      for (int i = 0; i < numbers; i++) {
	flowerbed[i] = input.nextInt(); 
      }
	  
      System.out.println();
      System.out.print("Enter the number: ");
      int n = input.nextInt();  
	   
      boolean canBePlanted = canPlaceFlowers(flowerbed, n);
      System.out.println();
      if(canBePlanted) {
	System.out.println("Yes " + n + " new flowers can be planted in it without violating the no-adjacent-flowers rule."); 
      }
      else {
        System.out.println("No " + n + " new flowers cannot be planted in it without violating the no-adjacent-flowers rule."); 
      }
    }
  }
