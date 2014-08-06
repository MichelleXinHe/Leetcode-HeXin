/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 
 //the question is different from the one on CC-that is to count how many times a line appear-no need of hashset for that
public class MaxPoints {
    public int maxPoints(Point[] points) {
        if(points==null) return -1;
        if(points.length==1) return 1;
        int max=0;
        //use a hashset to record all the points on a line!
        //no need to consider a point is counted multiple times within a set
        HashMap<Line, HashSet<Point>> map= new HashMap<Line, HashSet<Point>>();
        int n=points.length;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                Line l= new Line(points[i], points[j]);
                HashSet<Point> p=null;
                if(!map.containsKey(l)){
                    p=new HashSet<Point>();
                }else{
                    p=map.get(l);
                }
                p.add(points[i]);
                p.add(points[j]);
                map.put(l, p);
                if(p.size()>max)
                    max=p.size();
            }
        }
        
        return max;
    }
}

class Line{
    double slope, y, x;
    double e=0.00001;
    boolean flag=false;//if true, no slope
    
    public Line(Point p1, Point p2){
        if(p1.x==p2.x){
            flag=true;
            x=(double) p1.x;
        }else{
            slope = ((double) p1.y - (double) p2.y)/((double) p1.x - (double) p2.x);
            y=(double) p1.y-slope*((double) p1.x);
        }
    }
    
    public boolean equals(Object o){
        if(o instanceof Line){
            Line l=(Line) o;
            //no slope
            if(l.flag&&this.flag&&compare(l.x,this.x))
                return true;
            
            //slope exists
            if(!l.flag&&!this.flag&&compare(l.slope, this.slope)&&compare(l.y,this.y))
                return true;
            
            return false;
        }
        return false;
    }
    
    public int hashCode(){
        if(flag){
            //need explicit cast on a double to int!!!
            int xx=(int) x*10000;
            return xx;
        }else{
            int yy=(int)y*10000;
            int ss=(int)slope*100000;
            return yy|ss;
        }
    }
    
    public boolean compare(double i, double j){
        if(Math.abs(i-j)<=e)
            return true;
        else 
            return false;
    }
}
