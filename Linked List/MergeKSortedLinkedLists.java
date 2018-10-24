import java.util.*;
import java.io.*;

  public class MergeKSortedLinkedLists { 	
    private static LinkedListNode head;
    private static LinkedListNode head1;
    private static LinkedListNode head2;
    private static LinkedListNode head3;
    private static int size;
	
    public MergeKSortedLinkedLists() {
      // this is an empty list, so the reference to the head node is set to a new node with no data				  
      head = new LinkedListNode(null);
      size = 0;
    } 
	
    public LinkedListNode mergeKLists(ArrayList<LinkedListNode> lists) {
      if(lists==null||lists.size()==0) {
	return null;	
      }
	   
      java.util.PriorityQueue<LinkedListNode> queue = new java.util.PriorityQueue<LinkedListNode>(new Comparator<LinkedListNode>() {
	public int compare(LinkedListNode list1, LinkedListNode list2) {
	  return (int)list1.data - (int)list2.data;
	}
      });
	   
      LinkedListNode head = new LinkedListNode(0);
      LinkedListNode p = head;
	 
      for(LinkedListNode list: lists){
	if(list!=null) {
	  queue.offer(list);
        }
      }
	   
      while(!queue.isEmpty()) {
        LinkedListNode n = queue.poll();
	p.next = n;
	p = p.next;
	 
	if(n.next!=null) {
	  queue.offer(n.next);
        }
      }    
		
      return head.next;
    }
	
    public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
      LinkedListNode current = head; 
      while(current != null) {	   
	System.out.print(current.getData() + " ");	 	
	current = current.getNext();
      }
    } 	
	 
    public static void main(String[] args) {
      MergeKSortedLinkedLists list = new MergeKSortedLinkedLists();	
      ArrayList<LinkedListNode> lists = new ArrayList<LinkedListNode>();
      list.head1 = new LinkedListNode(1);
      list.head1.next = new LinkedListNode(3);
      list.head1.next.next = new LinkedListNode(5);
      list.head1.next.next.next = new LinkedListNode(7);
	 
      lists.add(list.head1);
	    
      list.head2 = new LinkedListNode(2);
      list.head2.next = new LinkedListNode(4);
      list.head2.next.next = new LinkedListNode(6);
      list.head2.next.next.next = new LinkedListNode(8);
	 
      lists.add(list.head2);

      list.head3 = new LinkedListNode(0);
      list.head3.next = new LinkedListNode(9);
      list.head3.next.next = new LinkedListNode(10);
      list.head3.next.next.next = new LinkedListNode(11);	
	  
      lists.add(list.head3);
	  
      head = list.mergeKLists(lists); 
      System.out.print("Contents of the linked list after sorting are: ");	 
      list.PrintElementsOfALinkedList(head);		
    }
  }
