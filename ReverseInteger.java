public class Solution {
    public int reverse(int x) {
        int sign=1;
        long lx=(long) x;//consider the overflow: convert from the smallest negative to be positive!!!
        if(x<0){
            sign=-sign;
            lx=-lx;
        }
        
        char[] c=(lx+"").toCharArray();
        int n=c.length;
        for(int i=0; i<n/2; i++){
            char temp=c[i];
            c[i]=c[n-1-i];
            c[n-1-i]=temp;
        }
        
        long result=0;
        for(int i=n-1; i>=0; i--) result+=(c[i]-'0')*((int) Math.pow(10, n-1-i));
        //consider the cases of overflow!!!
        long boundry=(long) 1<<31;
        if(result>boundry||(result==boundry&&sign==1)) return 0;
        
        
        return (int) result*sign;
    }
}
