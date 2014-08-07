public class Solution {
    //from the internet
    public List<Integer> getRow1(int rowIndex) {
        Integer[] row = new Integer[rowIndex+1];  
        for (int i=0; i<=rowIndex; ++i) {  
            row[0] = 1;  
            for (int j=i; j>0; --j) {  
                int num = row[j-1];  
                if (j<i) num += row[j];  
                    row[j] = num;  
            }  
        }  
        return new ArrayList<Integer>(Arrays.asList(row));  
    }
    
    public ArrayList<Integer> getRow(int k){
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(k<0) return result;
        result.add(1);
        for(int i=1; i<=k;i++){
            ArrayList<Integer> temp=new ArrayList<Integer>();
            temp.add(result.get(0));
            for(int j=0; j<result.size()-1;j++) temp.add(result.get(j)+result.get(j+1));
            temp.add(result.get(result.size()-1));
            result=temp;
        }
        return result;
    }
}
