public class Solution {
    //the idea of this algorithm is correct
    //count length of the number x
    //compare the last with the first, then second last with the second...
    //but it has TLE problem
    public boolean isPalindrome1(int x) {
        if(x<0) return false;
        int t=1;
        while(x/((int) Math.pow(10, t))>0) t++;
        
        for(int i=0; i<t/2;i++){
            int p=(int) Math.pow(10, t-1-i);
            int m=(x/p)%10;
            int n=x%((int) Math.pow(10, i+1));
            if(m!=n) return false;
        }
        return true;
    }
    
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        long t=1;
        while(x/t>0) t*=10;
        int tt=(int) (t/10);
        
        while(x!=0){
            int m=x/tt;
            int n=x%10;
            if(m!=n) return false;
            x-=m*tt;
            x/=10;
            tt/=100;
        }
        return true;
    }
}
