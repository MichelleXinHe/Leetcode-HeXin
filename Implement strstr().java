//return the first start point of needle in haystack
//brute force solution: Time O(p*q) space O(1)
public class Solution {
    public String strStr(String haystack, String needle) {
        if(haystack==null||needle==null||haystack.length()<needle.length()) return null;
        if(needle.length()==0||needle.equals(haystack)) return haystack;
        int p=haystack.length(), q=needle.length();
        for(int i=0; i<=p-q; i++){
            char c1=haystack.charAt(i);
            char c2=needle.charAt(0);
            if(c1!=c2) continue;
            
            if(check(haystack, needle, i)) return haystack.substring(i);
        }
        return null;
    }
    
    public boolean check(String s, String n, int start){
        int len=n.length();
        int j=0;
        //compare s and n from the start of n
        //its easy to make mistake of judging boundry of m<start+len if comparison starting from j=1
        for(int m=start; m<start+len&&m<s.length(); m++){
            if(s.charAt(m)!=n.charAt(j)) return false;
            j++;
        }
        return j==len;
    }
}
