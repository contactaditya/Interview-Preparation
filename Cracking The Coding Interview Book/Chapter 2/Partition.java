import java.util.*;

 public class Partition { 	
    private static LinkedListNode head;
    private static int size;  

    public Partition() {
      // this is an empty list, so the reference to the head node is set to a new node with no data				  
      head = new LinkedListNode(null);
      size = 0;
    }
	
    public static LinkedListNode partition(LinkedListNode node, int x) {
      LinkedListNode head = node;
      LinkedListNode tail = node;
			     
      while(node != null) {    
	LinkedListNode next = node.next;
        if((int)node.data < x) {
          // Insert node at head
          node.next = head;
          head = node;
        } else {
          // Insert node at tail
          tail.next = node;
          tail = node;   	 
        }
        node = next;
      }
	   
      tail.next = null;
	   
      return head;
    }

    public static void main(String[] args) {   
      Partition list = new Partition();
      list.head = new LinkedListNode(3);
      list.head.next = new LinkedListNode(5);
      list.head.next.next = new LinkedListNode(8);
      list.head.next.next.next = new LinkedListNode(5);
      list.head.next.next.next.next = new LinkedListNode(10);
      list.head.next.next.next.next.next = new LinkedListNode(2);
      list.head.next.next.next.next.next.next = new LinkedListNode(1);
	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the value of the partition in the linked list: ");
      int value = input.nextInt();  
	     	     
      LinkedListNode current = list.partition(head, value);
	  
      if(current == null) {
	System.out.println("The element is not present in the linkedlist. There is no partition in the linkedlist.");  
      }
      else {
	System.out.println();  
	System.out.print("Contents of the linked list are: ");	 
	while(current != null) {	   
	  System.out.print(current.getData() + " ");	 	
	  current = current.getNext();
	}
      }
    }
}
