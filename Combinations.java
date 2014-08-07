//need to figure out the iterative method to this problem
public class Solution {
    //recursive method
    public ArrayList<ArrayList<Integer>> combine1(int n, int k) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        //result.add(new ArrayList<Integer>());
        if(n<k||n<=0||k<=0) return result;
        
        ArrayList<ArrayList<Integer>> include=combine(n-1, k-1);
        ArrayList<ArrayList<Integer>> exclude=combine(n-1, k);
        for(ArrayList<Integer> l:include){
            l.add(l.size(), n);
            result.add(l);
        }
        //special cases: empty results from include and exclude
        if(include.size()==0){
            ArrayList<Integer> l=new ArrayList<Integer>();
            l.add(n);
            result.add(l);
        }
        if(exclude.size()>0) result.addAll(exclude);
        return result; 
    }
    
    //iterative
    //r[i][j]-- n=i, k=j
    //i<j empty
    //i==j 1...i
    //i>j: r[i-1][j]+(r[i-1][j-1] with i)
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		HashMap<String, ArrayList<ArrayList<Integer>>> map=new HashMap<String, ArrayList<ArrayList<Integer>>>();
        if(n<k) return new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n;i++){
        	ArrayList<ArrayList<Integer>> temp=new ArrayList<ArrayList<Integer>>();
            temp.add(new ArrayList<Integer>());
            map.put(i+"+"+0, temp);
        }
        for(int i=1; i<=k;i++){
            ArrayList<ArrayList<Integer>> temp=new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> list=new ArrayList<Integer>();
            for(int j=1; j<=i;j++) list.add(j);
            temp.add(list);
            map.put(i+"+"+i, temp);
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<i&&j<=k; j++){
                if(!map.containsKey(i+"+"+j)){
                	ArrayList<ArrayList<Integer>> temp=new ArrayList<ArrayList<Integer>>();
                	if(map.containsKey((i-1)+"+"+j)) temp.addAll(map.get((i-1)+"+"+j));
                	if(map.containsKey((i-1)+"+"+(j-1))){
                		ArrayList<ArrayList<Integer>> t=map.get((i-1)+"+"+(j-1));
                		for(ArrayList<Integer> l:t){
                			ArrayList<Integer> tt= new ArrayList<Integer>(l);
                			tt.add(i);
                			temp.add(tt);
                		}
                	}
                	//System.out.println(i+"+"+j);
                	//System.out.println(temp);
                	
                    map.put(i+"+"+j, temp);
                }
            }
        }
        return map.get(n+"+"+k);
    }
}
