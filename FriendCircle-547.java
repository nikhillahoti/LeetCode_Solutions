class Solution {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length < 1) return 0;
        
        HashSet<Integer> visited = new HashSet<>();
        int friendCircleCount = 0;
        
        for(int i = 0 ; i < M.length ; i++){
            for(int j = 0 ; j < M[0].length ; j++){
                if(M[i][j] == 1 && !visited.contains(i) && !visited.contains(j)){
                    
                    Queue<Integer> friends = new LinkedList<>();
                    friends.offer(i);
                    M[i][j] = 2;
                    
                    while(!friends.isEmpty()){
                        Integer current = friends.poll();
                        visited.add(current);
                        
                        for(int k = 0 ; k < M[0].length ; k++){
                            if(M[current][k] == 1 && !visited.contains(k)){
                                M[current][k] = 2;
                                friends.offer(k);
                            }
                        }
                    }
                    friendCircleCount++;
                }
            }  
        }
        return friendCircleCount;
    }
}
