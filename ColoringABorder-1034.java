class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if(grid == null || grid.length < 1) return grid;
        
        if(r0 < 0 || r0 > grid.length || c0 < 0 || c0 > grid[0].length)
            return grid;
        
        visited = new int[grid.length][grid[0].length];
        dfs(r0, c0, grid, grid[r0][c0]);
        
        for(Pair p: queue)
        {
            grid[p.row][p.col] = color;
        }
        
        return grid;
    }
    
    class Pair {
        int row = 0, col = 0;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    Set<Pair> queue = new HashSet<>();
    
    int [][] visited = null;
    public void dfs(int row, int col, int [][] grid, int currColor){
        
        if(visited[row][col] == 1) return;
        visited[row][col] = 1;
        
        boolean flag = false;
        
        if(row - 1 >= 0){
            if(grid[row - 1][col] == currColor){
                if(visited[row - 1][col] == 0)       
                    dfs(row - 1, col, grid, currColor);
            }
            else 
                flag = true;
        }
            
        if(row + 1 < grid.length){
            if(grid[row + 1][col] == currColor){
                if(visited[row + 1][col] == 0)       
                    dfs(row + 1, col, grid,  currColor);
            }
            else 
                flag = true;
        }
        
        if(col - 1 >= 0){
            if(grid[row][col - 1] == currColor){
                if(visited[row][col - 1] == 0)       
                    dfs(row, col - 1, grid, currColor);
            }
            else 
                flag = true;
        }
        
        if(col + 1 < grid[0].length){
            if(grid[row][col + 1] == currColor){
                if(visited[row][col + 1] == 0)       
                    dfs(row, col + 1, grid, currColor);
            }
            else 
                flag = true;
        }
        
        if(row == 0 || col == 0 || row == grid.length - 1 || col == grid[0].length - 1){
            queue.add(new Pair(row, col));
            return;
        }
        if(flag)
            queue.add(new Pair(row, col));
    }
}
