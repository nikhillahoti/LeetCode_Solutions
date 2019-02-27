class MyCircularQueue {

    /** Initialize your data structure here. Set the size of the queue to be k. */
    int[] arr;
    int front = -1, rear = -1, capacity = 0, currentCapacity = 0;
    public MyCircularQueue(int k) {
        arr = new int[k];
        capacity = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(currentCapacity < capacity){
            rear++;
            if(rear == capacity) rear = 0;
            arr[rear] = value;
            currentCapacity++;
            return true;
        }
        return false;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(currentCapacity > 0){
            currentCapacity--;
            front++;
            if(front == capacity) front = 0;
            return true;
        }
        return false;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(currentCapacity > 0) return arr[front + 1];
        return -1;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(currentCapacity > 0)
            return arr[rear];
        return -1;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(currentCapacity == 0) return true;
        return false;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(currentCapacity == capacity) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
