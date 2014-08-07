public class Solution {
    public int removeDuplicates(int[] a) {
        if(a==null||a.length==0) return 0;
        int begin=0;
        int last=a[0];
        for(int i=1; i<a.length;i++){
            if(a[i]!=last){
                last=a[i];
                a[++begin]=a[i];
            }
        }
        return begin+1;
    }
}
