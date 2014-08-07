public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows<0) return null;
        //note: ArrayList<List<Integer>>!!!
        List<List<Integer>> result =  new ArrayList<List<Integer>>();
        
        ArrayList<Integer> parent = new ArrayList<Integer>();
        parent.add(1);
        
        for(int i=1; i<=numRows; i++){
            result.add(parent);
            ArrayList<Integer> current = new ArrayList<Integer>();
            current.add(parent.get(0));
            for(int j=1; j<parent.size();j++){
                current.add(parent.get(j)+parent.get(j-1));
            }
            current.add(parent.get(parent.size()-1));
            //dont forget to pass the referent of the current list to the parent
            parent=current;
        }
        
        return result;
    }
}
