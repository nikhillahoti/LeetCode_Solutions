/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null || k <= 0) return head;
        
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            length++;
        }
        if(k % length == 0) return head;
        
        length = length - (k % length);
    
        temp = head;
        while(length > 1){
            temp = temp.next;
            length--;
        }
        
        
        ListNode temp2 = temp.next;
        temp.next = null;
        temp = temp2;
        temp2 = head;
        head = temp;
        
        while(temp.next != null) temp = temp.next;
        
        temp.next = temp2;
        return head;
    }
}
