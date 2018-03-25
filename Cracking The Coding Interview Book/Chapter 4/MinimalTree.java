import java.util.*;

 public class MinimalTree {    
   static Node root;	    
   static Node previous;

   public Node createMinimalBST(int array[]) {
     return createMinimalBST(array, 0, array.length - 1);		 
   }
 
   public Node createMinimalBST(int array[], int start, int end) {
     if(end < start) {
       return null;	
     }
	 
     int mid = (start + end) / 2;
     Node newNode = new Node(array[mid]);
     newNode.left = createMinimalBST(array, start, mid - 1);
     newNode.right = createMinimalBST(array, mid + 1, end);
	 
     return newNode;		  
   }

   public static void main(String[] args) {	 
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the number of elements in the array: ");
     int n = input.nextInt();
     int array[] = new int[n];
     System.out.println();	
     System.out.print("Please enter the elements in the array: ");
     for(int i=0; i < n; i++) {
       array[i] = input.nextInt();
     }
	  
     MinimalTree tree = new MinimalTree();
     TreePreorderTraversal tree1 = new TreePreorderTraversal();

     root = tree.createMinimalBST(array);		
     System.out.println();
     System.out.print("The preorder traversal of the tree is: ");
     tree1.printPreorderTraversal(tree.root);	
   }
 }
