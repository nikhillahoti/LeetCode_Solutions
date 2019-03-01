class Solution {
    int count = 2;
    int cnt = 0;
    
    int grid[][];
    HashMap<Integer, Integer> hash = new HashMap<>();
    int [][] marked;
    
    public int largestIsland(int[][] grid) {
        if(grid == null || grid.length < 1) return 0;
        
        this.grid = grid;
        marked = new int[grid.length][grid[0].length];    
        
        Stack<Pair> stk = new Stack<>();
        
        int maxIsland = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1 && marked[i][j] < 1){
                    cnt = 0;
                    traverse(i,j);
                    hash.put(count, cnt);
                    maxIsland = Math.max(maxIsland, cnt);
                    count++;
                }
                else if(grid[i][j] == 0){
                   stk.push(new Pair(i, j));
                }
            }
        }
        
        if(stk.size() > 0) maxIsland = 1;
        while(!stk.isEmpty()){
            Pair p = stk.pop();
            maxIsland = Math.max( maxIsland, sumNeighbour(p.row, p.col) + 1);
        }
        
        return maxIsland;
    }
    
    public int sumNeighbour(int row, int col){
        int sum = 0;
        HashSet<Integer> h = new HashSet<>();
        if(row - 1 >= 0 && grid[row - 1][col] == 1)
        {
            h.add(marked[row - 1][col]);
            sum += hash.get(marked[row - 1][col]);
        }
        
        if(row + 1 < grid.length && grid[row + 1][col] == 1){
            if(!h.contains(marked[row + 1][col])){
                sum += hash.get(marked[row + 1][col]);
                h.add(marked[row + 1][col]);
            }
        }
        
        if(col - 1 >= 0 && grid[row][col - 1] == 1)
            if(!h.contains(marked[row][col - 1])){
                sum += hash.get(marked[row][col - 1]);
                h.add(marked[row][col - 1]);
            }
        
        if(col + 1 < grid[0].length && grid[row][col + 1] == 1)
            if(!h.contains(marked[row][col + 1])){
                sum += hash.get(marked[row][col + 1]);
                h.add(marked[row][col + 1]);
            }
        
        return sum;
    }
    
    class Pair {
        int row;
        int col;
        
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public void traverse(int row, int col){
        
        if(marked[row][col] > 0) return;
        
        marked[row][col] = count;
        cnt++;
        if(row - 1 >= 0 && grid[row - 1][col] == 1)
            traverse(row - 1, col);
        
        if(row + 1 < grid.length && grid[row + 1][col] == 1)
            traverse(row + 1, col);
        
        if(col - 1 >= 0 && grid[row][col - 1] == 1)
            traverse(row, col - 1);
        
        if(col + 1 < grid[0].length && grid[row][col + 1] == 1)
            traverse(row, col + 1);
    }
}
