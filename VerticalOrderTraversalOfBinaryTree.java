/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Problem No. 987

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

class Solution {
    
    PriorityQueue<Map.Entry<Integer, Map.Entry<Integer, Map.Entry<Integer, Integer>>>> pq;
    int counter = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        pq = new PriorityQueue<>(
            (a,b) -> {
                if(a.getKey() == b.getKey()){
                    if(b.getValue().getKey() == a.getValue().getKey()){
                        return a.getValue().getValue().getValue() - b.getValue().getValue().getValue();
                    }
                    return b.getValue().getKey() - a.getValue().getKey();
                }
                return a.getKey() - b.getKey();
            }
        );
        
        traverse(root, 0, 0);
        
        List<List<Integer>> output = new ArrayList<>();
        
        while(!pq.isEmpty()){
            Entry<Integer, Entry<Integer, Entry<Integer, Integer>>> value = pq.poll();
            List<Integer> arr = new ArrayList<>();
            arr.add(value.getValue().getValue().getValue());
            
            while(!pq.isEmpty() && pq.peek().getKey() == value.getKey()){
                Entry<Integer, Entry<Integer, Entry<Integer, Integer>>> Nvalue = pq.poll();
                arr.add(Nvalue.getValue().getValue().getValue());
            }
            output.add(new ArrayList<>(arr));
        }
        
        return output;        
    }
    
    public void traverse(TreeNode root, int XIndex, int YIndex){
        if(root == null) return;
        counter++;
        pq.add(new AbstractMap.SimpleEntry<Integer, Entry<Integer, Entry<Integer, Integer>>>(XIndex, new AbstractMap.SimpleEntry<Integer, Entry<Integer, Integer>>(YIndex, new AbstractMap.SimpleEntry<Integer, Integer>(counter, root.val))));
        if(root.left != null) {
            traverse(root.left, XIndex - 1, YIndex - 1);
        }
        if(root.right != null) {
            traverse(root.right, XIndex + 1, YIndex - 1);
        }
    }
}
