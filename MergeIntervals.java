/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
//the algorithm takes at least nlogn time. Because this is essentially duplicate detection (when all of interval.start == interval.end)
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
 
        if (intervals.size() == 0) {
            return intervals;
        }
        Collections.sort(intervals, INTERVAL_ORDER);
        ArrayList<Interval> ret = new ArrayList<Interval>();
 
        int s = intervals.get(0).start;
        int e = intervals.get(0).end;
        for (int i = 0; i < intervals.size(); i++) {
            Interval itv = intervals.get(i);
            if (e >= itv.start) {
                //merge 2
                e = Math.max(e, itv.end);
            }
            else {
                ret.add(new Interval(s, e));
                s = itv.start;
                e = itv.end;
            }
        }
        //the last set of intervals are not added
        ret.add(new Interval(s, e));
 
        return ret;
    }
 
    static final Comparator<Interval> INTERVAL_ORDER = new Comparator<Interval>(){
        public int compare (Interval i, Interval j) {
            return new Integer(i.start).compareTo(new Integer(j.start));
        }
    };
}