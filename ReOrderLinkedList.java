/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Problem No: 143
class Solution {
    
    
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

		ListNode ptr1 = head;
		ListNode ptr2 = head.next;

		while(ptr2 != null && ptr2.next != null){
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
		}
		
		ptr2 = ptr1.next;
		ptr1.next = null;

		ptr1 = ptr2.next;
		ptr2.next = null;
        
		// Revering the Linked List
		ListNode temp;
		while(ptr1 != null){
			temp = ptr1.next;
			ptr1.next = ptr2;
			ptr2 = ptr1;
			ptr1 = temp;
		}		
          
        ptr1 = head;
        temp = ptr1.next;
        ptr1.next = ptr2;
        ptr1 = temp;
        
        while(ptr1 != null && ptr2 != null){
            temp = ptr2.next;
            ptr2.next = ptr1;
            ptr2 = temp;
            
            temp = ptr1.next;
            ptr1.next = ptr2;
            ptr1 = temp;
            
        }

    }
}
