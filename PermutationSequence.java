public class Solution {
    ArrayList<Integer> list;
    int p=1;
    public String getPermutation(int n, int k) {
        list=new ArrayList<Integer>();
        for(int i=1; i<=n; i++){
            list.add(i);
            p*=i;
        }
        return helper(n, k);
    }
    
    public String helper(int n, int k){
        /*
        if(n<=1||k<=1){
            String s="";
            for(int i:list) s+=i;
            return s;
        }
        */
        if(list.size()==0) return "";
        p=p/n;
        int group=k/p+1;
        int rank=k%p;
        if(rank==0){
            group--;
            rank=p;
        }
        Integer temp=list.remove(group-1);
        String s=(temp!=null)?temp.intValue()+"":"";
        return s+helper(n-1, rank);
    }
}
