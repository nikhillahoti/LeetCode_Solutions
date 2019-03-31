class Solution {
    public String baseNeg2(int N) {
        StringBuilder sb = new StringBuilder();
        if(N == 0) return "0";
        
        while(N != 0){
            sb.append(N & 1);
            N = -(N >> 1);
        }
        return sb.reverse().toString();
    }
}
