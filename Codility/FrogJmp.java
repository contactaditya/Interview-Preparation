import java.util.*;
import java.io.*;

  public class FrogJmp {
	  
	public static int getMinimalNumberOfJumps(int X, int Y, int D) {
	  if ((Y - X) % D == 0) {
		return (Y - X) / D;
	  }
	  return (Y - X) / D + 1;  
	}

	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the current position of the frog: ");
	  int X = input.nextInt();   
		   
	  System.out.println();
	  System.out.print("Enter the target position of the frog: ");
	  int Y = input.nextInt();   
		   
	  System.out.println();
	  System.out.print("Enter the fixed distance that the frog jumps: ");
	  int D = input.nextInt(); 

	  int getMinimalNumberOfJumps = getMinimalNumberOfJumps(X, Y, D);
      System.out.println();
      System.out.print("The minimal number of jumps from position " + X + " to a position equal to or greater than " + Y + " is: " + getMinimalNumberOfJumps);
	}
  }
