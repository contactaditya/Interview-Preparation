import java.util.*;
import java.io.*;

  public class ThreeSum {
	  
    public static List<List<Integer>> threeSum(int[] array) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();	
      if(array == null || array.length<0) {
        return result;
      }
      Arrays.sort(array);
      for(int i=0; i<array.length-2; i++) {
    	if(i==0 || array[i] > array[i-1]) {
    	  int j = i + 1;
    	  int k = array.length - 1;
    	  while(j<k){
            if(array[i]+array[j]+array[k]==0) {
              List<Integer> list = new ArrayList<Integer>();
              list.add(array[i]);
              list.add(array[j]);
              list.add(array[k]);
              result.add(list);

              j++;
              k--;

              //handle duplicate here
              while(j<k && array[j]==array[j-1]) {
                j++;
              }
              while(j<k && array[k]==array[k+1]) {
                 k--;
              }
            }
            else if(array[i]+array[j]+array[k] < 0) {
              j++;	
            }
            else {
              k--;	
            }
    	  }
    	}
      }
      return result;
    }	

    public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int numbers = input.nextInt();   
      int array[] = new int[numbers];
	    
      System.out.print("\n");
      System.out.print("Please enter the actual values in the array: ");
      for (int i = 0; i < numbers; i++) {
	array[i] = input.nextInt(); 
      }
	   
      System.out.println();
      List<List<Integer>> result = new ArrayList<List<Integer>>();
	   
      result = threeSum(array); 
      System.out.println();
      System.out.println("A solution set is: ");
      System.out.println('[');
      for(List<Integer> innerList : result) {
	System.out.println(innerList + " ");
      }
      System.out.println(']');
    }
 }
