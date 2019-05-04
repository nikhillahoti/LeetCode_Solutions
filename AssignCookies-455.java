class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g == null || s == null || g.length < 1 || s.length < 1) return 0;
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        int childSatisfied = 0;
        
        int index = -1;
        for(int i = 0 ; i < g.length ; i++){
            while(index + 1 < s.length){
                index++;
                if(s[index] >= g[i]){
                    childSatisfied++;
                    break;   
                }
            }
        }
            
        return childSatisfied;
    }
}
