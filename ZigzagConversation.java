public class Solution {
    public String convert(String s, int n) {
        if(s==null||n<=0) return "";
        //special cases
        ///if(s.length()<=n||n==1) return s;
        if(n==1) return s;
        StringBuffer sb=new StringBuffer();
        int len=s.length();
        for(int i=0; i<n; i++){
            int start=i;
            boolean flag=(i!=n-1)?true:false;
            while(start<len){
                sb.append(s.charAt(start));
                if(flag){
                    flag=(i==0)?true:!flag;//first row
                    start+=(n-i-2)*2+2;
                }else{
                    flag=(i==n-1)?false:!flag;//the last row
                    start+=(i-1)*2+2;
                }
            }
        }
        return sb.toString();
    }
}
