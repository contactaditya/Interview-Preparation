import java.util.Scanner;

public class RightRotation {

   public static void main(String[] args) { 
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of elements in the array: ");
      int lengthOfArray = input.nextInt();
      int[] array1 = new int[lengthOfArray];    
      System.out.println();	
      System.out.print("Enter the number of rotations in the array: ");
      int numberOfRotations = input.nextInt();
      System.out.println();	
      System.out.print("Please enter the elements in the array: ");
      for(int i=0;i<lengthOfArray;i++) {  
         array1[i] = input.nextInt();
      } 
	 
      int[] array2 = new int[lengthOfArray];   
	    
      for(int i=0;i<lengthOfArray;i++) {
         array2[(i+numberOfRotations)%lengthOfArray] = array1[i];  
      }
	  
      System.out.println();
      System.out.print("The array after rotation in the right direction is: ");  
      for(int i=0;i<lengthOfArray;i++) {     
         System.out.print(array2[i] + " ");
      }
   }
}
