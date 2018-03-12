import java.util.Scanner;

public class findProductWithoutCurrentElement {

  public static void findProductWithoutCurrentElement(int array[]) {
    int n = array.length;
    int product[] = new int[n];
    int multiplication = 1;
     
    // Calculating the product of all the elements to the left of the current element 
   
    for(int i = 0; i < n; i++) {
      product[i] = multiplication;  
      multiplication = multiplication * array[i];
    }
   
    multiplication = 1;
   
    // Calculating the product of all the elements to the right of the current element 
   
    for(int i = n-1; i >= 0; i--) {
      product[i] = product[i] * multiplication;  
      multiplication = multiplication * array[i];
    }
   
    System.out.println();	
    System.out.print("The content of the output array is: ");
   
    for(int i = 0; i < n; i++) {
      System.out.print(product[i] + " ");
    }
  }
 
  public static void findProductWithoutCurrentElement1(int array[]) {
    int n = array.length;
    int product[] = new int[n];
    int multiplication = 1;

    for(int i = 0; i < n; i++) {
      multiplication = multiplication * array[i];
    }
	   
    for(int j = 0; j < n; j++) {
      product[j] = multiplication/array[j];
    }
	   
    System.out.println();	
    System.out.print("The content of the output array is: ");
	   
    for(int i = 0; i < n; i++) {
      System.out.print(product[i] + " ");
    }
  } 

  public static void main(String[] args) { 
    Scanner input = new Scanner(System.in);
    System.out.print("Enter number of elements in the first array: ");
    int number = input.nextInt();  
    int array[] = new int[number];
		
    System.out.println();	
    System.out.print("Please enter the elements in the array: ");
    for (int i = 0; i < array.length; i++) {
      array[i] = input.nextInt();
    }
	  
    int firstElement = array[0];
		
    findProductWithoutCurrentElement(array);
    System.out.println();	 
    findProductWithoutCurrentElement1(array);
  }
}
