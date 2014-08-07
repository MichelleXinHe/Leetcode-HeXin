public class Solution {
    int N;
    //ArrayList<ArrayList<Integer>> result;
    //ArrayList<Integer> list;
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(num==null||num.length==0) return result;
        ArrayList<Integer> list=new ArrayList<Integer>();
        N=num.length;
        for(int i:num) list.add(i);
        helper(0, list, result);
        return result;
    }
    
    //use index to pin the start point that we need to permute the rest of the array
    public void helper(int index, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
        if(index==N){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        //add a hashset here, not in the permuteUnique method
        //it records which number is already in the first position in this round
        //the same number cannot be the first again
        Set<Integer> set=new HashSet<Integer>();
        for(int i=index; i<N;i++){
            if(set.contains(list.get(i))) continue;
            swap(i, index, list);
            helper(index+1, list , result);
            swap(index, i, list);
            set.add(list.get(i));
        }
    }
    
    
    public void swap(int i, int j, ArrayList<Integer> list){
        int temp=list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }     
}
