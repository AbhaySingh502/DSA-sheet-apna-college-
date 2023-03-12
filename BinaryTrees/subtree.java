package BinaryTrees;

public class subtree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return false;
        }
        if (isSame(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    public static void main(String[] args) {
        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode subroot = new TreeNode(2);
        subroot.left = new TreeNode(4);
        subroot.right = new TreeNode(5);
        isSubtree(root, subroot);
    }
}
