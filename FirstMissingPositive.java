//http://yucoding.blogspot.com/2013/01/leetcode-question-28-first-missing.html
//basic idea: a[i]=i+1 if i+1 exists in array a, so in the 2nd scan, the first unmatched number is the result
//otherwise return n+1
public class Solution {
    public int firstMissingPositive(int[] a) {
        int n=a.length;
        for(int i=0; i<n; i++){
            //here need to use bucket sort
            //the while loop is very important
            while(a[i]!=i+1){
                if(a[i]<=0||a[i]>n||a[a[i]-1]==a[i]) break;
                int temp=a[a[i]-1];
                a[a[i]-1]=a[i];
                a[i]=temp;
            }
        }
        
        for(int i=0; i<n;i++){
            if(a[i]!=i+1) return i+1;
        }
        
        return n+1;
    }
}
