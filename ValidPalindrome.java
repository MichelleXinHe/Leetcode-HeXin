public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null) return false;
        if(s.length()==0||s.length()==1) return true;
        int start=getIndex(0, s, true);
        int end=getIndex(s.length()-1, s, false);
        while(start<end&&start>=0&&end>=0&&start<s.length()&&end<s.length()){
            char a=Character.toLowerCase(s.charAt(start));
            char b=Character.toLowerCase(s.charAt(end));
            if(a!=b)
                return false;
            start=getIndex(start+1, s, true);
            end=getIndex(end-1, s, false);
        }
        return true;
    }
    
    //this method is for both get start index and end index- boolean b
    
    public int getIndex(int index, String s, boolean b){
        if(index<0||index>=s.length()) return -1;
        //rhe condition here should consider both the start and the end
        while(index<s.length()&&index>=0){
            char c=Character.toLowerCase(s.charAt(index));
            if((c>=48&&c<=57)||(c>=97&&c<=122)) return index;
            if(b) index++;
            else index--;
        }
        if(index<0||index>=s.length()) index=-1;
        return index;
    }
}
