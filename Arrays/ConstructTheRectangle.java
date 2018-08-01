import java.util.*;
import java.io.*;

  public class ConstructTheRectangle {
	
    public static int[] constructRectangle(int area) {
      int width = (int) Math.sqrt(area);
      while(area % width != 0) {
    	width--;
      }
      return new int[]{area/width, width};
    }

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int area = input.nextInt();   
		    	   
      int result[] = constructRectangle(area); 
		   
      System.out.println();
      System.out.print("The dimensions of the rectangular web page, whose length L and width W satisfy the given requirements are: ");
      System.out.print("[");
      for (int i = 0; i < result.length; i++) {
	System.out.print(" " + result[i] + " ");
      }		   
      System.out.print("]");
    }
  }
