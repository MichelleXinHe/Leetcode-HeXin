public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if(n==0) return;
        int i=m+n-1;
        int r1=m-1;
        int r2=n-1;
        while(r1>=0&&r2>=0){
            if(A[r1]>=B[r2]){
                A[i]=A[r1];
                r1--;
            }else{
                A[i]=B[r2];
                r2--;
            }
            i--;
        }
        
        while(r2>=0){
            A[i]=B[r2];
            i--;
            r2--;
        }
    }
}
