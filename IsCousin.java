
 public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        visitNodes(root, 0);
        if(flag) return false;
        if(xdep == ydep) return true;
        return false;
    }
    int x;
    int y;
    int xdep = -1;
    int ydep = -2;
    boolean flag = false;
    
    public void visitNodes(TreeNode root, int height){
        if(root == null) return;
        if(root.val == x){
            xdep = height;
        }
        else {
            if(root.val == y){
                ydep = height;
            }
        }
        
        if(root.left != null && root.right != null){
            if(root.left.val == x && root.right.val == y) flag = true;
            if(root.left.val == y && root.right.val == x) flag = true;
        }
        
        if(flag) return;
        visitNodes(root.left, height + 1);
        visitNodes(root.right, height + 1);
    }

