import java.util.Queue;
import java.util.LinkedList;
// iterative approach
public class isSymmetric {
    static TreeNode root;
    //Definition for a binary tree node.
    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
        }
    }

    public static boolean isMirror(TreeNode root){
        // create a queue
        // each two consecutivenodes should be equal
        // just make sure left and right should be traced converesely
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t1 = q.poll(); // remove the first element of queue
            TreeNode t2 = q.poll();
            if(t1==null && t2==null) return true;
            if(t1==null || t2==null) return false;
            if(t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
            
        return true;
    }

    public static void main(String args[]){
        // int[] binaryTree = new int[]{1,2,2,3,4,4,3};
        // isSymmetric tree = new isSymmetric();
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean output = isMirror(root);
        if (output == true)
            System.out.println("Symmetric");
        else
            System.out.println("Not symmetric");

    }
    
}
