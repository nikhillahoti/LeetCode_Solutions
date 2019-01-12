/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Problem 876
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        
        while(ptr2 != null && ptr2.next != null){
            ptr2 = ptr2.next.next;
            ptr1 = ptr1.next;
        }
        return ptr1;
    }
}
