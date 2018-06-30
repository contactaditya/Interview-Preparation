import java.util.*;
import java.io.*;

  public class SubsetsWithDuplicatesInAnArraylist { 
	  
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> list) {    
	  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();	
	  if(list == null) {
		return null;
	  }	
		  
      Collections.sort(list);
	  dfs(list, 0, new ArrayList<Integer>(), result);
	  return result;      
	}
		  
	private static void dfs(List<Integer> list, int start, List<Integer> arrayList, ArrayList<ArrayList<Integer>> result) {
	  result.add(new ArrayList<Integer>(arrayList));
	  for(int i = start; i < list.size(); i++) {
		if(i > start && list.get(i) == list.get(i-1)) {
		  continue; // skip duplicates  
		}
		arrayList.add(list.get(i));
		dfs(list, i + 1, arrayList, result);
		arrayList.remove(arrayList.size() - 1);
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
      result = subsetsWithDup(list);
      System.out.println();
	  System.out.println("The solution set is: ");
	  System.out.println('[');
	  for(List<Integer> innerList : result) {
		System.out.println(innerList + " ");
	  }
	  System.out.println(']');
	}
  }
