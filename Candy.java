public class Candy {
    public int candy(int[] r) {
        if(r==null||r.length==0) return 0;
        int n=r.length;
        int[] c=new int[n];
        c[0]=1;
        //left scan
        for(int i=1; i<n;i++){
            if(r[i]>r[i-1]) c[i]=c[i-1]+1;
            //else if(r[i]==r[i-1]) c[i]=c[i-1];
            else c[i]=1;
        }
        
        int total=c[n-1];
        for(int i=n-2; i>=0; i--){
            if(r[i]>r[i+1]&&c[i]<=c[i+1]) c[i]=c[i+1]+1;
            total+=c[i];
        }
        
        return total;
        
    }
}
