public class Solution {
    public int OrangesRotting(int[][] grid) {
        if (grid == null || grid.Length < 1) return 0;
            Queue<Pair> stk = new Queue<Pair>();

            int freshCount = 0;
            for(int i = 0 ; i < grid.Length ; i++)
            {
                for(int j = 0 ; j < grid[i].Length ; j++)
                {
                    if(grid[i][j] == 2)
                        stk.Enqueue(new Pair(i, j));            
                    else
                    {
                        if (grid[i][j] == 1) freshCount++;
                    }
                }
            }
        
            if (freshCount < 1) return 0;
            if (stk.Count < 1) return -1;
            
            int[,] visited = new int[grid.Length, grid[0].Length];
        
            int seconds = 0;
            while(stk.Count > 0 && freshCount > 0)
            {
                int freshCountCurrent = freshCount;
                int count = stk.Count;
                seconds++;
                while(count > 0 && freshCount > 0)
                {
                    Pair p = stk.Dequeue();
                    visited[p.row,p.col] = 1;
                    if(p.row - 1 >= 0 && grid[p.row - 1][p.col] == 1 && visited[p.row - 1,p.col] == 0)
                    {
                        visited[p.row - 1,p.col] = 1;
                        stk.Enqueue(new Pair(p.row - 1, p.col));
                        freshCount--;
                    }
                     
                    if (p.row + 1 < grid.Length && grid[p.row + 1][p.col] == 1 && visited[p.row + 1,p.col] == 0)
                    {
                        visited[p.row + 1,p.col] = 1;
                        freshCount--;
                        stk.Enqueue(new Pair(p.row + 1, p.col));
                    }
                     
                    if (p.col - 1 >= 0 && grid[p.row][p.col - 1] == 1 && visited[p.row,p.col - 1] == 0)
                    {
                        visited[p.row,p.col - 1] = 1;
                        freshCount--;
                        stk.Enqueue(new Pair(p.row, p.col - 1));
                    }
                        
                    if (p.col + 1 < grid[p.row].Length && grid[p.row][p.col + 1] == 1 && visited[p.row,p.col + 1] == 0)
                    {
                        visited[p.row,p.col + 1] = 1;
                        stk.Enqueue(new Pair(p.row, p.col + 1));
                        freshCount--;
                    }
                    count--;
                }
                if (freshCount == freshCountCurrent) return -1;
            }
            return seconds;
        }

        class Pair
        {
            public int row, col;
            public Pair(int row, int col)
            {
                this.row = row;
                this.col = col;
            }
        }
}
