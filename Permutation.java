//analysis starts from only one element, then 2 or 3
public class Solution {
    public ArrayList<ArrayList<Integer>> permute1(int[] num) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(num==null||num.length==0) return result;
        ArrayList<Integer> l=new ArrayList<Integer>();
        //only add an empty arraylist to the result list
        result.add(l);
        for(int i:num){
            ArrayList<ArrayList<Integer>> nr=new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> list:result){
                //note here: j starts from 0 to list.size()
                //since the insertion should happen also in front of the first element and after the end of the original list
                for(int j=0; j<=list.size();j++){
                    ArrayList<Integer> current=new ArrayList<Integer>();
                    current.addAll(list);
                    current.add(j,i);
                    nr.add(current);
                }
            }
            result=nr;
        }
        return result;
    }
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(num==null||num.length==0) return result;
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i:num) l.add(i);
        helper(l, 0, result);
        return result;
    }
    
    public void helper(ArrayList<Integer> list, int index, ArrayList<ArrayList<Integer>> result){
        if(index==list.size()){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i=index; i<list.size();i++){
            swap(i, index, list);
            helper(list, index+1, result);
            swap(index, i, list);
        }
    }
    
    public void swap(int i, int j, ArrayList<Integer> list){
        int temp=list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
