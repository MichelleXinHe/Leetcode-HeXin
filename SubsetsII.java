//the basic idea is similar, but to remove duplicate subsets, 
//if an element is a duplicate, we only add it into the last round arraylist, not all of the lists in the result set 
//http://yucoding.blogspot.com/2013/05/leetcode-question-105-subsets-ii.html
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] s) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        if(s==null) return result;
        Arrays.sort(s);
        //the latest sub results that add to result list
        ArrayList<ArrayList<Integer>> last=new ArrayList<ArrayList<Integer>>();
        //ArrayList<Integer> list=new ArrayList<Integer>();
        //list.add(s[0]);
        //result.add(list);
        //last.add(list);
        int check=0;
        for(int i=0; i<s.length;i++){
            ArrayList<Integer> l=null;
            ArrayList<ArrayList<Integer>> temp=new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<Integer>> current=(last.size()!=0&&check==s[i])?last:result;
            check=(last.size()!=0&&check==s[i])?check:s[i];
            for(ArrayList<Integer> ll:current){
                l=new ArrayList<Integer>(ll);
                l.add(s[i]);
                temp.add(l);
            }
            result.addAll(temp);
            last=temp;
        }
    
        return result;
    }
}
