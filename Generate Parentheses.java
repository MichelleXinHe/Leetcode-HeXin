public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result=new ArrayList<String>();
        helper(n, n, "", result);
        return result;
    }
    
    public void helper(int left, int right, String s, ArrayList<String> result){
        if(left==0&&right==0) result.add(s);
        
        if(left>0){
            String d=s+"(";
            helper(left-1, right, d, result);
        }
        
        if(right>left){
            String d=s+")";
            helper(left, right-1, d, result);
        }
    }
}
