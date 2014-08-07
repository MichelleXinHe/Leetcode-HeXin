public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] s) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        result.add(list);
        if(s==null) return result;
        Arrays.sort(s);
        for(int i:s){
            ArrayList<Integer> l=null;
            ArrayList<ArrayList<Integer>> temp=new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> tl:result){
                l=new ArrayList<Integer>(tl);
                l.add(i);
                temp.add(l);
            }
            result.addAll(temp);
        }
        return result;
    }
}
