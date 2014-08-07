//the trick of gray code-
//n- the first half is the same as n-1
//the last half is adding 2^(n-1) to each of the first half in reversed order
// 1- 0, 1
// 2- 00, 01,, 11, 10
public class Solution {
    public List<Integer> grayCode1(int n) {
        List<Integer> list=new ArrayList<Integer>();
        if(n<0) return list;
        if(n==0){
            list.add(0);
        }else{
            List<Integer> l=grayCode(n-1);
            list.addAll(l);
            for(int i=l.size()-1; i>=0;i--)
                list.add(l.get(i)+(1<<(n-1)));
        }
        return list;
    }
    
    //iterative
    public List<Integer> grayCode(int n) {
        List<Integer> list=new ArrayList<Integer>();
        if(n<0) return list;
        list.add(0);
        for(int i=1; i<=n;i++){
            ArrayList<Integer> temp=new ArrayList<Integer>(list);
            for(int j=temp.size()-1;j>=0;j--)
                list.add(temp.get(j)+(1<<(i-1)));
        }
        
        return list;
    }
}
