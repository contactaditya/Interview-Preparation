import java.util.*;
import java.io.*;

  public class AllPossibleCombinationsOfKNumbers {
	  
    public static List<List<Integer>> combine(int n, int k) {
       List<List<Integer>> result = new ArrayList<List<Integer>>();		
       if (k > n || k < 0) {
         return result;
       }	
       if (k == 0) {
         result.add(new ArrayList<Integer>());
         return result;
       }
       result = combine(n-1, k-1);
       for (List<Integer> list : result) {
         list.add(n);
       }
		
       result.addAll(combine(n - 1, k));
       return result;    
    }
    
    public static List<List<Integer>> combine1(int n, int k) {
       List<List<Integer>> combinations = new ArrayList<List<Integer>>();
       combine(combinations, new ArrayList<Integer>(), 1, n, k);
       return combinations;
    }	

    private static void combine(List<List<Integer>> combinations, ArrayList<Integer> list, int start, int n, int k) {
       if(k==0) {
	  combinations.add(new ArrayList<Integer>(list));
          return;
       }
       for(int i=start;i<=n;i++) {
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
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      result = combine(number, k);
      System.out.println();
      System.out.println("A solution set is: ");
      System.out.println('[');
      for(List<Integer> innerList : result) {
	System.out.println(innerList + " ");
      }
      System.out.println(']');
    }
  }
