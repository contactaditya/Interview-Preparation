import java.util.Scanner;

public class MatrixChainMultiplication {
 
 public static int MatrixChainMultiplication(int dimensions[]) {
    int m[][] = new int[dimensions.length][dimensions.length]; 
    int s[][] = new int[dimensions.length][dimensions.length]; 
    int n = dimensions.length;
  
    // The cost is zero when multiplying one matrix
    for (int i = 1; i < n; i++) {
      m[i][i] = 0;
    }
	 
    for(int length = 2; length < n; length++) {
      for(int i = 1; i < n-length+1; i++) {
         int j = i + length - 1;
         if(j == n) continue;
         m[i][j] = Integer.MAX_VALUE;
         for(int k = i; k < j; k++) {
           int cost = m[i][k] + m[k+1][j] + dimensions[i-1]*dimensions[k]*dimensions[j]; 
           if (cost < m[i][j]) {
             m[i][j] = cost;
             // Index of the subsequence split that achieved minimal cost    
             s[i][j] = k;
           }	   
         } 
      }
    }
  return m[1][n-1];
}

 public static void main(String[] args) { 
    Scanner input = new Scanner(System.in);
    System.out.print("Enter number of elements in the array: ");
    int number = input.nextInt();  
    int dimensions[] = new int[number];
			
    System.out.println();	
    System.out.print("Please enter the elements in the array: ");
    for (int i = 0; i < dimensions.length; i++) {
      dimensions[i] = input.nextInt();
    }
		  
    int minimumCost = MatrixChainMultiplication(dimensions);
  
    System.out.println();	
    System.out.println("The minimum number of multiplications needed to multiply the chain is: " + minimumCost);
			
  }
}
