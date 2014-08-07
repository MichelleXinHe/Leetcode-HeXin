//compare with the last question
//this question just need to add one step to check if the next c[i] is the for loop is the same
//as the previous one. 
//in the same position of the temp, one element can only be dfs once
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] c, int t) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(c==null) return result;
        Arrays.sort(c);
        ArrayList<Integer> temp=new ArrayList<Integer>();
        dfs(c, t, 0, result, temp);
        return result;
    }
    
    public void dfs(int[] c, int t, int start, ArrayList<ArrayList<Integer>> result,
                    ArrayList<Integer> temp){
        if(t==0){
            result.add(new ArrayList<Integer>(temp));
            return;
        } 
        
        if(start>=c.length) return;
        
        int last=c[start]+1;
        for(int i=start; i<c.length; i++){
            if(c[i]>t) return;
            if(c[i]==last) continue;
            
            temp.add(c[i]);
            dfs(c, t-c[i], i+1, result, temp);
            temp.remove(new Integer(c[i]));
            last=c[i];
        }
    }
}
