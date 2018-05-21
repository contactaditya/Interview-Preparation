import java.util.*;
import java.io.*;

  public class WaterAndJugProblem {
	  
    public static boolean canMeasureWater(int x, int y, int z) {  
      // limit brought by the statement that water is finally in one or both buckets
      if(x + y < z) {
	return false;
      }
      // case x or y is zero
      if(x == z || y == z || x + y == z) {
	return true;
      }
		
      // get GCD, then we can use the property of Bézout's identity
      return z % GCD(x, y) == 0;	
    }	  
	  
    private static int GCD(int a, int b) {
      while(b != 0 ) {
	int temp = b;
	b =  a % b;
	a = temp;
      }
	    
      return a;	
    }

    public static void main(String[] args) {     
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the capacity of the first jug: ");
      int x = input.nextInt();  
      System.out.println();	
      System.out.print("Enter the capacity of the second jug: ");
      int y = input.nextInt();  
      System.out.println();	
      System.out.print("Enter the capacity of the jug that needs to be measured: ");
      int z = input.nextInt();  
      
      boolean result = canMeasureWater(x, y, z);
      System.out.println();
      if(result) {
	System.out.println("Yes we have " + z + " liters of water contained within one or both buckets by the end");  
      }
      else {
	System.out.println("No we do not have " + z + " liters of water contained within one or both buckets by the end");  
      }
    }
  }
