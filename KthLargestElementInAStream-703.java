
/*

Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8

Note:
You may assume that nums' length ≥ k-1 and k ≥ 1



*/


/*

The Idea is that we maintain a min Priority Queue of size K.
When a new element comes, we first insert that into the Priority Queue and the pop if the size of our Priority Queue is greater than k,
then we just return the element at the top of the Priority Queue which will be the k-largest element. (Smallest in a k size Priority Queue)

*/

class KthLargest {

    PriorityQueue<Integer> pq = null;
    int k = 0;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>((a,b) -> a - b);
        
        for(int num: nums)
            pq.offer(num);
        
        while(!pq.isEmpty() && pq.size() > k)
            pq.poll();
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k)
            pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
