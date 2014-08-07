//http://www.geeksforgeeks.org/wildcard-character-matching/
//that is also a recursive method
public class Solution {
    //this is the correct recursive method, but TLE
    public boolean isMatch1(String s, String t) {
        if(s==null||t==null) return false;
        if(t.length()==0) return s.length()==0;
        
        char c1=(s.length()==0)?' ':s.charAt(0);
        char c2=t.charAt(0);
        if(c1==' '){
            if(c2!='?'&&c2!='*') return false;
            else return isMatch(s, t.substring(1));
        }else if(c1==c2||c2=='?'){
            return isMatch(s.substring(1), t.substring(1));
        }else if(c1!=c2&&c2!='?'&&c2!='*') return false;
        else if(c2=='*'){
            for(int i=0; i<=s.length(); i++){
                if(isMatch(s.substring(i), t.substring(1))) return true;
            }
            return false;
        }
        return false;
    }
    
    //iterative method
    public boolean isMatch(String s, String t) {
        
    }
}
