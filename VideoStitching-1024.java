class Solution {
    public int videoStitching(int[][] clips, int T) {
    
        if(clips == null || clips.length < 1) return 0;
        
        Arrays.sort(clips, (a,b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        
        int index = 0, length = 0;
        if(clips[index][0] > 0) return -1;
        int endPoint = 0, currMax = clips[index][1];
        while(index < clips.length){
            endPoint = currMax;
            length++;
            if(endPoint >= T) break;
            index++;
            
	    // Try to expand to the largest video within the current range             
            currMax = endPoint;
            while(index < clips.length && endPoint >= clips[index][0]){
                currMax = Math.max(clips[index][1], currMax);
                index++;
            } 

            if(endPoint == currMax) return -1;
        }
        if(endPoint >= T) return length;
        if(currMax >= T) return length + 1;
        return -1;
    }
}
