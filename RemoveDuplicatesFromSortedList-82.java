/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
     
        
        if(head == null) return head;
        ListNode temp1 = head, temp2 = head.next, last = null;
        head = null;
        while(temp2 != null){
            
            if(temp1.val == temp2.val){
                while(temp2 != null && temp2.val == temp1.val)
                    temp2 = temp2.next;
                if(temp2 == null) {
                    temp1 = null;
                    break;
                }
                temp1 = temp2;
                temp2 = temp2.next;
            }
            else {
                if(head == null)
                    head = temp1;
                else 
                    last.next = temp1;
                last = temp1;
                temp1 = temp1.next;
                temp2 = temp2.next;
                last.next = null;
            }
        }
        
        if(temp1 != null){
            if(head == null)
                head = temp1;
            else
                last.next = temp1;
        }
            
        
        return head;
    }
}
