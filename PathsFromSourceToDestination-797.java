class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
       
        if(graph == null || graph.length < 1) return output;
       
        this.graph = graph;
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
       
        List<Integer> path = new ArrayList<>();
        path.add(0);
        bfs(visited, 0, path);
        return output;
    }
   
    int graph[][];
    List<List<Integer>> output = new ArrayList<>();
    public void bfs(HashSet<Integer> visited, int index, List<Integer> path){
       
        for(int i = 0 ; i < graph[index].length ; i++){
            if(visited.contains(graph[index][i])) continue;
            if(graph[index][i] == graph.length - 1){
                path.add(graph[index][i]);
                       
                output.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
                continue;
            }
            path.add(graph[index][i]);
            visited.add(graph[index][i]);
            bfs(visited, graph[index][i], path);
            visited.remove(graph[index][i]);
            path.remove(path.size() - 1);
        }
       
    }
}
