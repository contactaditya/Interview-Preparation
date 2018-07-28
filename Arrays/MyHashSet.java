import java.util.*;
import java.io.*;

  public class MyHashSet {
	private int buckets = 1000;
	private int itemsPerBucket = 1001;
	private boolean[][] table;
	
	/** Initialize your data structure here. */
	public MyHashSet() {
	  table = new boolean[buckets][];
	}
	
	public int hash(int key) {
	  return key % buckets;
	}
	
	public int position(int key) {
	  return key/buckets;
	}
	    
	public void add(int key) {
	  int hashkey = hash(key);
	  if (table[hashkey] == null) {
	    table[hashkey] = new boolean[itemsPerBucket];
	  }
	  table[hashkey][position(key)] = true;
	}
	    
	public void remove(int key) {
	  int hashkey = hash(key);
	  if (table[hashkey] != null) {
		table[hashkey][position(key)] = false;
	  }
	}
	    
	/** Returns true if this set did not already contain the specified element */
	public boolean contains(int key) {
	  int hashkey = hash(key);
	  return table[hashkey] != null && table[hashkey][position(key)];
    }	  

	public static void main(String[] args) throws IOException { 	 
	  int choice = 0;
	  MyHashSet hashset = new MyHashSet();
	    
	   do{	
		   System.out.println("1. For inserting an element in the HashSet.");
		   System.out.println("2. For checking if the HashSet contains a specific value.");
		   System.out.println("3. For removing a value in the HashSet.");
		   System.out.println("4. For exiting from the program.");

		   System.out.println();
		   System.out.print("Enter your choice: ");
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		   choice = Integer.parseInt(br.readLine());
		   switch (choice) {
		  	 case 1:  System.out.println();
	   		  		  System.out.print("Enter the value that you want to insert in the HashSet: ");
	   		  		  int value = br.read();
	   		  		  hashset.add(value);
	  	   		      break;  
	  	   		      
		  	 case 2:  System.out.println();
	   		  		  System.out.print("Enter the value that you want to check is present in the HashSet: ");
	   		  		  value = br.read();
	   		  		  boolean result = hashset.contains(value);
	   		  		  System.out.println();  
	   		  		  if(result) { 
	   		  		    System.out.println("This value exists in the HashSet.");    
	   		  		  } else {
	   		  		    System.out.println("This value does not exist in the HashSet.");
	   		  		  }
	         		  break;     
	  	   		      
		  	 case 3:  System.out.println(); 
		  		      System.out.print("Enter the value that you want to remove from the HashSet: ");
		  		      value = br.read();
		  		      hashset.remove(value);
  	   		          break;
        }
		 System.out.println(); 
	   } while(choice != 4);
	 }
   }

