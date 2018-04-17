import java.util.*;
import java.io.*;

  public class CourseSchedule {
	  
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
      if (numCourses == 0 || prerequisites.length == 0) {
    	return true;
      }
      // Convert graph presentation from edges to indegree of adjacent list.
      int indegree[] = new int[numCourses];
      for (int i = 0; i < prerequisites.length; i++) { // Indegree - how many prerequisites are needed.
        indegree[prerequisites[i][0]]++;    
      }
      java.util.Queue<Integer> queue = new LinkedList<Integer>();
      for (int i = 0; i < numCourses; i++) {
        if (indegree[i] == 0) {
          queue.add(i);
        }
      }
      
      // How many courses don't need prerequisites.
      int canFinishCount = queue.size();  
      while (!queue.isEmpty()) {
        int prerequisite = queue.remove(); // Already finished this prerequisite course.
        for (int i = 0; i < prerequisites.length; i++)  {
          if(prerequisites[i][1] == prerequisite) { 
            indegree[prerequisites[i][0]]--;
            if(indegree[prerequisites[i][0]] == 0) {
              canFinishCount++;
              queue.add(prerequisites[i][0]);
            }
          }
        }
      }

      return (canFinishCount == numCourses);       
    }  

    public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      System.out.print("Please enter the total number of courses: ");
      int numCourses = input.nextInt();  
      System.out.println();
      System.out.print("Please enter the number of rows in the list of prerequisite pairs: "); 
      int x = input.nextInt();  
      System.out.println();
      System.out.print("Please enter the number of columns in the list of prerequisite pairs: ");
      int y = input.nextInt();  
      int[][] prerequisites = new int[x][y];
      System.out.println();
      System.out.println("Please enter the actual values in the prerequisite pairs: ");
      for(int i=0; i < x; i++) {
        for(int j=0; j < y; j++) {
          prerequisites[i][j] = input.nextInt();
        }
      }
	  
      boolean isItPossibleToFinishAllCourses = canFinish(numCourses, prerequisites); 
      System.out.println();
      if(isItPossibleToFinishAllCourses) {
	System.out.println("Yes it is possible for you to finish all courses given the total number of courses and a list of prerequisite pairs.");  
      }
      else {
	System.out.println("No it is possible for you to finish all courses given the total number of courses and a list of prerequisite pairs.");    
      }
    }
  }
