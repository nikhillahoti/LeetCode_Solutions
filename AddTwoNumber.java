/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode head, last, temp;
        int carry = (l1.val + l2.val) / 10;
        head = new ListNode((l1.val + l2.val) % 10);
        head.next = null;
        last = head;
        
        l1 = l1.next;
        l2 = l2.next;
        
        while(l1 != null && l2 != null){
            temp = new ListNode((l1.val + l2.val + carry) % 10);
            temp.next = null;
            carry = (l1.val + l2.val + carry) / 10;
            
            last.next = temp;
            last = last.next;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if(l1 == null){
            while(l2 != null){
                temp = new ListNode((l2.val + carry) % 10);
                temp.next = null;
                carry = (l2.val + carry) / 10;
                
                last.next = temp;
                last = last.next;
                
                l2 = l2.next;
            }
        }
        
        if(l2 == null){
            while(l1 != null){
                temp = new ListNode((l1.val + carry) % 10);
                temp.next = null;
                carry = (l1.val + carry) / 10;
                
                last.next = temp;
                last = last.next;
                
                l1 = l1.next;
            }
        }
        
        if(carry > 0){
            temp = new ListNode(carry);
            temp.next = null;
            last.next = temp;
        }
        
        return head;
    }
}
