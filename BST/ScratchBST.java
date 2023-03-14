
public class ScratchBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node BST(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            // left
            root.left = BST(root.left, val);
        } else if (root.data < val) {
            // right
            root.right = BST(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data + " ");
        inorder(root.right);
    }

    public static void main(String args[]) {
        int val[] = { 9, 4, 5, 2, 3, 8, 6, 7, 3, 1 };
        Node root = null;

        for (int i = 0; i < val.length; i++) {
            root = BST(root, val[i]);
        }

        inorder(root);

    }

}
