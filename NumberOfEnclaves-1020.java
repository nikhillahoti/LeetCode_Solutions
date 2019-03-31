class Solution {
    
    class Pair {
        public int row, col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    int [][] visited;
    int [][] A1;
    int islandCount = 0;
    public int numEnclaves(int[][] A) {
        if(A == null || A.length < 1) return 0;
        this.A1 = A;
        visited = new int[A.length][A[0].length];
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0 ; i < A.length ; i++){
            for(int j = 0 ; j < A[0].length ; j++){
                if(A[i][j] == 1){
                    islandCount++;
                    if(i == 0 || i == A.length - 1 || j == 0 || j == A[0].length - 1)
                        queue.offer(new Pair(i,j));
                } 
            }
        }
        
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            dfs(p.row, p.col);
        }
        
        return islandCount;
    }
    
    public void dfs(int row, int col){
        if(visited[row][col] == 1) return;
        visited[row][col] = 1;
        islandCount--;
        
        if(row - 1 >= 0 && A1[row - 1][col] == 1)
            dfs(row - 1, col);
        
        if(row + 1 < A1.length && A1[row + 1][col] == 1)
            dfs(row + 1, col);
        
        if(col - 1 >= 0 && A1[row][col - 1] == 1)
            dfs(row, col - 1);
        
        if(col + 1 < A1[0].length && A1[row][col + 1] == 1)
            dfs(row, col + 1);
    }
    
    
}
