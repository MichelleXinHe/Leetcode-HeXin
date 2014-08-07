public class Solution {
    public String multiply1(String num1, String num2) {
        if(num1==null||num2==null||num1.length()==0||num2.length()==0) return "";
        int n1=num1.length(), n2=num2.length();
        if(n1<n2) return multiply(num2, num1);
        String last="0";
        HashMap<Integer, StringBuffer> map=new HashMap<Integer, StringBuffer>();
        //map.put(0, new StringBuffer("0"));
        for(int i=n2-1; i>=0;i--){
            int m1=Integer.parseInt(num2.charAt(i)+"");
            System.out.println("i="+i+" m1="+m1);
            StringBuffer sb=null;
            int c=0;
            if(map.containsKey(m1)) sb=map.get(m1);
            else{
                sb=new StringBuffer();
                for(int j=n1-1;j>=0;j--){
                    int m2=Integer.parseInt(num1.charAt(j)+"");
                    int p=m1*m2+c;
                    c=p/10;
                    sb.insert(0, p%10);
                }
                //dont forget the last carry!!!
                if(c!=0) sb.insert(0,c);
            	//System.out.println(sb.toString());

                map.put(m1, sb);
            }
            StringBuffer sb1=new StringBuffer(sb.toString());
            for(int j=0; j<n2-1-i;j++) sb1.append(0);
            //System.out.println(sb1.toString());

            last=sum(last, sb1.toString());
            //System.out.println("last="+last);

        }
        return last;
    }
    
    public String sum(String s1, String s2){
        if(s1.equals("0")) return s2;
        int c=0; 
        StringBuffer sb=new StringBuffer();
        int i=s1.length()-1, j=s2.length()-1;
        while(i>=0&&j>=0){
            int m=Integer.parseInt(s1.charAt(i)+"");
            int n=Integer.parseInt(s2.charAt(j)+"");
            int sum=m+n+c;
            c=sum/10;
            sb.insert(0, sum%10);
            i--;
            j--;
        }
        
        while(j>=0){
            if(c==0) sb.insert(0, s2.charAt(j));
            else{
                int n=Integer.parseInt(s2.charAt(j)+"");
                int sum=n+c;
                c=sum/10;
                sb.insert(0, sum%10);
            }
            j--;
        }
        //if the last carry is not 0, append it to the head
        if(c!=0) sb.insert(0, c);
        return sb.toString();
    }
    
    public String multiply(String num1, String num2) {
        if(num1==null||num2==null||num1.length()==0||num2.length()==0) return "";
        int n1=num1.length(), n2=num2.length();
        if(num1.equals("0")||num2.equals("0")) return "0";
        int[] result=new int[n1+n2];
        for(int i=n1-1;i>=0;i--){
            int m1=num1.charAt(i)-'0';
            int c=0;
            for(int j=n2-1;j>=0;j--){
                int m2=num2.charAt(j)-'0';
                result[i+j+1]+=m1*m2+c;
                c=result[i+j+1]/10;
                result[i+j+1]=result[i+j+1]%10;
            }
            if(c!=0) result[i]+=c;
        }//outer for
        
        int index=0;
        for(;index<n1+n2;index++){
            if(result[index]>0) break;
        }
        
        StringBuffer sb=new StringBuffer();
        while(index<n1+n2){
            sb.append(result[index]);
            index++;
        }
        return sb.toString();
    }
}
