import java.util.*;
import java.io.*;

  class BSTNode1 {
    public int data;
    public int count = 1;
    public BSTNode1 left;
    public BSTNode1 right;

    //Node constructor
    
    public BSTNode1(int value) {
      data = value;
    }
  }

  public class CountOfSmallerNumbersAfterSelfInAnArray {
	  
    public static List<Integer> countSmaller(int[] array) {
      List<Integer> result = new ArrayList<>();
      if(array == null || array.length == 0) {
	return result;	
      }
	  
      BSTNode1 root = new BSTNode1(array[array.length - 1]);
      result.add(0);
      for(int i = array.length - 2; i >= 0; i--) {
        int count = insertNode(root, array[i]);
        result.add(count);
      }
	  
      Collections.reverse(result);
      return result;     
    }	  
	  
    private static int insertNode(BSTNode1 root, int value) {
      int thisCount = 0;
      while(true) {
        if(value <= root.data) {
	  root.count++;
	  if(root.left == null) {
	    root.left = new BSTNode1(value); 
	    break;
	  } else {
	    root = root.left;
	  }
	} else {
	  thisCount += root.count;
	  if(root.right == null) {
	    root.right = new BSTNode1(value); 
	    break;
	  } else {
	    root = root.right;
	  }
	}
      }
      return thisCount;
    }

    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int numbers = input.nextInt();   
      int array[] = new int[numbers];
		    
      System.out.println();
      System.out.print("Please enter the actual values in the array: ");
      for (int i = 0; i < numbers; i++) {
	array[i] = input.nextInt(); 
      }
		   		   
      List<Integer> result = new ArrayList<Integer>();	   
      result = countSmaller(array); 
		   
      System.out.println();
      System.out.println("The array containing number of smaller elements to the right of array[i] is: " + result);
    }
  }
