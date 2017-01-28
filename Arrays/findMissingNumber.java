import java.util.Scanner;

public class findMissingNumber {

 public static int findMissingNumber(int array[], int firstElement) {
  int n = array.length;
  int sum = 0;
   
  sum = ((n+1)*((2*firstElement) + (n)))/2;
   
  for (int i = 0; i < array.length; i++) {
     sum =  sum - array[i];
  }
  
  return sum; 
 }

 public static void main(String[] args) {
  Scanner input = new Scanner(System.in);
  System.out.print("Enter number of elements in the first array: ");
  int number = input.nextInt();  
  int array[] = new int[number];
	
  System.out.println();	
  System.out.print("Please enter consecutive elements in the array with exactly only one element missing: ");
  for (int i = 0; i < array.length; i++) {
     array[i] = input.nextInt();
  }
  
  int firstElement = array[0];
	
  int missingnumber = findMissingNumber(array, firstElement);

  System.out.println();	
  System.out.println("The missing element in the array is: " + missingnumber);
  }
}
