import java.util.*;

  public class DifferencePossible {
	  
    public static int diffPossible(ArrayList<Integer> list, int value) {
      // Initialize positions of two elements
      int i = 0, j = 1;
 
      // Search for a pair
      while (i < list.size() && j < list.size()) {
        if (i != j && list.get(j) - list.get(i) == value) {
          return 1;
        }
        else if (list.get(j) - list.get(i) < value) {
          j++;
        }
        else {
          i++;
        }
      }
	  
      return 0;
    }	  

    public static void main(String[] args) {    
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the list: ");
      int number = input.nextInt();  
      ArrayList<Integer> list = new ArrayList<Integer>();	
			
      System.out.println();	
      System.out.print("Please enter the elements of the list: ");
      for (int i = 0; i < number; i++) {
	list.add(input.nextInt());
      }
      
      System.out.println();	
      System.out.print("Enter a value which remove all the instances of that place in the array: ");
      int value = input.nextInt();  
	  
      input.close();
      
      int differencePossible = diffPossible(list, value);
      System.out.println();	
      if(differencePossible == 1) {
        System.out.print("Yes there are 2 indices i and j such that A[i] - A[j] = " + value + ", i != j");
      }
      else {
    	System.out.print("No there are no 2 indices i and j such that A[i] - A[j] = " + value + ", i != j");  
      }
    }
  }
