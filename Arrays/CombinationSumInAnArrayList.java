import java.util.*;
import java.io.*;

  public class CombinationSumInAnArrayList { 	
	  
	public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> list, int target) {
	  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();	
	  HashSet<ArrayList<Integer>> set = new  HashSet<ArrayList<Integer>>();
	  if(list == null || list.size() < 0) {
	    return result;
	  }
	  Collections.sort(list);
	  backtrack(result, new ArrayList<Integer>(), list, target, 0, set);	
	  
	  return result;
	}

	private static void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tempList, ArrayList<Integer> list, int remain, int start, HashSet<ArrayList<Integer>> set) {
	  if(remain < 0) {
	    return; 
	  }
	  else if(remain == 0) {
		ArrayList<Integer> temp = new ArrayList<Integer>(tempList);
		if(!set.contains(temp)) {
          set.add(temp);
          result.add(temp);
        }
		
		return;
	  }
	  else {
	    for(int i = start; i < list.size(); i++) {
	  	  tempList.add(list.get(i));
	  	  backtrack(result, tempList, list, remain - list.get(i), i, set); // not i + 1 because we can reuse same elements
	  	  tempList.remove(tempList.size() - 1);
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
		  
	  Collections.sort(list);
	  
	  System.out.println();	
	  System.out.print("Enter the sum that you want to check whether it is present array or not: ");
	  int target = input.nextInt();  
		  
	  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();	
	  result = combinationSum(list, target); 
	  System.out.println();
	  System.out.println("A solution set is: ");
	  System.out.println('[');
	  for(List<Integer> innerList : result) {
		System.out.println(innerList + " ");
	  }
	  System.out.println(']');
	}
  } 
