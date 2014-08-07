public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int j=2; j<=n;j++){
            String ss="";
            char[] c=s.toCharArray();
            char last=c[0];
            int count=1;
            for(int i=1; i<c.length;i++){
                if(c[i]==last) count++;
                else{
                    ss=ss+count+last;
                    last=c[i];
                    count=1;
                }
            }
            ss=ss+count+last;
            s=ss;
        }
        return s;
    }
}
