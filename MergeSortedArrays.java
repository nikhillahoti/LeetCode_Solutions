
// Problem No. 88
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    
        //if(m < 1 || n < 1) return;
        
        int count = m + n;
        m--;
        n--;
        int last = count - 1;
        while(count > 0){
            int value1 = m == -1 ? Integer.MIN_VALUE : nums1[m];
            int value2 = n == -1 ? Integer.MIN_VALUE : nums2[n];
            if(value1 > value2){
                nums1[last] = value1;
                m--; 
            }
            else {
                n--;   
                nums1[last] = value2;
            }
            last--;
            count--;
        }
    }
}
