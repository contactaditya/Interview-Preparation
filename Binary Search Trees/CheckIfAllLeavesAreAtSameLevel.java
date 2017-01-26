import java.util.*;

 public class CheckIfAllLeavesAreAtSameLevel { 
     Node root;	    
     Node previous;

  public boolean checkIfAllLeavesAreAtSameLevel(Node node) {
     int currentLevel = 0;
     int previousLevel = 0;
     return checkIfAllLeavesAreAtSameLevelUtil(node, currentLevel, previousLevel);
  }
  
  public boolean checkIfAllLeavesAreAtSameLevelUtil(Node node, int currentLevel, int previousLevel) {
     if (node == null) {
       return true;
     }
	 
   // If a leaf node is encountered 	 
     if (node.left == null && node.right == null) {
       if(previousLevel == 0) {
	  previousLevel = currentLevel; 
          return true;
       } 
   // If this is not first leaf node, compare its level with first leaf's level	   
		 	 
       return (currentLevel == previousLevel);
     }
		 	  
   // If this node is not leaf, recursively check left and right subtrees 	  
    return checkIfAllLeavesAreAtSameLevelUtil(node.left, currentLevel + 1, previousLevel) && checkIfAllLeavesAreAtSameLevelUtil(node.right, currentLevel + 1, previousLevel);
  }
	
  public static void main(String[] args) {    
     CheckIfAllLeavesAreAtSameLevel tree = new CheckIfAllLeavesAreAtSameLevel(); 
     tree.root = new Node(12);
     tree.root.left = new Node(5);
     tree.root.left.left = new Node(3);
     tree.root.left.right = new Node(9);
     tree.root.left.left.left = new Node(1);
     tree.root.left.right.left = new Node(1);
	  
      if (tree.checkIfAllLeavesAreAtSameLevel(tree.root)) {
         System.out.println("Leaves are at same level");
      }
      else {
         System.out.println("Leaves are not at same level");
      }
   }
}
