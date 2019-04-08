class Solution {
    public int brokenCalc(int X, int Y) {
        
        int steps = 0;
        while(Y > X){
            if(Y == X) return steps;
            if(Y % 2 == 0)
                Y /= 2;
            else
                Y += 1;
            steps++;
        }
        return Y == X ? steps : steps + Math.abs(Y - X);
    }
}