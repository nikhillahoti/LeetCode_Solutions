/*
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Input: [5,2,6,1]
Output: [2,1,1,0] 
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

*/


class Solution {

    // So our basic idea is to maintain a Binary Search Tree where every node in the BST maintains 4 things. 
    // the number of nodes in the left subtree, # in right subtree and links to both the subtrees
    class Node {
        int val, LSTC, RSTC;
        Node left, right;
        
        public Node(int val){
            this.val = val;
            this.LSTC = 0;
            this.RSTC = 0;
            this.left = null;
            this.right = null;
        }
    }
	

    public List<Integer> countSmaller(int[] nums) {
       
        List<Integer> output = new ArrayList<>();
        if(nums == null || nums.length < 1) return output;
        output.add(0);
        Node root = new Node(nums[nums.length - 1]);
        for(int i = nums.length - 2 ; i >= 0 ; --i){
            countLessThan = 0;
            insertNode(root, nums[i]);
            output.add(countLessThan);
        }
        Collections.reverse(output);
        return output;
    }
    
    int countLessThan = 0;
    
    // At every instance we check to see if the current node is less than the new value that is to be inserted. 
    // If yes, then we know that all the nodes in the left Subtree are smaller than this new node and also the current node we are at. 
    // we add this to our global count variable and reset the variable for every value in the array

    // if the new node value is less than the current nodes value, we know that the right subtree elements are all greater than the new node and so 
    // they do not contribute to the final count value, so we skip the right subtree.
    void insertNode(Node root, int newElem){
        if(root == null) return;
        
        if(newElem > root.val){
            countLessThan += root.LSTC + 1;
            if(root.right == null){
                root.right = new Node(newElem);
            }
            else {
                insertNode(root.right, newElem);
            }
            root.RSTC++;
        }
        else {
            if(root.left == null){
                root.left = new Node(newElem);
            }
            else {
                insertNode(root.left, newElem);
            }
            root.LSTC++;
        }
    }
    
   
    
}
