import java.util.*;
import java.io.*;

  public class MedianOfTwoSortedArrays {
	  
    public static double findMedianSortedArrays(int[] array1, int[] array2) {  
      if (array1 == null || array1.length == 0){
        return findMedianSortedArrays(array2);             
      }
      if (array2 == null || array2.length == 0){
        return findMedianSortedArrays(array1);             
      }
      int l1 = array1.length;
      int l2 = array2.length;
      int l = l1 + l2;
      int array[] = new int[l];
      int p = l1 - 1, q = l2 - 1, i = l - 1;
      while (p >= 0 && q >= 0) {
        if (array1[p] > array2[q]) {
          array[i--] = array1[p--];
        } else {
          array[i--] = array2[q--];
        }
      }
      while (p >= 0) {
	array[i--] = array1[p--];
      } 
      while (q >= 0) {
    	array[i--] = array2[q--];
      }
      
      if (l % 2 != 0) {
        return array[l/2];
      } else {
        return(array[l/2 - 1] + array[l/2]) / 2.0;
      }    
    }	  

    private static double findMedianSortedArrays(int[] array) {
      int l = array.length;
      if (l % 2 != 0) {
        return array[l/2];
      } else {
        return (array[l/2 - 1] + array[l/2])/ 2.0;
      }
    }

    public static void main(String[] args) { 	
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the first array: ");
      int number = input.nextInt();  
      int array1[] = new int[number];
	  
      System.out.println();	
      System.out.print("Please enter the actual values in the array: ");
      for (int i = 0; i < array1.length; i++) {
	array1[i] = input.nextInt();
      }
	  
      Arrays.sort(array1);
	   
      System.out.println();	
      System.out.print("Enter number of elements in the second array: ");
      int number1 = input.nextInt();  
      int array2[] = new int[number1];
	  
      System.out.println();	
      System.out.print("Please enter the actual values in the array: ");
      for (int i = 0; i < array2.length; i++) {
	array2[i] = input.nextInt();
      }
	  
      Arrays.sort(array2);  
	  
      double result = findMedianSortedArrays(array1, array2);
      System.out.println();	
      System.out.print("The median of the two sorted arrays is: " + result);
    }
  }
