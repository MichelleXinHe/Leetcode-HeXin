//example: 1, 1, 3, 4, 7, 6, 5, 4
//index:   0, 1, 2, 3, 4, 5, 6, 7
/*
    step 1:
    use pointer r to compare n[r-1] and n[r]
    if r-1 < r, this is the currently latest pair k and p
    else r-1 > r
        if k==-1 no such pair found, continue
        else see if n[r] is larger than n[k], if yes, update p==r
       
    step 2: 
    after the first round scan, if k==-1, indicating this is the last permutation, so just reverse the whole array
    
    step 3:
    if k and p pair found, in the above example, k=3, p=6, swap n[k] and n[p]
    
    step 4:
    reverse the element from k+1 to the end (since after the swap, the from k+1 to the end, it will be a descreasing array)
    
*/

public class Solution {
    public void nextPermutation(int[] n) {
        if(n==null||n.length<2) return;
        int len=n.length;
        int k=-1, p=-1;
        for(int r=1; r<len; r++){
            if(n[r-1]<n[r]){
                k=r-1;
                p=r;
            }else if((k!=-1)&&(n[k]<n[r]))
                p=r;
            
        }
        
        if(k==-1){
            for(int m=0; m<len/2; m++){
                int temp=n[m];
                n[m]=n[len-1-m];
                n[len-1-m]=temp;
            }
            return;
        }
        
        int t=n[k];
        n[k]=n[p];
        n[p]=t;
        int index=0;
        for(int m=k+1; m<(k+1+len)/2; m++){
            int temp=n[m];
            n[m]=n[len-1-index];
            n[len-1-index]=temp;
            index++;
        }
    }
}
