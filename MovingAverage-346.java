class MovingAverage {
    int ptr = 0;
    int [] arr = null;
    double sum = 0;
    boolean flag = false;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        arr = new int[size];
    }
   
    public double next(int val) {
        if(!flag) {
            arr[ptr++] = val;
            sum += val;
            if(ptr == arr.length) {
                ptr = 0;
                flag = true;
                return sum / arr.length;
            }
            return sum / ptr;
        }
        sum -= arr[ptr];
        arr[ptr++] = val;
        sum += val;
       
        if(ptr == arr.length)
            ptr = 0;
       
        return sum / arr.length;
    }
}
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
