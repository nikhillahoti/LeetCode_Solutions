/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length < 1) return null;
        
        PriorityQueue<NodeCl> pq = new PriorityQueue<>((a,b) -> a.head.val - b.head.val);
        
        for(int i = 0 ; i < lists.length ; i++){
            if(lists[i] == null) continue;
            pq.offer(new NodeCl(i, lists[i]));
            lists[i] = lists[i].next;
        }
            
        
        ListNode head = null, tail = null, temp = null;
        
        while(!pq.isEmpty()){
            NodeCl smallestElem = pq.poll();
            temp = new ListNode(smallestElem.head.val);
            if(head == null)
                head = temp;
            else
                tail.next = temp;
            tail = temp;
            
            
            if(lists[smallestElem.index] != null){
                pq.offer(new NodeCl(smallestElem.index, lists[smallestElem.index]));
                lists[smallestElem.index] = lists[smallestElem.index].next;
            }
        }
        
        return head;
    }
    
    class NodeCl {
        int index = -1;
        ListNode head = null;
        public NodeCl(int index, ListNode head){
            this.index = index;
            this.head = head;
        }
    }
}
