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
        ArrayList<Interval> result=new ArrayList<Interval>();
        if(intervals==null&&newInterval==null) return result;
        else if(intervals==null||intervals.size()==0){result.add(newInterval); return result;}
        else if(newInterval==null) return intervals;
        
        
        Interval last=null;
        int index=-1;
        for(int i=0; i<intervals.size();i++){
            Interval current=intervals.get(i);
            if(last==null){
                //if and else if are the cases that new Interval has no overlap with the current interval
                //so just insert the current interval or new Interval base on their start point
                if(newInterval.end<current.start){
                    result.add(newInterval);
                    index=i;
                    break;
                }else if(newInterval.start>current.end) result.add(current);
                //they overlap with each other
                else{
                    int start=(newInterval.start>current.start)?current.start:newInterval.start;
                    int end=(newInterval.end>current.end)?newInterval.end:current.end;
                    last=new Interval(start, end);
                }
            }else{//there is a merge in previous steps, and last interval's start should be not larger than current interval
                if(last.end<current.start){
                    result.add(last);
                    index=i;
                    break;
                }else{//overlap with current interval
                    int end=(last.end>current.end)?last.end:current.end;
                    last=new Interval(last.start, end);
                }
            }
        }//for
        //dont forget to add last here!!!
        if(last!=null&&index==-1) result.add(last);
        if(last==null&&index==-1) result.add(newInterval);
        while(index>=0&&index<intervals.size()){
            result.add(intervals.get(index));
            index++;
        }
        return result;
    }
}
