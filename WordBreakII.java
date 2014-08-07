//this is different from the first version-find out if there is one possible partition
//this problem asks to find out all the partition combinations
public class Solution {
    HashMap<String, List<String>> map= new HashMap<String, List<String>>();
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> list=new ArrayList<String>();
        //no need to check the dict first, it is a fast way to know if this string can be partitioned
        //but it prevents returning all possible combinations
        /**
        if(dict.contains(s)){
            //list.add(s);
            //return list;
        }
        */
        
        if(map.containsKey(s)) return map.get(s);
        
        for(int i=1; i<=s.length();i++){
            String left=s.substring(0,i);
            String right=s.substring(i);
            //List<String> a=wordBreak(right, dict);
            if(dict.contains(left)){
                List<String> a=wordBreak(right, dict);
                for(String b:a){
                    list.add(left+" "+b);
                }
                //when right=="", dont forget that left itself is a valid combination with "" 
                if(right.length()==0) list.add(left);
            }
            
        }
        //should put all the checked string in the table, no matter if it is a valid partition
        //so the next time, the same partition is met, no need to go throught the whole algorithm again
        map.put(s, list);
        return list;
    }
}
