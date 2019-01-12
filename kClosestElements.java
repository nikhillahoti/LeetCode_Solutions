
// Problme No. 658
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int closestIndex = 0;
        while(true){
            mid = (low + high) / 2;
            if(arr[mid] == x) {
                closestIndex = mid;
                break;
            }
            if(mid == low){
                if(x - arr[low] <= arr[high] - x)
                    closestIndex = low;
                else
                    closestIndex = high;
                break;
            }
            
            if(arr[mid] < x)
                low = mid;
            else
                high = mid;          
        }
        
        low = closestIndex - 1;
        
        high = closestIndex + 1;
        
        while (k > 1 && low > -1 && high < (arr.length)){
            if(x - arr[low] <= arr[high] - x)
                low--;
            else
                high++;
            k--;
        }
    
        while(k > 1 && high == arr.length){
            low--; k--;
        }
            
        while(k > 1 && low == -1){
            high++; k--;
        }
        
        low++;
        List<Integer> output= new ArrayList<>();
        while(low < high){
            output.add(arr[low++]);
        }
        return output;
    }
}
