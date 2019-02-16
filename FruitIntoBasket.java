
// Problem No. 904
class Solution {
    public int totalFruit(int[] tree) {
        
        if(tree == null || tree.length < 1) return 0;
        
        int maxLen = -1;
        int lastOccu = 0;
        int lastElem = tree[0];
        int otherElem = -1;
        int otherOccu = -1;
        
        int i = 0;
        while(i < tree.length){
            if(tree[i] == lastElem)
                lastOccu = i;	  
            else {
                otherElem = tree[i];
                otherOccu = i;
                break;
            }
            i++;
        }
        
        int minIndex = 0;
        while(i < tree.length){
            if(tree[i] == lastElem) lastOccu = i;
            else if(tree[i] == otherElem) otherOccu = i;
            else {
                if(i - minIndex > maxLen) maxLen = i - minIndex;
                
                if(lastOccu > otherOccu){
                	minIndex = otherOccu + 1;
                	otherOccu = i;
                    otherElem = tree[i];                    
                }
                else {
                	minIndex = lastOccu + 1;
                	lastElem = tree[i];
                    lastOccu = i;                    
                }
            }
            i++;
        }
        maxLen = Math.max(maxLen, tree.length - minIndex);
        
        return maxLen;
    }
}
