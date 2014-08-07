public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0) return "";
        StringBuffer sb=new StringBuffer();
        for(int i=0; i<strs[0].length();i++){
            char c=strs[0].charAt(i);
            for(int j=1; j<strs.length;j++){
                if(strs[j].length()<=i||c!=strs[j].charAt(i)) return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
