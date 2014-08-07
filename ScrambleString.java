public class Solution {
    //recursive method: have TLE problem
    public boolean isScramble(String s, String t) {
        if(s==null||t==null||s.length()!=t.length()) return false;
        //if s==t no need to check
        if(s.equals(t)) return true;//add this line to reduce the TLE problem
        //s and t should be anagrams at least
        char[] c1=s.toCharArray();
        char[] c2=t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(!Arrays.equals(c1, c2)) return false;
        
        int n=s.length();
        for(int i=1; i<s.length(); i++){
            String s1=s.substring(0, i);
            String s2=s.substring(i);
            String t1=t.substring(0, i);
            String t2=t.substring(i);
            String t3=t.substring(n-i);
            String t4=t.substring(0, n-i);
            
            //compare the following four strings
            if(isScramble(s1, t1)&&isScramble(s2, t2)) return true;
            if(isScramble(s1, t3)&&isScramble(s2, t4)) return true;
        }
        return false;
    }
}
