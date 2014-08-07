public class Solution {
    public String addBinary(String a, String b) {
        if(a==null||b==null) return null;
        int sa=a.length()-1, sb=b.length()-1;
        if(sa==-1||sb==-1) return (sa==-1)?b:a;
        //string a is always longer or equal to string b
        //dont forget to exchange the length at the same time
        if(sa<sb){
            String temp=a;
            a=b;
            b=temp;
            int t1=sa;
            sa=sb;
            sb=t1;
        }
        int c=0;
        StringBuffer s=new StringBuffer();
        while(sa>=0&&sb>=0){
            char c1=a.charAt(sa);
            char c2=b.charAt(sb);
            if(c1==c2){
                s.insert(0, c);
                if(c1=='1') c=1;
                else c=0;
            }else{
               if(c==0) s.insert(0, 1);
               else s.insert(0, 0);
            }
            sa--; 
            sb--;
        }
        
        while(sa>=0){
            char c1=a.charAt(sa);
            if(c==0) s.insert(0, c1);
            else{//c==1
                if(c1=='1') s.insert(0, 0);
                else{
                    c=0;
                    s.insert(0, 1);
                }
            }
            sa--;
        }
        
        //dont forget to append the non-zero carrier at the end!!!
        if(c!=0) s.insert(0, c);
        return s.toString();
    }
}
