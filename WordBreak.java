public class WordBreak {
    HashMap<String, Boolean> map=new HashMap<String, Boolean>();
    public boolean wordBreak(String s, Set<String> dict) {
        if(s==null) return false;
        // this is an important base case- since the last case of dividing a word
        // left is a single char, right is ""
        // if want to make this assumption be false, need to use two tables for the DP
        // the dict should be the second table-right wont be "" at last
        if(s.length()==0) return true;
        //if(dict.contains(s)) return true;
        if(map.containsKey(s)) return map.get(s);
        for(int i=1;i<=s.length();i++){
            String left=s.substring(0, i);
            String right=s.substring(i);
            if(dict.contains(left)&&wordBreak(right, dict)){
                map.put(s, true);
                return true;
            } 
        }
        map.put(s, false);
        return false;
    }
}
