import java.util.ArrayList;
import java.util.List;

public class RightSideofTree {

	Problem No: 199
	public static void main(String[] args) {
		
	
	}
	
	List<Integer> levelOrderedList = new ArrayList<>();
	
	public void checkLevel(TreeNode root, int level) {
		
		if (root == null) return;
		
		if(level >= levelOrderedList.size()) {
			levelOrderedList.add(root.val);
		}
		
		checkLevel(root.right, level + 1);
		checkLevel(root.left, level + 1);
	}
	
	public List<Integer> rightSideView(TreeNode root) {
        
		checkLevel(root, 0);
		return levelOrderedList;
    }

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
    }
	
}
