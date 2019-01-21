import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

// Problem No. 778

class Solution {
    public int swimInWater(int[][] grid) {
        
        if(grid == null) return 0;
        
        if(grid.length <= 1 || grid[0].length <= 1) return 0;
    
        int visited[][] = new int[grid.length][grid[0].length];
        for(int [] row: visited)
            Arrays.fill(row, 0);
        
        pq.add(new AbstractMap.SimpleEntry<Integer, Entry<Integer, Integer>>(grid[0][0], new AbstractMap.SimpleEntry<Integer, Integer>(0,0)));
        
        int n = grid.length - 1;
        int m = grid[0].length - 1;
        while(true){
            if(pq.isEmpty()) break;
            
            Entry<Integer, Entry<Integer, Integer>> closestPoint = pq.poll();
            
            if(closestPoint.getValue().getKey() == n && closestPoint.getValue().getValue() == m) {
                 if(waterHeight >= closestPoint.getKey())
                    return waterHeight;
                return closestPoint.getKey();
            }
            
            if(closestPoint.getKey() <= waterHeight){
                addNeightbours(closestPoint.getValue().getKey(), closestPoint.getValue().getValue(), visited, grid);
            }
            else{
                waterHeight = closestPoint.getKey();
                addNeightbours(closestPoint.getValue().getKey(), closestPoint.getValue().getValue(), visited, grid);
            }
        }
        
        return waterHeight;
            
    }
    
    int waterHeight = 0;
    PriorityQueue<Map.Entry<Integer, Map.Entry<Integer, Integer>>> pq = new PriorityQueue<>((a,b) ->  a.getKey() - b.getKey());
    
    public void addNeightbours(int row, int col, int [][] visited, int [][] grid){
        if(visited[row][col] == 1) return;

        visited[row][col] = 1;
        
        if(row + 1 < visited.length && visited[row + 1][col] != 1){
            pq.add(new AbstractMap.SimpleEntry<Integer, Entry<Integer, Integer>>(grid[row+1][col], new AbstractMap.SimpleEntry<Integer, Integer>(row+1,col)));
        }
            
        if(row - 1 >= 0 && visited[row - 1][col] != 1){
            pq.add(new AbstractMap.SimpleEntry<Integer, Entry<Integer, Integer>>(grid[row-1][col], new AbstractMap.SimpleEntry<Integer, Integer>(row-1,col)));
        }
            
        if(col + 1 < visited[0].length && visited[row][col + 1] != 1){
            pq.add(new AbstractMap.SimpleEntry<Integer, Entry<Integer, Integer>>(grid[row][col+1], new AbstractMap.SimpleEntry<Integer, Integer>(row,col+1)));
        }
        
        if(col - 1 >= 0 && visited[row][col - 1] != 1){
            pq.add(new AbstractMap.SimpleEntry<Integer, Entry<Integer, Integer>>(grid[row][col-1], new AbstractMap.SimpleEntry<Integer, Integer>(row,col-1)));
        }
            
    }
}
