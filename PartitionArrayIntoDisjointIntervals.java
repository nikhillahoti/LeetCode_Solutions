
// Problem No. 915
class Solution {
    public int partitionDisjoint(int[] A) {
        
        if(A.length < 2) return 0;
        
        int left = 1;
        int pivot = 0;
        
        int right = A.length - 1;
        int pos[] = new int[A.length];
        pos[right] = right;
        right--;
        
        while(A[pivot] <= A[right] && pivot < right)
        {
            if(A[pos[right + 1]] < A[right])
                pos[right] = pos[right + 1];
            else
                pos[right] = right;
            right--;
        }
        
        if(pivot == right) return pivot + 1;
        
        while(A[pivot] > A[left]){
            left++;
            if(left == right) return right + 1;
        }
        
        right++;
        while(left < right){
            if(A[left] > A[pivot]){
                pivot = left;
            }
            left++;
        }
        //left += 1;
        
        while(left < A.length){
            if(A[pos[left]] < A[pivot]){
                left = pos[left] + 1;
                continue;
            }
            break;
        }
        System.out.println("right index" + right);
        System.out.println("left index" + left);
        System.out.println("pivot index" + pivot);
        
        return left;
    }
}
