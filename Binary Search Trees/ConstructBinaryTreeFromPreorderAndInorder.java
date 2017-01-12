import java.util.*;

 public class ConstructBinaryTreeFromPreorderAndInorder {   
	Node root;	    
	static int preIndex = 0;

 public Node buildTree(int inOrder[], int preOrder[], int inStart, int inEnd) {
	
   if (inStart > inEnd) {
      return null;  
   } 
   
   // Pick current node from Preorder traversal using preIndex and increment preIndex 
   
   Node node = new Node(preOrder[preIndex++]);
	 
   // If this node has no children then return 
   
   if (inStart == inEnd) {
	  return node;  
   } 
   
   // Else find the index of this node in Inorder traversal 
   
   int inOrderIndex = search(inOrder, inStart, inEnd, node.data);
   
   // Using index in Inorder traversal, construct left and right subtress 
   
   node.left = buildTree(inOrder, preOrder, inStart, inOrderIndex - 1);
   node.right = buildTree(inOrder, preOrder, inOrderIndex + 1, inEnd);
    
	return node;
 }
 
 public int search(int [] inOrder, int start, int end, int data) {
	 
	for(int i = start; i <= end; i++) {
	  if (inOrder[i] == data) {
         return i;  
	  }
	}
   return -1;
  }

 public void printInorderTraversal(Node node) {
	 
    if (node == null) {
	  return;
	}
	 
	printInorderTraversal(node.left);
	System.out.print(node.data + " ");	
	printInorderTraversal(node.right);
 }

	public static void main(String[] args) {
	  ConstructBinaryTreeFromPreorderAndInorder tree = new ConstructBinaryTreeFromPreorderAndInorder();	
	  int [] inOrder = {2,5,6,10,12,14,15};
	  int [] preOrder = {10,5,2,6,14,12,15};
	  int length = inOrder.length;
	  
	  Node node = tree.buildTree(inOrder, preOrder, 0, length-1);
	  
	  System.out.print("Inorder traversal of constructed tree is: ");
	  tree.printInorderTraversal(node);		
	  
	}
}
