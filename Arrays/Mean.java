import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Mean {
	
  public static long calculateMean(long[] array) {

    long n = array.length;  
    long sum = 0;
    long mean = 0;
     
    for(int i=0; i<n; i++) {
      sum = sum + array[i];
    }

    mean = sum/n;

    return mean;		
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
	
  System.out.print("\n");
	  	
  long mean = calculateMean(array);
    
  System.out.print("\n");
    
  System.out.println("The value of the mean of the array is: " + mean);

  }
}
