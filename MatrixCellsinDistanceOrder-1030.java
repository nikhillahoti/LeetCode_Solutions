/*

We are given a matrix with R rows and C columns has cells with integer coordinates (r, c), where 0 <= r < R and 0 <= c < C.

Additionally, we are given a cell in that matrix with coordinates (r0, c0).

Return the coordinates of all cells in the matrix, sorted by their distance from (r0, c0) from smallest distance to largest distance.  Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance, |r1 - r2| + |c1 - c2|.  (You may return the answer in any order that satisfies this condition.)

 

Example 1:

Input: R = 1, C = 2, r0 = 0, c0 = 0
Output: [[0,0],[0,1]]
Explanation: The distances from (r0, c0) to other cells are: [0,1]

Example 2:

Input: R = 2, C = 2, r0 = 0, c0 = 1
Output: [[0,1],[0,0],[1,1],[1,0]]
Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.

Example 3:

Input: R = 2, C = 3, r0 = 1, c0 = 2
Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].


*/


class Solution {
    
    int visited[][] = null;
    
    // For this problem, from the given cell, we start picking up cells which are not visited yet and are neighbor to this cell.
    // We recursively keeping adding neighbors of the current cells using Breath First Search (BFS)
    // and stop when we have no more cells to visit
    // To maintain the next level of nodes to visit, we use a Queue.

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Queue<Pair> queue = new LinkedList<>();
        int result[][] = new int[R * C][2];
        visited = new int[R][C];
        
        queue.offer(new Pair(r0, c0));
        
        int index = 0;
        while(!queue.isEmpty()){
            int counter = queue.size();
            while(counter > 0){
                Pair current = queue.poll();
                result[index][0] = current.row;
                result[index++][1] = current.col;
                bfs(current.row, current.col, queue);
                counter--;
            }
        }
        
        return result;
    }
    
    public void bfs(int row, int col, Queue<Pair> queue){
        visited[row][col] = 1;
        
        if(row - 1 >= 0 && visited[row - 1][col] != 1){
            queue.offer(new Pair(row - 1, col));
            visited[row - 1][col] = 1;
        }
            
        
        if(row + 1 < visited.length && visited[row + 1][col] != 1){
            queue.offer(new Pair(row + 1, col));
            visited[row + 1][col] = 1;
        }
            
        
        if(col - 1 >= 0 && visited[row][col - 1] != 1){
            queue.offer(new Pair(row, col - 1));
            visited[row][col - 1] = 1;
        }
            
        
        if(col + 1 < visited[0].length && visited[row][col + 1] != 1){
            visited[row][col + 1] = 1;
            queue.offer(new Pair(row, col + 1));
        }
            
    }
    
    class Pair {
        int row, col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
