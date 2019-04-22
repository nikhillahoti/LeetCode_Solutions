class MyQueue {

    // We use two stacks and all our data is stored in Stack 1.
    Stack<Integer> stk1 = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();

    // We also maintain a variable to keep track of the top element for the peek() operation 
    // which currently is a O(1) operation, Otherwise it would become a O(n) operation
    int topElem = -1;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
	// If our stack is Empty, we do not have any top element set, so we do that here
        if(stk1.isEmpty())
            topElem = x;
        stk1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
	// We move all the elements from the first stack to the second stack except for the last element.
        while(stk1.size() > 1)
            stk2.push(stk1.pop());
        
        if(stk1.isEmpty())
            return -1;

        int toReturn = stk1.pop();

	// We also change the topElem to the new top element 
        if(!stk2.isEmpty())
            topElem = stk2.peek();
        else
            topElem = -1;
        
	// We then push back all the elements from the stack 2 to stack 1 after all the operations.
        while(!stk2.isEmpty())
            stk1.push(stk2.pop());
        
        return toReturn;
    }
    
    /** Get the front element. */
    
    // Here we just return the top element 
    public int peek() {
        if(stk1.isEmpty())
            return -1;
        return topElem;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stk1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
