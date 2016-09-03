import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Median {

  public static long calculateMedian(long[] array) {

    int n = array.length;  
    long median = 0;
		     
    if (n%2!=0) {
    median = array[n/2];
    }

    if (n%2==0) {
    median = (array[n/2] + array[(n-2)/2])/2;
    }

    return median;
  }	
	
  public static void main(String[] args) throws NumberFormatException, IOException {
	
	  	Scanner input = new Scanner(System.in);
	    System.out.print("Enter number of elements in the array: ");
	    int numbers = input.nextInt();   
	    long array[] = new long[numbers];
	    
	    System.out.print("\n");
		System.out.print("Please enter the actual values in the array: ");
		for (int i = 0; i < numbers; i++) {
		  array[i] = input.nextInt(); 
		}
		
		System.out.print("\n");
		
		System.out.print("The actual values in the array are: ");
		for (int i = 0; i < numbers; i++) {
		  System.out.print(array[i] + " ");
		}  
		
		System.out.print("\n \n");
		
		Arrays.sort(array);
		
		System.out.print("The sorted values in the array are: ");
		
		 for (Long i : array) {
		   System.out.print(i.intValue() + " ");
		 }
		  	
	    long median = calculateMedian(array);
	    
	    System.out.print("\n \n");
	    
	    System.out.println("The value of the median of the array is: " + median);

		}
	}