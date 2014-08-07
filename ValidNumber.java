/*
            start       end
  .         yes         only if . is not the start
  e         no          no
  +         yes         no
  -         yes         no
  0-9       yes         yes
  
  
  . can be followed by e
  e cant be foollowed by.
*/
public class Solution {
    public boolean isNumber(String s) {
        if(s==null||s.length()==0) return false;
        int n=s.length(), i=0;
        //pass all ' ' chars, find out the index of the first none empty char
        while(i<n&&s.charAt(i)==' ') i++;
        if(i==n) return false;//if all the chars of the string s are empty
        //base one the first none empty char
        char c=s.charAt(i);
        if(c=='.'){
            return checkD(s.substring(i+1), true);
        }else if(c=='-'||c=='+'){
            return checkS(s.substring(i+1));
        }else if(c>='0'&&c<='9'){
            int start=i+1;
            while(start<n){
                char c1=s.charAt(start);
                if(c1=='e'){
                    return checkE(s.substring(start+1));
                }else if(c1=='.'){
                    return checkD(s.substring(start+1), false);
                }else if(!(c1>='0'&&c1<='9')&&c1!=' '){
                    return false;
                }else if(c1==' ') return checkEmpty(s.substring(start));
                start++;
            }
        }else return false;
        
        return true;
    }
    
    //s is a string followed by a dot .
    //cannt followed by +- without e
    public boolean checkD(String s, boolean isStart){
        if(s==null) return false;
        int n=s.length();
        if(n==0&&isStart) return false;
        for(int i=0; i<n;i++){
            char c=s.charAt(i);
            if(c>='0'&&c<='9') continue;
            else if(c==' '){
                //. form is invalid
                if(i==0&&isStart) return false;
                else return checkEmpty(s.substring(i));
            }
            else if(c=='e'){
                //.e form is invalid, there should be some char before .
                if(i==0&&isStart) return false;
                return checkE(s.substring(i+1));
            }else return false;
        }
        return true;
    }
    
    //if e appears, no dot "." is allowed
    //s is a string following a letter 'e'
    public boolean checkE(String s){
        if(s==null||s.length()==0) return false;
        int n=s.length();
        for(int i=0; i<n;i++){
            char c=s.charAt(i);
            if(c>='0'&&c<='9') continue;
            else if(c==' '){ 
                //if the letter e followed by an empty char immediately
                //it is invalid number
                if(i==0) return false;
                return checkEmpty(s.substring(i));
            }
            else if(c=='+'||c=='-'){
                return checkS(s.substring(i+1));
            }
            else return false;
        }
        return true;
    }
    
    //s is the string following a +/- sign
    public boolean checkS(String s){
        if(s==null||s.length()==0) return false;
        char c=s.charAt(0);
        if(c==' '||c=='-'||c=='+') return false;
        else return isNumber(s);
    }
    
    //check if string s is pure empty
    public boolean checkEmpty(String s){
        if(s==null||s.length()==0) return true;
        int n=s.length();
        for(int i=0; i<n; i++){
            if(s.charAt(i)!=' ') return false;
        }
        return true;
    }
}
