/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
       
        int numberOfNodes = 0;
        ListNode temp = root;
        while (temp != null){
            temp = temp.next;
            numberOfNodes++;
        }
       
        int nodeSplit = (int) numberOfNodes / k;
       
        int remainder = numberOfNodes - (nodeSplit * k);
        ListNode [] parts = new ListNode[k];
        ListNode head = root;
        ListNode last = root;
        for(int i = 0 ; i < k ; i++){
            parts[i] = last;
            int j = 0;
            while(j < nodeSplit) {
                j++;  
                head = last;
                last = last.next;
            }
           
            if(remainder > 0){
                head = last;
                last = last.next;
                remainder--;
            }
           
            if (head != null) head.next = null;
            head = last;
         }
        return parts;
       
    }
}