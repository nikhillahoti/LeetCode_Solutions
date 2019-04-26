/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode ptr1 = node, ptr2 = node.next;
        while(ptr2 != null){
            ptr1.val = ptr2.val;
            
            if(ptr2.next == null)
            {
                ptr1.next = null;
                break;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        
    }
}
