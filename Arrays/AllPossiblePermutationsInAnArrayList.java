import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

  public class AllPossiblePermutationsInAnArrayList { 	
	 
	public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> list) { 
      ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();	
	  if (list == null || list.size() == 0) {
	    return result;
	  }
	  Collections.sort(list);
	  backtrack(result, new ArrayList<Integer>(), list, new boolean[list.size()]);	
	  return result;    
	}	 

	private static void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> array, boolean[] used) {
	  if(list.size() == array.size()) {
	    result.add(new ArrayList<Integer>(list));
	  } 
	  else {
	    for(int i = 0; i < array.size(); i++) { 
	      if(used[i] || i > 0 && array.get(i) == array.get(i - 1) && !used[i - 1]) {
		    continue; // This element already exists, skips
		  }
		  used[i] = true; 
		  list.add(array.get(i));
		  backtrack(result, list, array, used);
		  used[i] = false; 
	      list.remove(list.size() - 1);
	    }
	  }
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
		  
      ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
      result = permute(list);
      System.out.println();
      System.out.println("A solution set is: ");
      System.out.println('[');
      for(List<Integer> innerList : result) {
        System.out.println(innerList + " ");
      }
      System.out.println(']');
	}
  }


