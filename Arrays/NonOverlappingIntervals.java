import java.util.*;
import java.io.*;

  class Interval1 {
	int start;
	int end;
	Interval1() { 
	  start = 0; 
	  end = 0; 
	}
	Interval1(int s, int e) { 
	  start = s; 
	  end = e; 
	} 
  }

  class myComparator implements Comparator<Interval1> {
	 public int compare(Interval1 a, Interval1 b) {
       return a.end - b.end;
     }
  }
  
  public class NonOverlappingIntervals {
	  
	public static int eraseOverlapIntervals(Interval1[] intervals) {
	   if (intervals.length < 2) { 
		 return 0;
	   }
	   Arrays.sort(intervals, new myComparator());
	   int end = intervals[0].end;
	   int count = 1;  
	  
	   for (int i = 1; i < intervals.length; i++) {
         if (intervals[i].start >= end) {
           end = intervals[i].end;
           count++;
         }
       }
		
	   return intervals.length - count;           
	}  

	public static void main(String[] args) { 	
	   Interval1 intervals[] = new Interval1[] {new Interval1(1,2), new Interval1(2,3), new Interval1(3,4), new Interval1(1,3)};
	   int minimumNumberOfIntervals = eraseOverlapIntervals(intervals);
	   System.out.println("The minimum number of intervals you need to remove to make the rest of the intervals non-overlapping is: " + minimumNumberOfIntervals);
	}
  }
