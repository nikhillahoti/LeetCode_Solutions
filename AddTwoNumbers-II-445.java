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
        
        if(l1 == null && l2 == null) return head;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        int length1 = 0;
        ListNode temp = l1;
        while(temp != null){
            length1++;
            temp = temp.next;
        }
        
        int length2 = 0;
        temp = l2;
        while(temp != null){
            length2++;
            temp = temp.next;
        }
        
        int carry = traverseList(l1, l2, length1, length2);
        if(carry > 0){
            temp = new ListNode(carry);
            temp.next = head;
            head = temp;
        }
        return head;
    }
    
    ListNode head = null;
    
    public int traverseList(ListNode l1, ListNode l2, int len1, int len2){
        
        if(l1 == null && l2 == null) return 0;
        int carry = 0, val1 = 0, val2 = 0;
        
        if(len1 == len2){
            carry = traverseList(l1.next, l2.next, len1 - 1, len2 - 1);
            val1 = l1.val;
            val2 = l2.val;
        }
        else  {
            if(len1 > len2){
                carry = traverseList(l1.next, l2, len1 - 1, len2);
                val1 = l1.val;
            }
            else {
                carry = traverseList(l1, l2.next, len1, len2 - 1);
                val2 = l2.val;
            }
        }
            
        ListNode temp = new ListNode((val1 + val2 + carry) % 10);
        temp.next = head;
        head = temp;
        return (val1 + val2 + carry) / 10;
    }
    
}
