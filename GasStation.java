//as long as the sum of gas is equal to or larger than the sum of cost, there should be a valid start point
//analysis: 0..->i...->k, k+1->j..->end
//if the sum of left gas between i to k is positive, but the left between i to k+1 is negative
//namely: any station between i and k (include i and k) cannot reach k+1
//since the sum of left gas between i and any station, q,  before k should always>=0. otherwise not way to reach this station from  i
//and sum from i to q will be >= left from q-1 to q==> sum(i, k)>=sum(q, k)=> any q cannot reach k+1
//so the next start point should be k+1

//if can travel from k+1 to end and the total left is positive, then their should be a solution from k+1
//since from 0 to k, the amount of left gas is a negative number(x). but the left sum from k+1 to end is positive(y)
//and x+y=total>=0, so start from k+1 point, the extra gas left when arrive at index 0, can cover all the negative cost from
//0 to k
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0, sum=0;
        //always one step before the valid start point
        int j=-1;
        for(int i=0; i<gas.length;i++){
            int left=gas[i]-cost[i];
            sum+=left;
            total+=left;
            if(sum<0){
                j=i;
                sum=0;
            }
        }
        return (total>=0)?j+1:-1;
    }
}
