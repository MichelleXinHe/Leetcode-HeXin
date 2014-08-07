//bfs
//find the shortest path between two points in a graph
public class Solution {
    public int ladderLength(String s, String e, Set<String> dict) {
        if(s.equals(e)) return 2;
        dict.add(s);
        dict.add(e);
        //store the whole permutations
        Set<String> visited=new HashSet<String>();
        //store the last layer
        Set<String> parent=new HashSet<String>();
        //visited.add(s);
        parent.add(s);
        int result=1, n=s.length();
        //the condition for this loop
        //when the parent list is null--no more branches
        while(parent.size()>0){
            Set<String> children=new HashSet<String>();
            for(String m:parent){
                for(int i=0; i<n;i++){
                    for(char c='a'; c<='z';c++){
                        char[] content=m.toCharArray();
                        if(content[i]==c) continue;
                        content[i]=c;
                        String newS=new String(content);
                        if(!dict.contains(newS)||visited.contains(newS)) continue;
                        if(newS.equals(e)) return ++result;
                        children.add(newS);
                        //visited.add(newS);
                    }
                }
                visited.add(m);
            }//outer-for
            result++;
            parent=children;
        }//while
        return 0;
    }
    
}
