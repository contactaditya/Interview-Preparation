import java.util.*;
import java.io.*;

  public class CheapestFlightsWithinKStops {
	  
    public static int findCheapestPrice(int n, int[][] flights, int source, int destination, int K) {
      int[] distance = new int[n];
      int[] pre = new int[n]; // smallest distance to that node within T stops
      Arrays.fill(distance, Integer.MAX_VALUE/2);
      Arrays.fill(pre, Integer.MAX_VALUE/2);	
      distance[source] = pre[source] = 0;
      
      for (int i = 0; i <= K; i++) {
        for (int[] edge: flights) {
          distance[edge[1]] = Math.min(distance[edge[1]], pre[edge[0]] + edge[2]);
        }

        pre = distance;
      }
    	
      return distance[destination] < Integer.MAX_VALUE / 2 ? distance[destination] : -1;     
    }  

	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Please enter the cities connected by m flights: ");
	  int n = input.nextInt();  
	  System.out.println();
	  System.out.print("Please enter the number of edges in the flights: ");
	  int edges = input.nextInt();  
	  int[][] flights = new int[edges][edges];
	  System.out.println();
	  System.out.println("Please enter the actual values in the edges: ");
	  for(int i = 0; i < edges; i++) {
        for(int j = 0; j < edges; j++) {
          flights[i][j] = input.nextInt();
        }
      }
	  
	  System.out.println();
	  System.out.print("Please enter the starting city: ");
	  int source = input.nextInt();  
	  System.out.println();
	  System.out.print("Please enter the destination city: ");
	  int destination = input.nextInt();  
	  
	  System.out.println();
	  System.out.print("Please enter the number of stops in the flight: ");
	  int K = input.nextInt();  

	  int cheapestPrice = findCheapestPrice(n, flights, source, destination, K);
	  System.out.println();
	  System.out.print("The cheapest price from " + source + " to " + destination +  " with up to " + K + " stops is: " + cheapestPrice);

	}
  }
