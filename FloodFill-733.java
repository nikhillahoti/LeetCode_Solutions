class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image == null || image.length < 1) return image;
        
        if(sr >= image.length || sc >= image[0].length || sr < 0 || sc < 0) return image;
        
        Stack<Pair> stk = new Stack<>();
        stk.push(new Pair(sr, sc));
        int color = image[sr][sc];
        
        int visited[][] = new int[image.length][image[0].length];
        
        while(!stk.isEmpty()){
            Pair p = stk.pop();
            
            image[p.row][p.col] = newColor;
            
            if(p.row - 1 >= 0 && visited[p.row - 1][p.col] == 0 && image[p.row - 1][p.col] == color){
                stk.push(new Pair(p.row - 1, p.col));
                visited[p.row - 1][p.col] = 1;
            }
            if(p.row + 1 < image.length && visited[p.row + 1][p.col] == 0 && image[p.row + 1][p.col] == color){
                stk.push(new Pair(p.row + 1, p.col));
                visited[p.row + 1][p.col] = 1;
            }
            if(p.col - 1 >= 0 && visited[p.row][p.col - 1] == 0 && image[p.row][p.col - 1] == color){
                stk.push(new Pair(p.row, p.col - 1));
                visited[p.row][p.col - 1] = 1;
            }
            if(p.col + 1 < image[0].length && visited[p.row][p.col + 1] == 0 && image[p.row][p.col + 1] == color){
                stk.push(new Pair(p.row, p.col + 1));
                visited[p.row][p.col + 1] = 1;
            }
        }
        
        return image;
        
    }
    
    class Pair {
        int row, col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
