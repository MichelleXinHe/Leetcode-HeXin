public class Solution {
    public double pow(double x, int n) {
        boolean flag=false;
        if(n<0){
            flag=true;
            n=Math.abs(n);
        }else if(n==0) return 1;
        //base case
        if(n==1) return flag?1/x:x;
        double result=(n%2==0)?1:x;
        double cache=pow(x, n/2);
        result=result*cache*cache;
            
        return flag?1/result:result;
    }
}
