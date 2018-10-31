import java.util.*;
import java.io.*;

  public class BeautifulArray {
	  
	public static int[] beautifulArray(int number) {
	  int result[] = new int[number];
	  if(number == 1) {
	    result[0] = 1;
	  } else {
		int t = 0;
		for (int x : beautifulArray((number + 1)/2)) {
		  result[t++] = 2 * x - 1;
		}
		for (int x : beautifulArray((number)/2)) {
		  result[t++] = 2 * x;
		}
	  }
	  return result;
	}

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();   
	  int result[] = beautifulArray(number);
	  System.out.println();
      System.out.print("A beautiful array is: "); 
	  System.out.print("[");
      for(int i = 0; i < result.length; i++) {
  	    System.out.print(" " + result[i] + " ");
  	  }
      System.out.println("]");
      input.close();
	}
  }
