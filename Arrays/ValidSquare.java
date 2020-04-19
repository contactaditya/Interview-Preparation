import java.util.*;
import java.io.*;

  public class ValidSquare {
	 
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
      return check(p1, p2, p3, p4) || check(p1, p3, p2, p4) || check(p1, p2, p4, p3);
    }
	    
    public static double calculateDistance(int[] p1, int[] p2) {
      return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }	
	     
    public static boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
      return calculateDistance(p1,p2) > 0 && calculateDistance(p1, p2) == calculateDistance(p2, p3) && calculateDistance(p2, p3) == calculateDistance(p3, p4) && calculateDistance(p3, p4) == calculateDistance(p4, p1) && calculateDistance(p1, p3) == calculateDistance(p2, p4);
    }

    public static void main(String[] args) { 	 
      Scanner input = new Scanner(System.in);
      int p1[] = new int[2];
      int p2[] = new int[2];
      int p3[] = new int[2];
      int p4[] = new int[2];
						    
      System.out.print("Please enter the actual values in the first point: ");
      for (int i = 0; i < 2; i++) {
	p1[i] = input.nextInt(); 
      }
	  
      System.out.println();
      System.out.print("Please enter the actual values in the second point: ");
      for (int i = 0; i < 2; i++) {
	p2[i] = input.nextInt(); 
      }
	  
      System.out.println();
      System.out.print("Please enter the actual values in the third point: ");
      for (int i = 0; i < 2; i++) {
	p3[i] = input.nextInt(); 
      }
	  
      System.out.println();
      System.out.print("Please enter the actual values in the fourth point: ");
      for (int i = 0; i < 2; i++) {
	p4[i] = input.nextInt(); 
      }

      boolean isValidSqaure = validSquare(p1, p2, p3, p4);   
      System.out.println();
      if(isValidSqaure) {
	System.out.println("The four points can construct a square.");  
      }
      else {
	System.out.println("The four points cannot construct a square.");    
      }
    }
  }
