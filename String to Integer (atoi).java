public class Solution {
    public int atoi(String s) {
        if(s==null||s.length()==0) return 0;
        int i=0, len=s.length(), sign=1;
        while(i<len&&s.charAt(i)==' ') i++;
        
        if(i<len&&(s.charAt(i)=='+'||s.charAt(i)=='-')){
            sign=(s.charAt(i)=='+')?1:-1;
            i++;
        }
        
        long result=0;
        while(i<len){
            char c=s.charAt(i);
            //if(c==' ') i++;
            if(((c-'0')>=0)&&((c-'0')<=9)){
                result=result*10+(c-'0');
                i++;
            }else break;
        }
        
        //(long) (1<<31) is negative
        //(long) 1<<31 is positive
        long boundry=(long) 1<<31;
        if(sign==1&&result>=boundry) return Integer.MAX_VALUE;
        else if(sign==-1&&result>boundry) return Integer.MIN_VALUE;
        else return (int) result*sign;
    }
}
