import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
  System.out.print("Enter number of elements in the array: ");
  int numbers = Integer.parseInt(br.readLine());  
  long array[] = new long[numbers];
    
  System.out.print("\n");
  System.out.println("Please enter the actual values in the array:");
  System.out.print("\n");
  for (int i = 0; i < numbers; i++) {
    array[i] = Integer.parseInt(br.readLine());
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
