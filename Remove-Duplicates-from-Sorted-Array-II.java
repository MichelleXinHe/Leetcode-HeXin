public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length==0) return 0;
        int begin=0;
        int last=A[0];
        int count=1;
        for(int i=1; i<A.length;i++){
            if(A[i]!=last){
                A[++begin]=A[i];
                last=A[i];
                count=1;
            }else{
                count++;
                if(count==2) A[++begin]=A[i];
            }
        }
        return begin+1;
        
    }
}
