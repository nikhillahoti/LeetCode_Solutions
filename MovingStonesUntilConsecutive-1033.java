class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] result = new int[2];
        
        int[] r = new int[3];
        r[0] = a; r[1] = b; r[2] = c;
        Arrays.sort(r);
        
        if(r[0] - r[1] > 0 || r[1] - r[2] > 0) return result;
        
        if(r[1] - r[0] == 1 && r[2] - r[1] == 1)
            result[0] = 0;
        else {
            if(r[1] - r[0] == 1)
                result[0] = 1;
            else if (r[2] - r[1] == 1)
                result[0] = 1;
            else if(r[1] - r[0] == 2 || r[2] - r[1] == 2)
                result[0] = 1;
            else 
                result[0] = 2;
        }
        
        result[1] = Math.max(r[1] - r[0] - 1, 0) + Math.max(r[2] - r[1] - 1, 0);
        result[0] = Math.max(result[0], 0);
        result[1] = Math.max(result[1], 0);
        return result;
    }
}
