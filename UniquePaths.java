public int uniquePaths(int m, int n) {

        if(m <= 0 || n <= 0) return 0;
       
        if(m <= 1 || n <= 1) return 1;
       
        int path[][] = new int [m][n];
       
        // As we have only 2 options to move, right and down, all the columns in the first
        // column will be reached by a single unique path.
        // So initialize all the first row and all columns to 1
        for(int i = 0 ; i < m ; i++)
            path[i][0] = 1;
       
       
        // Similarly all the first columns in all the rows will be reached by a single
        // unique path. So initialize the first column and all rows to 1
        for(int i = 0 ; i < n ; i++)
            path[0][i] = 1;
       
        for(int i = 1 ; i < m ; i++) {
            for(int j = 1 ; j < n ; j++) {
                path[i][j] = path[i-1][j] + path[i][j-1];
            }
        }
         
         
        return path[m-1][n-1];
    }
