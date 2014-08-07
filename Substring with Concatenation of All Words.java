//m=s.length(), n=l.length
//time=O(m*n), space=(n+m)
//dont build hashmap in a separate function and return the map to the calling method
//doesnt work, map will be null
public class Solution {
    public ArrayList<Integer> findSubstring(String s, String[] l) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(s==null||l==null||s.length()==0||l.length==0) return result;
        int slen=s.length(), size=l.length, len=l[0].length();
        if(slen<size*len) return result;
        //keep a unchangable copy of map
        HashMap<String, Integer> root=new HashMap<String, Integer>();
	    for(String ll:l){
	        if(root.containsKey(ll)) root.put(ll, root.get(ll)+1);
	        else root.put(ll, 1);
	    }

        //each char in s can be a start
        for(int i=0; i<=slen-size*len;i++){
            //use a new map each time
            HashMap<String, Integer> map=new HashMap<String, Integer>(root);
            boolean flag=false;
            //check the if the substring starts from i to i+size*len is valid
            //j+=len here
            for(int j=i; j<i+size*len; j+=len){
                String temp=s.substring(j, j+len);
                if(map.containsKey(temp)&&map.get(temp)>0){
                    map.put(temp, map.get(temp)-1);
                }else{
                    flag=true;
                    break;
                }
            }
            //only when the whole for loop finished, this substring is valid
            //record the start point here
            if(!flag) result.add(i);
        }
        return result;
    }
}
