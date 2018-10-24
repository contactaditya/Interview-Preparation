import java.util.*;
import java.io.*;

  public class LinkedListRandomNode {  
    private static LinkedListNode head;
    Random random;
    
    public LinkedListRandomNode (LinkedListNode head) {
      this.head = head;       
      random = new Random();        
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
      LinkedListNode current = head;
      int r = (int)current.data;
      for(int i=1; current.next != null; i++) {       
        current = current.next;
        if(random.nextInt(i + 1) == i) {
          r = (int)current.data;                        
        }
      }      
      return r;	
    }
    
    public static void main(String[] args) {   
      LinkedListRandomNode list = new LinkedListRandomNode(head);
      list.head = new LinkedListNode(1);
      list.head.next = new LinkedListNode(2);
      list.head.next.next = new LinkedListNode(3);

      int randomValue = list.getRandom();
      System.out.print("The random's node value from the linked list is: " + randomValue);	 
    }
  }
