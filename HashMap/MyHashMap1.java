import java.util.*;
import java.io.*;

  class HashItem {
    public HashItem next;
    public int key;
    public int value;

    // HashItem constructor
    public HashItem(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
  
  public class MyHashMap1 {
    private HashItem[] list;
	private int size;	  
	  
	/** Initialize your data structure here. */
	public MyHashMap1() {  
	  list = new HashItem[16];
	}
	
	/** value will always be non-negative. */
    public void put(int key, int value) {  
      int hash = key % list.length;
      if (list[hash] == null) {
        list[hash] = new HashItem(key, value);
      }
      else if (list[hash].key == key) {
        list[hash].value = value;
      } 
      else {
        HashItem current = list[hash];
        while (current.next != null && current.next.key != key) { 
          current = current.next;
        }
        if (current.next != null) { 
          current.next.value = value;
        }
        else {
          current.next = new HashItem(key, value);
        }
      }
      size += 1;
      if (size * 1.0 / list.length > 0.8) {
        rehash();
      }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
      int hash = key % list.length;
      HashItem current = list[hash];	
      while (current != null) {
        if (current.key == key) {
          return current.value;
        }
        current = current.next;
      }
      return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {  
      int hash = key % list.length;
      if (list[hash] == null) {
        return;
      }
      else if (list[hash].key == key) {
        list[hash] = list[hash].next;
      }
      else {
        HashItem current = list[hash];
        while (current.next != null && current.next.key != key) {
          current = current.next;
        }
        if (current.next != null) { 
          current.next = current.next.next;
        }
      }   
    }
    
    private void rehash() {
      HashItem[] oldList = list;
      list = new HashItem[list.length * 2];
      for (int i = 0; i < oldList.length; i++) {
        HashItem current = oldList[i];
        while (current != null) {
          put(current.key, current.value);
          current = current.next;
        }
      }
    }
	     
	public static void main(String[] args) throws IOException {   
	  int choice = 0;
	  MyHashMap1 hashmap = new MyHashMap1();
	    
	   do{	
		   System.out.println("1. For inserting an element in the HashMap.");
		   System.out.println("2. For checking if the HashMap contains a specific key.");
		   System.out.println("3. For deleting an element from the HashMap.");
		   System.out.println("4. For exiting from the program.");
 
		   System.out.println();
		   System.out.print("Enter your choice: ");
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		   choice = Integer.parseInt(br.readLine());
		   switch (choice) {
		  	 case 1:  System.out.println();
 	  	   		      System.out.print("Enter the key that you want to insert in the HashMap: ");
	   		  		  int key = br.read();
	   		  		  System.out.println();
	   		  	      br.readLine();
	   		  		  System.out.print("Enter the value that you want to insert in the HashMap: ");
	   		  		  int value = br.read();
	   		  		  hashmap.put(key, value);
 	  	   		      break;  
 	  	   		      
		  	 case 2:  System.out.println();
	   		  		  System.out.print("Enter the key whose value you want to return from the HashMap: ");
	   		  		  int key1 = br.read();
	   		  		  int value1 = hashmap.get(key1);
	   		  		  System.out.println();  
	   		  		  if(value1 == -1) { 
	   		  		    System.out.println("This map contains no mapping for the key.");    
	   		  		  } else {
	   		  		    System.out.println("The value to which the specified key is mapped is: " + value1);
	   		  		  }
	         		  break;     
 	  	   		      
		  	 case 3:  System.out.println(); 
		  		      System.out.print("Enter the key whose mapping you want to remove for the value key: ");
		  		      int key2 = br.read();
		  		      hashmap.remove(key2);
   	   		          break;
         }
		 System.out.println(); 
	   } while(choice != 4);
	 }
   }
  
