import java.util.*;
import java.io.*;

  class IntervalComparator implements Comparator<Interval1> {
    @Override
    public int compare(Interval1 a, Interval1 b) {
       return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
    }
  }

  public class MergeIntervals {
	  
	public static List<Interval1> merge(List<Interval1> intervals) {
	  Collections.sort(intervals, new IntervalComparator());

      LinkedList<Interval1> merged = new LinkedList<Interval1>();
      for (Interval1 interval : intervals) {
        // if the list of merged intervals is empty or if the current interval does not overlap with the previous, simply append it.
        if (merged.isEmpty() || merged.getLast().end < interval.start) {
          merged.add(interval);
        }
        // otherwise, there is overlap, so we merge the current and previous intervals.
        else {
          merged.getLast().end = Math.max(merged.getLast().end, interval.end);
        }
      }

      return merged;
	}
	
	public static List<Interval1> merge1(List<Interval1> intervals) {
	  List<Interval1> result = new ArrayList<>();
      int[] starts = new int[intervals.size()];
      int[] ends = new int[intervals.size()];
      for (int i = 0; i < intervals.size(); i++) {
        starts[i] = intervals.get(i).start;
        ends[i] = intervals.get(i).end;
      }
      Arrays.sort(starts);
      Arrays.sort(ends);
      int i = 0;
      int j = 0;
      while (i < starts.length) {
        if (i == starts.length - 1 || ends[i] < starts[i + 1]) {
          result.add(new Interval1(starts[j], ends[i]));
          j = i + 1;
        }
        i++;
      }
      return result;
	}
	
	public static void main(String[] args) { 
	  Interval1 item1 = new Interval1(1,3);
	  Interval1 item2 = new Interval1(2,6);
	  Interval1 item3 = new Interval1(8,10);
	  Interval1 item4 = new Interval1(15,18);
      ArrayList<Interval1> intervals = new ArrayList<Interval1>();
      intervals.add(item1);
      intervals.add(item2);
      intervals.add(item3);	
      intervals.add(item4);	
	  List<Interval1> merge = merge(intervals);
	  System.out.print("After merging all the overlapping intervals: ");
	  for (int i = 0; i < merge.size(); i++) {
	    System.out.print("[" + merge.get(i).start + "," + merge.get(i).end + "]" + " ");
	  }
	}
  }
