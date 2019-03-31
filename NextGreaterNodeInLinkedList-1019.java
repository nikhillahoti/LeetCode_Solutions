/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    Stack<Integer> stk = new Stack<>();
    List<Integer> output = new ArrayList<>();
    public int[] nextLargerNodes(ListNode head) {
        int out[] = null;
        if(head == null) return out;
        
        traverse(head);
        
        out = new int[output.size()];
        for(int i =  output.size() - 1 ; i >= 0 ; i--)
            out[output.size() - i - 1] = output.get(i);
        
        return out;
        
    }
    
    public void traverse(ListNode node){
        if(node == null) return;
        traverse(node.next);
        
        while(!stk.isEmpty() && stk.peek() <= node.val)
            stk.pop();

        if(stk.isEmpty())
            output.add(0);
        else 
            output.add(stk.peek());
        
        stk.push(node.val);
    }
}
