import java.util.*;
import java.io.*;

  public class PoorPigs {
	  
	public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
	  if (buckets < 2) {
		return 0;
	  }
		    
	  if (minutesToDie > minutesToTest) {
		return Integer.MAX_VALUE;
	  }
	  
	  int k = minutesToTest/minutesToDie;
	  return (int)Math.ceil((Math.log(buckets) / Math.log(k + 1)));
	}	  

	public static void main(String[] args) {    
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of buckets: ");
	  int buckets = input.nextInt();  
	  System.out.println();
	  System.out.print("Enter number of minutes to die: ");
	  int minutesToDie = input.nextInt();  
	  System.out.println();
	  System.out.print("Enter number of minutes to test: ");
	  int minutesToTest = input.nextInt();  
		    
	  int result = poorPigs(buckets, minutesToDie, minutesToTest);
	  System.out.println();
	  System.out.print("The minimum amount of pigs you need to figure out which bucket contains the poison within one hour is: " + result);
	}
  }
