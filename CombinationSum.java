//DFS
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] c, int t) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(c==null) return result;
        Arrays.sort(c);
        ArrayList<Integer> temp=new ArrayList<Integer>();
        dfs(c, t, 0, result, temp);
        return result;
    }
    
    public void dfs(int[] c, int t, int index, ArrayList<ArrayList<Integer>> result, 
                    ArrayList<Integer> temp){
        if(t==0){
            result.add(new ArrayList<Integer>(temp));
            return;
        }          
        

        for(int i=index; i<c.length; i++){
            if(c[i]>t) return;
            temp.add(c[i]);
            dfs(c, t-c[i], i, result, temp);
            temp.remove(new Integer(c[i]));
        }
    }
}
