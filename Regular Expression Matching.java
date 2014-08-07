public class Solution {
	public boolean isMatch(String s, String t) {
        //if(s==null||t==null) return false;
        //if(s.equals(t)) return true;
        int ns=s.length(), nt=t.length();
        if(nt==0) return ns==0;
        
        char c1=(ns==0)?' ':s.charAt(0);
        char c2=t.charAt(0);
        char c=(nt>1)?t.charAt(1):' ';
        if(c!='*'){
            if(c1==' '||(c1!=c2&&c2!='.')) return false;
            else return isMatch(s.substring(1), t.substring(1));
        }else{
            //in this case, since c2 and c doesnt match c1, so c2* represnt c2 0 time
            //s stays unchanged
            if(c1==' '||(c1!=c2&&c2!='.')) return isMatch(s, t.substring(2));
            else{
                //if c2==., the for loop goes from 0 to ns
                //if c2!=., the for loop goes from 0 to the end of the sequence c1 c1.. c1
                char last=(c2!='.')?c1:' ';
                for(int i=0; i<=ns; i++){
                    char temp=(i==ns)?' ':s.charAt(i);
                    //if c1==c2
                    if(last!=' '&&temp!=last){
                        if(isMatch(s.substring(i), t.substring(2))) return true;
                        break;
                    }
                    //as long as temp==last or c2=.
                    if(isMatch(s.substring(i), t.substring(2))) return true;

                }
                return false;
            }
        }
        
	}
}
