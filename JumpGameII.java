public class Solution {
    //my DP program... TLE
    public int jump1(int[] a) {
        if(a==null||a.length==0) return -1;
        int[] r=new int[a.length];
        for(int i=0; i<a.length;i++){
            if(a[i]==0) r[i]=Integer.MAX_VALUE;
            else r[i]=-1;
        }
        r[a.length-1]=0;
        return helper(a, 0, r);
    }
    
    public int helper(int[] a, int index, int[] r){
        if(index<a.length&&r[index]>=0) return r[index];
        int min=Integer.MAX_VALUE;
        for(int i=1; i<=a[index]&&(i+index<a.length);i++)
            min=1+Math.min(min, helper(a, index+i, r));
        r[index]=min;
        return min;
    }
    
   //use greedy algorithm
   //always choose the position that can reach the furthest as the next jump point
   public int jump(int[] a){
       //note the base case: if only one element in the array
       if(a==null||a.length<2) return 0;
       int canReach=0;
       int currentJumpPoint=0;
       int jump=0;
       int n=a.length;
       
       while(currentJumpPoint<n){
           //currently not reach the destination, so jump if further than canReach
           //if(a[currentJumpPoint]+currentJumpPoint>canReach){
               jump++;
               canReach=a[currentJumpPoint]+currentJumpPoint;
           //}
           
           if(canReach>=n-1) return jump;//reach the destination
           
           //below canReach must<n-1
           int temp=0;//the final temp actually is the next canReach
           //select the next jump point, valid candidates are the point between current jump point and the canReach
           for(int j=currentJumpPoint+1; j<=canReach;j++){
               if(a[j]+j>temp){
                   temp=a[j]+j;
                   currentJumpPoint=j;//i is the next jump point
               }
           }//for
       }//while
       return jump;
   }
}
