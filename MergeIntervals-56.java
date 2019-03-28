/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new ArrayList<>();
        Collections.sort(intervals, (a,b) -> {
            return a.start - b.start;
        });
        
        int i = 0;
        while( i < intervals.size()){
            int startValue = intervals.get(i).start;
            int endValue = intervals.get(i++).end;
            while(i < intervals.size() && intervals.get(i).start <= endValue){
                endValue = Math.max(endValue, intervals.get(i).end);
                i++;
            }
            mergedIntervals.add(new Interval(startValue, endValue));
        }
        
        return mergedIntervals;
    }
}
