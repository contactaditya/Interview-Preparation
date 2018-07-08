import java.util.*;
import java.io.*;

  public class AllPossibleCombinationsOfKNumbersInSortedForm { 
	  	
	public static ArrayList<ArrayList<Integer>> combine1(int n, int k) {       
	  ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
	  combine(combinations, new ArrayList<Integer>(), 1, n, k);
	  return combinations;
	}	

	private static void combine(ArrayList<ArrayList<Integer>> combinations, ArrayList<Integer> list, int start, int n, int k) {
	  if(k == 0) {
		combinations.add(new ArrayList<Integer>(list));
		return;
	  }
	  for(int i = start; i<=n; i++) {
		list.add(i);
		combine(combinations, list, i+1, n, k-1);
		list.remove(list.size()-1);		
	  }
	}
	
	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the total numbers: ");
	  int number = input.nextInt();  
	  System.out.println();	
	  System.out.print("Enter the number of combinations: ");
	  int k = input.nextInt();  
	  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	  result = combine1(number, k);
	  System.out.println();
	  System.out.println("A solution set is: ");
	  System.out.println('[');
	  for(List<Integer> innerList : result) {
		System.out.println(innerList + " ");
	  }
	  System.out.println(']');
	}
  }
