package BinaryTrees;

import java.util.ArrayList;
import java.util.Queue;

public class inverttree {
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

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return new TreeNode(0);
        }
        TreeNode lefTreeNode = invertTree(root.right);
        TreeNode rightTreeNode = invertTree(root.left);

        return new TreeNode(root.val, lefTreeNode, rightTreeNode);

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

        System.out.println(invertTree(root).val);
        System.out.println(invertTree(root).left.val);
        System.out.println(invertTree(root).right.val);

    }
}