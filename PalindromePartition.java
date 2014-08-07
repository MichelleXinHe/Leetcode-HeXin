public class Solution {
    HashMap<String, ArrayList<ArrayList<String>>> map=new HashMap<String, ArrayList<ArrayList<String>>>();
    HashMap<String, Boolean> pmap=new HashMap<String, Boolean>();
    
    public ArrayList<ArrayList<String>> partition(String s) {
        if(map.containsKey(s)) return map.get(s);
        ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
        if(s.length()==0){
            //add an empty list in the result if input string is ""
            //so no need to deal with the case when right="" in the for loop
            list.add(new ArrayList<String>());
            map.put(s, list);
            return list;
        }
        for(int i=1;i<=s.length();i++){
            String left=s.substring(0,i);
            String right=s.substring(i);
            if(isPalindrome(left)){
                ArrayList<ArrayList<String>> rightList= partition(right);
                for(ArrayList<String> l:rightList){
                    //this line is important, if add left in l and add l in list, the content in list wont be updated
                    ArrayList<String> ll=new ArrayList<String>(l);
                    ll.add(0, left);
                    list.add(ll);
                }
            }
        }//for
        map.put(s, list);
        return list;
    }

    
    public boolean isPalindrome(String s){
        if(s==null) return false;
        //if(n==0||n==1) return true;
        if(pmap.containsKey(s)) return pmap.get(s);
        int n=s.length();
        for(int i=0; i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-1-i)){
               pmap.put(s, false);
               return false;
            }
        }
        pmap.put(s, true);
        return true;
    }
}
