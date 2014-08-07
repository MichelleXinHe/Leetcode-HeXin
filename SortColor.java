//count sort--one pass
//maintain the index of the 0, 1, 2 at any time
//zero counts the number of 0 found, and at the same time writes zeroes. 
//one counts the number of 0 + 1 found, and at the same time writes 1. 
//two counts the number of 0 + 1 + 2 found and at the same time writes 2.

public class Solution {
    public void sortColors(int[] A) {
       int zero=-1;
       int one=-1;
       int two=-1;
       for(int i=0;i<A.length;i++){
           if(A[i]==0){
               //should increase the index before using them
                A[++two]=2;
                A[++one]=1;
                A[++zero]=0;
           }else if(A[i]==1){
                A[++two]=2;
                A[++one]=1;
           }else if(A[i]==2){
                A[++two]=2;
           }
       }
       
    }
}
