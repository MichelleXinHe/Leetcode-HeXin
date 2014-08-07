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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result=new ArrayList<Interval>();
        if(intervals==null||intervals.size()<=1) return intervals;
        Collections.sort(intervals, new IntervalComparator());
        Interval last=intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            Interval current=intervals.get(i);
            if(current.start>=last.start&&current.start<=last.end){
                int end=(current.end>last.end)?current.end:last.end;
                last=new Interval(last.start, end);
            }else{
                result.add(last);
                last=current;
            }
        }
        result.add(last);
        return result;
    }
}

class IntervalComparator implements Comparator<Interval>{
    public int compare(Interval i1, Interval i2){
        if(i1.start<i2.start||(i1.start==i2.start&&i1.end<i2.end)) return -1;
        else if (i1.start==i2.start&&i1.end==i2.end) return 0;
        else return 1;
    }
}
