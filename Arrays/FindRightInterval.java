import java.util.*;
import java.io.*;

  public class FindRightInterval {  
	 
	public static int[] findRightInterval(Interval1[] intervals) {
	  // boundary case
	  if (intervals == null || intervals.length == 0) {
	    return new int[]{};	
	  }
	  int[] result = new int[intervals.length];	
	  TreeMap<Integer, Integer> intervalMap = new TreeMap<Integer, Integer>();
	  
	  for (int i = 0; i < intervals.length; i++) {
        intervalMap.put(intervals[i].start, i);    
      }
	  
	  for (int i = 0; i < intervals.length; i++) {
        Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i].end);
        result[i] = (entry != null) ? entry.getValue() : -1;
      }
		
	  return result;
    }

	public static void main(String[] args) { 
	  Interval1 intervals[] = new Interval1[] {new Interval1(1,4), new Interval1(2,3), new Interval1(3,4)};
	  int findRightInterval[] = findRightInterval(intervals);
	  System.out.print("All the intervals j whose starting point is bigger than or equal to the end point of the interval i are: ");  
	  for (int i=0; i < findRightInterval.length; i++) {
		System.out.print(findRightInterval[i] + " ");
	  }	  
	  
	}
  }
