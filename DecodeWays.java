//1D DP
//time and space: o(n)
//1. s.i==0: it must stick to s.i-1, and s.i-1 must be 1 or 2 then f[i]=f[i-2], otherwise f[i]=0
//2. s.i!=0: f[i] is at least=f[i-1]
//2.1 if i>=2, there will be a char in front of i, so have other possibilities
//2.2 s.i-2==1, or s.i-2==2&& s.i-1 between 1 and 6 
public class Solution {
    public int numDecodings(String s) {
        if(s==null||s.length()==0) return 0;
        int n=s.length();
        int[] f=new int[n+1];
        //initial state
        f[0]=1;
        //note: the index of current char is i-1
        for(int i=1; i<=n; i++){
            char c=s.charAt(i-1);
            if(c=='0'){
                if(i>=2&&(s.charAt(i-2)=='1'||s.charAt(i-2)=='2')) f[i]=f[i-2];
                else f[i]=0;
            }else{
                f[i]+=f[i-1];
                if(i>=2){
                    char c1=s.charAt(i-2);
                    if(c1=='1'||(c1=='2'&&c>'0'&&c<='6')) f[i]+=f[i-2];
                }
            }
        }
        return f[n];
    }
}
