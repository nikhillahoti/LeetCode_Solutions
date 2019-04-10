class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        for(int i = 0 ; i < edges.length ; i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            
            int parent = -1;
            if(connections.containsKey(src) && connections.containsKey(dest)){
                int parent1 = getParent(src);
                int parent2 = getParent(dest);
                if(parent1 == parent2)
                    return new int[]{src, dest};
                setParent(dest, parent1);
            }
                
            
            if(connections.containsKey(dest)){
                parent = getParent(dest);
                if(parent == -1){
                    connections.put(dest, dest);
                    parent = dest;
                }
                setParent(src, parent);
            }
            else {
                parent = getParent(src);
                if(parent == -1){
                    connections.put(src, src);
                    parent = src;
                }
                setParent(dest, parent);    
            }
        }
        return new int[]{-1,-1};
    
    }
    
    Map<Integer, Integer> connections = new HashMap<>();
    
    public int getParent(int child){
        if(!connections.containsKey(child)) return -1;
        
        int parent = connections.get(child);
        if(child == parent)
            return child;
        return getParent(parent);
    }
    
    public void setParent(int child, int newParent){
        if(connections.containsKey(child)){
            int currentParent = connections.get(child);
            connections.put(child, newParent);
            if(child != currentParent)
                setParent(currentParent, newParent);
        }
        else
            connections.put(child, newParent);
    }
    
}
