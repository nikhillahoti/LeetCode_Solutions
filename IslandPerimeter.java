// Problem No. 463

class Solution {
    public int islandPerimeter(int[][] grid) {
        int [][] visited = new int[grid.length][grid[0].length];
         for (int[] row : visited) 
            Arrays.fill(row, 10); 
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(visited[i][j] != 1 && grid[i][j] == 1){
                    visitPoint(i, j, grid, visited);
                }
            }
        }
        
        return perimeter;
    }
    int perimeter = 0;
    
    public void visitPoint(int row, int col, int [][] grid, int [][] visited){
        visited[row][col] = 1;
        int count = 4;
        
        if(row + 1 < grid.length && grid[row + 1][col] == 1)
        {
            count--;
            if(visited[row+1][col] != 1){
                visitPoint(row+1, col, grid, visited);
            }
        }
        if(row - 1 >= 0 && grid[row - 1][col] == 1)
        {
            count--;
            if(visited[row-1][col] != 1){
                visitPoint(row-1, col, grid, visited);
            }
        }
        if(col + 1 < grid[0].length && grid[row][col + 1] == 1)
        {
            count--;
            if(visited[row][col + 1] != 1){
                visitPoint(row, col + 1, grid, visited);
            }
        }
        if(col - 1 >= 0 && grid[row][col - 1] == 1)
        {
            count--;
            if(visited[row][col - 1] != 1){
                visitPoint(row, col - 1, grid, visited);
            }
        }
        perimeter += count;
    }
    
}
