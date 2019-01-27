
// Problem No. 981

class TimeMap {

    /** Initialize your data structure here. */
    HashMap<String, List<Integer>> keyTime;
	HashMap<String, String> valueMap;
    public TimeMap() {
        keyTime = new HashMap<>();
        valueMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(keyTime.containsKey(key)){
            List<Integer> lst = keyTime.get(key);
            if(valueMap.containsKey(key + "->" + timestamp)){
                valueMap.put(key + "->" + timestamp, value);
            }
            else{
                lst.add(timestamp);
                keyTime.put(key, lst);
                valueMap.put(key + "->" + timestamp, value);
            }
        }
        else {
            List<Integer> lst = new ArrayList<>();
            lst.add(timestamp);
            keyTime.put(key, lst);
            
            valueMap.put(key + "->" + timestamp, value);
        }
    }
    
    public String get(String key, int timestamp) {
        if(keyTime.containsKey(key)){
            List<Integer> lst = keyTime.get(key);
            int index = binaryIndex(timestamp, lst);
            if(index == -1) return "";
            return valueMap.get(key + "->" + lst.get(index));
        }   
        return "";
    }
    
    public int binaryIndex(int value, List<Integer> lst){
	        if(lst.get(0) > value) return -1;
	        if( value > lst.get(lst.size() - 1)) return lst.size() - 1;
	        
	        
	        int low = 0;
	        int high = lst.size() - 1;
	        while(low < high){
	            int mid = (low + high) / 2;
	            System.out.println(mid + "");
	            if(lst.get(mid) == value){
	                return mid;
	            }
	            else {
	                if(high - low == 1){
	                    if(lst.get(high) <= value) return high;
	                    return low;
	                }
	            }
	            if(lst.get(mid) < value){
	                low = mid;
	            }
	            else {
	                if(lst.get(mid) > value){
	                    high = mid;
	                }
	            }
	        }
	        return low;
	    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
