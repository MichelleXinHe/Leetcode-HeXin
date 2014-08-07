public class Solution {
    //this problem can be solved by using the same idea to "find the k-th smallest element
    //in two sorted arrays"
    //if the total length of these two array is odd, just find k=(m+n)/2+1--index should be k-1
    //if sum length is even, calculate the avg of k=(m+n)/2 and k=(m+n)/2+1
    public double findMedianSortedArrays(int[] a, int[] b) {
        if(a==null||b==null) return 0;
        int m=a.length, n=b.length;
        
        //if the sum of the length of a and b is odd, one element is return
        if((m+n)%2==1) return (double) kth(a, b, 0, m-1, 0, n-1, (m+n)/2+1);
        else{
            //if the sum of the lengths is even, need to find out the avg of the two numbers in the middle
        	int p=kth(a, b, 0, m-1, 0, n-1, (m+n)/2);
        	int q=kth(a, b, 0, m-1, 0, n-1, (m+n)/2+1);
        	return (double) (((double) p)+((double) q))/2;
        }
    }
    
    public int kth(int[] a, int[] b, int sa, int ea, int sb, int eb, int k){
    	int lengtha=ea-sa+1;
        int lengthb=eb-sb+1;
        int total=lengtha+lengthb;
        //special case1: if one of the array has no more elements to compare
        if(lengtha==0&&lengthb==0) return 0;
        else if(lengtha==0) return b[sb+k-1];
        else if(lengthb==0) return a[sa+k-1];
        //special case2: if the total lenghs of these two arrays is less than k
        if(total<k) return 0;
        
        //always keep the condition: i+j=k-1!
        int i=(int) lengtha*(k-1)/total;
        int j=k-1-i;
        
        int a_i_1=(sa+i==0)?Integer.MIN_VALUE:a[sa+i-1];
        int b_j_1=(sb+j==0)?Integer.MIN_VALUE:b[sb+j-1];
        int a_i=(sa+i>=a.length)?Integer.MAX_VALUE:a[sa+i];
        int b_j=(sb+j>=b.length)?Integer.MAX_VALUE:b[sb+j];
        
        //since i+j=k-1, so if b_j_1=<a_i<=b_j, a_i is the kth element
        if(a_i<=b_j&&a_i>=b_j_1) {
        	return a_i;
        }else if(b_j<=a_i&&b_j>=a_i_1) {
        	return b_j;
        }
        
        //here a_i<b_j_1 also
        //abandon the first half as well as a_i from a
        //and the last half as well as b_j from b
        //the 4 indices are key points!!! 
        if(a_i<b_j){
        	return kth(a, b, sa+i+1, ea, sb, sb+j-1, k-i-1);
        }
        else{
        	return kth(a, b, sa, sa+i-1, sb+j+1, eb, k-j-1);
        }
    }
}
