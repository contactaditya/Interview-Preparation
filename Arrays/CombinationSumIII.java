import java.util.*;
import java.io.*;

 public class CombinationSumIII {
	 
	public static List<List<Integer>> combinationSum3(int k, int n) {  
	  List<List<Integer>> result = new ArrayList<List<Integer>>();	
	  combination(result, new ArrayList<Integer>(), k, 1, n);
	  return result;          
	}	 

	private static void combination(List<List<Integer>> result, ArrayList<Integer> combination, int k, int start, int n) {
	  if (combination.size() > k) {
	    return;
	  }
	  if (combination.size() == k && n == 0) {
        List<Integer> list = new ArrayList<Integer>(combination);
        result.add(list);
        return;
      }
	  for (int i = start; i<=9; i++) {
        if (n-i >= 0) {
          combination.add(i);
          combination(result, combination, k, i+1, n-i);
          combination.remove(combination.size() - 1);
        }
      }
	}

	public static void main(String[] args) { 	   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the combination: ");
	  int k = input.nextInt();  

	  System.out.println();	
	  System.out.print("Enter the number that the elements add upto: ");
	  int n = input.nextInt();  
		
	  System.out.println();
	  List<List<Integer>> result = new ArrayList<List<Integer>>();	
	  result = combinationSum3(k, n); 
	  System.out.println();
	  System.out.println("The solution set is: ");
	  System.out.println('[');
	  for(List<Integer> innerList : result) {
		System.out.println(innerList + " ");
	  }
	  System.out.println(']');
	}
 }
