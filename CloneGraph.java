/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
        if(root==null) return null;
        UndirectedGraphNode nr=new UndirectedGraphNode(root.label);
        ArrayList<UndirectedGraphNode> parent=new ArrayList<UndirectedGraphNode>();
        ArrayList<UndirectedGraphNode> cpparent=new ArrayList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> visited=new HashSet<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        parent.add(root);
        cpparent.add(nr);
        //forget to add the root in the map
        map.put(root, nr);
        while(parent.size()>0){
            ArrayList<UndirectedGraphNode> current=new ArrayList<UndirectedGraphNode>();
            ArrayList<UndirectedGraphNode> cpcurrent=new ArrayList<UndirectedGraphNode>();
            for(int i=0; i<parent.size();i++){
                UndirectedGraphNode n=parent.get(i);
                //avoid loop
                //
                if(visited.contains(n)) continue;
                UndirectedGraphNode m=cpparent.get(i);
                for(UndirectedGraphNode neighbor:n.neighbors){
                    UndirectedGraphNode add=null;
                    if(map.containsKey(neighbor)) add=map.get(neighbor);
                    else add=new UndirectedGraphNode(neighbor.label);
                    m.neighbors.add(add);
                    map.put(neighbor, add);
                    
                    //if(!visited.contains(neighbor)){
                        current.add(neighbor);
                        cpcurrent.add(add);
                    //}
                }
                visited.add(n);
                
            }
            parent=current;
            cpparent=cpcurrent;
        }
        return nr;
    }
}
