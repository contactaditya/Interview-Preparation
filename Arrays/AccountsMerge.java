import java.util.*;
import java.io.*;

  public class AccountsMerge {
	  
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {  
      int n = accounts.size(); //how many group at most
      int[] union = new int[n];
      Arrays.fill(union, -1); 
	  
      Map<String, Integer> e2g = new HashMap<String, Integer>();
      for (int i = 0; i < n; i++) {
        union[i] = i; //initialized as itself
        List<String> emails = accounts.get(i);
        for (int j = 1; j < emails.size(); j++) {
          String email = emails.get(j);
          if(e2g.getOrDefault(email, -1) == -1) {
            e2g.put(email, i);
          } else {
        	int pr = find(e2g.get(email), union);
            union[union[i]] = pr; //so {a,b} {c,d} {b,c} can be combined as the same group
            union[i] = pr;
          }
        }
      }
      ArrayList<String>[] ans = new ArrayList[n];
      for(String key : e2g.keySet()) {
        int value = e2g.get(key);
        int root = find(value, union);
        if(ans[root] == null) {
          ans[root] = new ArrayList<String>();
        }
        ans[root].add(key);
      }
      List<List<String>> result = new ArrayList<List<String>>();
      for(int i = 0; i < n; i++) {
        if(ans[i] == null) {
    	  continue;
        }
        List<String> item = new ArrayList<String>();
        item.add(accounts.get(i).get(0));
        Collections.sort(ans[i]);            
        item.addAll(ans[i]);
        result.add(item);
      }
      
      return result;
    }  

    private static int find(int x, int[] union) {
      while(x != union[x]) {
	x = union[x];
	union[x] = union[union[x]];
      }
      return x;
    }

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the total number of accounts: ");
      int numberofAccounts = input.nextInt();   
      input.nextLine();
		 	   
      List<List<String>> accounts = new ArrayList<List<String>>();
      for (int i = 0; i < numberofAccounts; i++) {
	List<String> account = new ArrayList<String>();  
	System.out.println(); 
	System.out.print("Please enter the number of entries in the account: ");	  
	int numberofEntries = input.nextInt();  
	System.out.println(); 
	input.nextLine();
	System.out.println("Please enter the actual values of entries in the account: ");	
	for (int j = 0; j < numberofEntries; j++) {
	  account.add(input.nextLine());
	} 
	accounts.add(account);
      }
	   	   
      List<List<String>> result = new ArrayList<List<String>>();
	   
      result = accountsMerge(accounts); 
	   
      System.out.println();
      System.out.println("A solution set is: ");
      System.out.println('[');
      for(List<String> innerList : result) {
        System.out.println(" " + innerList);
      }
      System.out.println(']');
    }
  }
