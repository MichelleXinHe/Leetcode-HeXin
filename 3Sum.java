// O(n^2) is the best run time
// prevent duplication should be done in both methods!
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        int index=-1;
        Arrays.sort(num);
        for(int i=0; i<num.length;i++){
            if(index>=0&&num[i]==num[index]){
                index++;
                continue;
            }
            
            int sum=0-num[i];
            List<List<Integer>> list= twoSum(num, i+1, sum);
            for(List<Integer> l:list){
                l.add(0, num[i]);
                result.add(l);
            }
            index++;
        }
        return result;
    }
    // no duplicate result in two sum is required!
    public List<List<Integer>> twoSum(int[] num, int i, int sum){
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        int end=num.length-1;
        int start=i;
        int index=i-1;
        while(i<end){
            //index >= start
            if(index>=start&&num[i]==num[index]){
                index++;
                i++;
                continue;
            }
            if(num[i]+num[end]==sum){
                ArrayList<Integer> r= new ArrayList<Integer>();
                r.add(num[i]);
                r.add(num[end]);
                result.add(r);
                i++;
                end--;
                index++;
            }else if(num[i]+num[end]>sum)
                end--;
            else{
                i++;
                index++;
            }

        }
        return result;
    }
}
