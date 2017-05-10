import java.io.*;
import java.util.*;

 public class FourSum {   
	 
   public static List<List<Integer>> fourSum(int[] array, int target) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
	 
      if (array == null || array.length < 4) {
	 return result;
      }
	  
      // Sort the array
      Arrays.sort(array);
      for (int i = 0; i < array.length - 3; i++) {
    	 if(i != 0 && array[i] == array[i-1]) {
            continue;
    	 }
    	 for (int j = i+1; j < array.length - 2; j++) {
    	    if(j != i+1 && array[j] == array[j-1]) {
               continue;
    	    }
    	   int low = j + 1 , high = array.length-1;

    	   while (low < high) {
    	      int sum = array[i] + array[j] + array[low] + array[high];	 
    	      if(sum < target) {
                 low++;
              } else if(sum > target){
                 high--;
              } else {
    		 List<Integer> current = new ArrayList<Integer>();	
    		 current.add(array[i]);
                 current.add(array[j]);
                 current.add(array[low]);
                 current.add(array[high]);
                 result.add(current);
               
                 low++;
                 high--;
                   			                  
               while (low < high && array[high] == array[high + 1]) { 
                  high--; 
               }
               while (low < high && array[low] == array[low - 1]) {
                  low++; 
               }			   
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
      System.out.print("Enter the value of the target you want to check in the array: ");
      int target = input.nextInt();  
	   
      List<List<Integer>> result = new ArrayList<List<Integer>>();
	   
      result = fourSum(array, target); 
	   
      System.out.println();
      System.out.println("A solution set is: ");
      System.out.println('[');
      for(List<Integer> innerList : result) {
	 System.out.println(" " + innerList);
      }
      System.out.println(']');
     }  
   }
