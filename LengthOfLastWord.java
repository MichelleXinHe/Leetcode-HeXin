public class Solution {
    public int lengthOfLastWord(String s) {
        if(s==null||s.length()==0) return 0;
        String[] ss=s.split(" ");
        int size=ss.length;
        return (size==0||ss[size-1].equals(""))?0:ss[size-1].length();
    }
}
