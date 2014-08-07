public class Solution {
    public String intToRoman(int num) {
        StringBuffer sb=new StringBuffer();
        String[] array={"I", "V", "X", "L", "C", "D", "M", "", ""};
        int t=1000;
        int i=array.length-1;
        while(num!=0){
            int n=num/t;
            num-=n*t;
            t/=10;
            convert(sb, array[i], array[i-1], array[i-2], n);
            i-=2;
        }
        return sb.toString();
    }
    
    public void convert(StringBuffer sb, String l, String m, String s, int n){
        if(n<=3){
            for(int i=0; i<n;i++) sb.append(s);
        }else if(n==4) sb.append(s+m);
        else if(n==9) sb.append(s+l);
        else{
            sb.append(m);
            for(int i=0; i<n-5;i++) sb.append(s);
        }
        
    }
}
