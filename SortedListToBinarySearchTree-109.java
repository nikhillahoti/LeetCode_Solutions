/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
            
        int length = getLength(head);
        return getSubTree(head, length);
    }
    
    public TreeNode getSubTree(ListNode head, int length){
        if(head == null) return null;
        //System.out.println(head.val + "--->" + length);        
        if(length == 1 || head.next == null)
            return new TreeNode(head.val);
        
        if(length == 2){
            TreeNode node = new TreeNode(head.val);
            //System.out.println(head.val + "<----");
            head = head.next;
            node.right = new TreeNode(head.val);
            return node;
        }
            
        ListNode temp = head;
        int counter = 1;
        while(counter < ((length + 1) / 2)){
            temp = temp.next;
            counter++;
        }
        
        //System.out.println(temp.val);
        TreeNode node = new TreeNode(temp.val);
        node.left = getSubTree(head, (length + 1) / 2 - 1);
        node.right = getSubTree(temp.next, length - counter);
        return node;
    }
    
    public int getLength(ListNode head){
        ListNode temp = head;
        int length = 0;
        while(temp != null){
            temp = temp.next;
            length++;
        }
        return length;
    }
}
