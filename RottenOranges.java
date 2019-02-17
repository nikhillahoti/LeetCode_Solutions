class Solution {
    int freshCount = 0;
	ArrayList<int []> rotten = new ArrayList<>();
	ArrayList<int []> newList = new ArrayList<>();
    boolean flag = false;
	
	public int orangesRotting(int[][] grid) {
        	
        if(grid == null || grid.length < 1) return 0;
        
		for(int i = 0 ; i < grid.length ; i++) {
			for(int j = 0 ; j < grid[0].length ; j++) {
				if(grid[i][j] == 2) {
					int res[] = new int[2];
					res[0] = i; res[1] = j;
					rotten.add(res);
				}
				if(grid[i][j] == 1) 
					freshCount++;
			}
		}
        if(freshCount < 1) return 0;
		int rounds = 0;
		if(rotten.size() < 1) return -1;
		
		while(true) {
			flag = false;
			int count = rotten.size();
			for(int i = 0 ; i < count ; i++) {
				int res[] = rotten.get(i);
				makeRotten(res[0], res[1], grid);
			}
			
			rotten = newList;
			if(freshCount < 1) return ++rounds;
			if(!flag) return -1;
            rounds++;
		}
    }
	
	public void makeRotten(int row, int col, int grid[][]) {
		if(row - 1 >= 0 && grid[row-1][col] == 1) {
			freshCount--;
			grid[row-1][col] = 2;
			int res[] = new int[2];
			res[0] = row - 1;
			res[1] = col;
			newList.add(res);
            flag = true;
		}
		if(row + 1 < grid.length && grid[row+1][col] == 1) {
			freshCount--;
			grid[row+1][col] = 2;
			int res[] = new int[2];
			res[0] = row + 1;
			res[1] = col;
			newList.add(res);
            flag = true;
		}
		if(col - 1 >= 0 && grid[row][col-1] == 1) {
			freshCount--;
			grid[row][col-1] = 2;
			int res[] = new int[2];
			res[0] = row;
			res[1] = col - 1;
			newList.add(res);
            flag = true;
		}
		if(col + 1 < grid[0].length && grid[row][col+1] == 1) {
			freshCount--;
			grid[row][col+1] = 2;
			int res[] = new int[2];
			res[0] = row;
			res[1] = col + 1;
			newList.add(res);
            flag = true;
		}
	}
}
