public class Solution {
    public List<String> anagrams(String[] strs) {
        HashMap<String, List<String>> map=new HashMap<String, List<String>>();
        for(String s: strs){
            char[] c=s.toCharArray();
            Arrays.sort(c);
            String ss=new String(c);
            List<String> l=null;
            if(!map.containsKey(ss))
                l=new ArrayList<String>();
            else l=map.get(ss);
            l.add(s);
            map.put(ss, l);
        }
        
        Set<String> keys=map.keySet();
        List<String> result=new ArrayList<String>();
        for(String s: keys){
            List<String> l=map.get(s);
            if(l.size()>1) result.addAll(l);
        }
        return result;
    }
}
