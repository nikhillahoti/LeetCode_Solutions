/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        
        int counter = 0;
        while(true){
            if(temp1 == temp2) return temp1;
            
            temp1 = temp1.next;
            if(temp1 == null){
                temp1 = headB;
                counter++;
                if(counter > 1) break;
            } 
            
            temp2 = temp2.next;
            if(temp2 == null) temp2 = headA;
        }
        return null;
    }
}
