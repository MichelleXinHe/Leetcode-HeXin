//duplicate check!for all the 2,3,4sum
//note: duplicate chech to 2sum is different, only when head point change, do the last element update
//since the last element update should always before the move of the head pointer
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] n, int t) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(n==null||n.length<4) return result;
        Arrays.sort(n);
        int last=n[0]+1;
        for(int i=0; i<n.length-3; i++){
            if(n[i]==last) continue;
            ArrayList<ArrayList<Integer>> lists=threeSum(n, i+1, t-n[i]);
            for(ArrayList<Integer> list:lists){
                ArrayList<Integer> temp=new ArrayList<Integer>(list);
                temp.add(0, n[i]);
                result.add(temp);
            }
            last=n[i];
        }
        return result;
    }
    /*
    public static ArrayList<ArrayList<Integer>> threeSum(int[] n, int start, int t) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        int last=n[start]+1;
        for(int i=start; i<n.length-2; i++){
            if(n[i]==last) continue;
            int p=i+1, q=n.length-1;
            int nt=t-n[i];
            //dont forget twoSum need to check duplicates
            int last2=n[p]+1;
            while(p<q){
            	if(n[p]==last2){
            	    //dont forget to move head here
            	    p++;
            	    continue;//forget continue here!!!
            	}
                if(nt<n[p]+n[q])q--;
                else if(nt>n[p]+n[q]){                	
                    last2=n[p];
                	p++;
                }
                else{
                    ArrayList<Integer> temp=new ArrayList<Integer>();
                    temp.add(n[i]);
                    temp.add(n[p]);
                    temp.add(n[q]);
                    result.add(temp);
                    //update last2 before p++
                    last2=n[p];
                    p++;
                    q--;
                }
            }
            //for 3sum dup check
            last=n[i];
        }
        return result;
    }
    */
    
    public ArrayList<ArrayList<Integer>> threeSum(int[] n, int start, int t) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        int last=n[start]+1;
        for(int i=start; i<n.length-2; i++){
            if(n[i]==last) continue;
            ArrayList<ArrayList<Integer>> lists=twoSum(n, i+1, t-n[i]);
            for(ArrayList<Integer> list:lists){
                ArrayList<Integer> temp=new ArrayList<Integer>(list);
                temp.add(0, n[i]);
                result.add(temp);
            }            
            last=n[i];
        }
        return result;
    }
    
    public ArrayList<ArrayList<Integer>> twoSum(int[] n, int start, int t) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        int last=n[start]+1;
        int end=n.length-1;
        while(start<end){
            if(last==n[start]){
                start++;
                continue;
            }
            
            if(t>n[start]+n[end]){
                last=n[start];
                start++;
            }else if(t<n[start]+n[end]) end--;
            else{
                ArrayList<Integer> temp=new ArrayList<Integer>();
                temp.add(n[start]);
                temp.add(n[end]);
                result.add(temp);
                last=n[start];
                start++;
                end--;
                
            }
        }
        return result;
    }
    
}
