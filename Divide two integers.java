public class Solution {
    public int divide(int dividend, int divisor) {
        int sign=1;
        long ldividend=(long) dividend;
        long ldivisor=(long) divisor;
        if(ldividend<0){
            ldividend=-ldividend;
            sign=-sign;
        } 
        if(ldivisor<0){ 
            ldivisor=-ldivisor;
            sign=-sign;
        }
        
        int result=0;
        int count=1;
        long temp=ldivisor;
        while(ldividend>=ldivisor){
            if(ldividend>=temp){
                ldividend-=temp;
                result+=count;
            }
            
            if(ldividend>temp){
                temp=temp<<1;
                count=count<<1;
            }else if(ldividend<temp&&temp>ldivisor){
                temp=temp>>1;
                count=count>>1;
            }
        }
        
        return (sign>0)? result:-result;
    }
}
