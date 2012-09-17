/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> result = new ArrayList<Interval>();
        boolean inserted = false;
        for (int i = 0; i < intervals.size(); i++){
            Interval i1 =intervals.get(i);
            if (i1.end < newInterval.start)){
                result.add(i1);
            }
            else if (newInterval.end < i1.start){
                result.add(newInterval);
                result.addAll(intervals.subList(i, intervals.size()));
                inserted = true;
                break;
            }
            else{
                newInterval = merge(newInterval, i1);
            }            
        }
        if (!inserted) result.add(newInterval);
        return result;
    }

    public Interval merge(Interval i1, Interval i2){
        int start = (i1.start < i2.start) ? i1.start : i2.start;
        int end = (i1.end > i2.end) ? i1.end : i2.end;
        return new Interval(start, end);
    }
    
}