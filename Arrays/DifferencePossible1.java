import java.util.*;

  public class DifferencePossible1 {
	  
	private static int diffPossible1(ArrayList<Integer> list, int value) {      
      for (int i = 0; i < list.size(); i++) {
        for (int j = 0; j < list.size(); j++) {
          if(i == j) {
	        continue;
	      }
	      if(list.get(i) - list.get(j) == value) {
	        return 1;
	      }	    
        }  
      }
				
	  return 0;
    }	  
	
	private static int diffPossible(ArrayList<Integer> list, int value) {      
	  HashSet<Integer> visited = new HashSet<Integer>();
	  for (Integer number : list) {
	    if (visited.contains(number + value) || visited.contains(number - value)) {
	      return 1;
	    }
	    visited.add(number);
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
