public class Solution {
    ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
    HashMap<String, HashSet<String>> map=new HashMap<String, HashSet<String>>();
	public ArrayList<ArrayList<String>> findLadders(String s, String e, Set<String> dict) {
	    //this special case should be add
	    //after this, all the calculations are based on s!=e
        if(s.equals(e)){
            ArrayList<String> temp=new ArrayList<String>();
            temp.add(s);
            temp.add(e);
            result.add(temp);
            return result;
        } 
        
        dict.add(s);
        dict.add(e);
        //store the whole permutations
        Set<String> visited=new HashSet<String>();
        //store the last layer
        Set<String> parent=new HashSet<String>();
        parent.add(s);
        int n=s.length();
        //level: prevent backtracking from dead loop
        //in the map, each key will contains a list of strings that lead to this key in the upper level
        //but some of them may not lead to a path from the s to e
        int level=0;
        
        //add s to the map is important
        //since if there is no path found, when parent.size()==0, map doesnt contains the key "e"
        //so backtracking actually has the duty to check if there is a path existing
        //if s doesnt in the map, when s==e in the backtracking method, the final result wont be added
        map.put(s, new HashSet<String>());
        
        while(parent.size()>0){
            Set<String> children=new HashSet<String>();
            for(String m:parent){
                for(int i=0; i<n;i++){
                    for(char c='a'; c<='z';c++){
                        char[] content=m.toCharArray();
                        if(content[i]==c) continue;
                        content[i]=c;
                        String newS=new String(content);
                        if((!dict.contains(newS)||visited.contains(newS))&&!newS.equals(e)) continue;
                        //if(!dict.contains(newS)||newS.equals(s)) continue;
                        children.add(newS);
                        //visited.add(newS);
                        HashSet<String> temp=null;
                        if(!map.containsKey(newS))
                            temp=new HashSet<String>();
                        else temp=map.get(newS);
                        temp.add(m);
                        map.put(newS, temp);
                    }
                }
                visited.add(m);
            }//outer-for
            parent=children;
            level++;
            if(map.containsKey(e)) break;
        }//while
        LinkedList<String> t=new LinkedList<String>();
        backtracking(e, s, t, level);
        return result;
    }
    
    public void backtracking(String e, String s, LinkedList<String> temp, int level){
        if(!map.containsKey(e)) return;
        //it happens when level==0
        if(e.equals(s)){
        	temp.addFirst(s);
        	result.add(new ArrayList<String>(temp));
        	temp.removeFirst();
        	return;
        }
        
        //level shouldn't=0
        //otherwise some path with one more step from s to e will be added
        if(level>0){
            HashSet<String> parent=map.get(e);
            for(String m:parent){
        	    temp.addFirst(e);
        	    backtracking(m, s, temp, level-1);
        	    temp.removeFirst();
            }
        }
    }
}
