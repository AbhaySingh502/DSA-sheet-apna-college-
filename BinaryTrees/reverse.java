
public class reverse {
    static class Node {
        int val;
        Node left;
        Node right;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // question number 205;
    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);

        return (Math.max(leftdepth, rightdepth) + 1);
    }

    public static void revrseorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        revrseorderTraversal(root.left);
        revrseorderTraversal(root.right);

    }

    public static void main(String[] args) {
        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ;
        revrseorderTraversal(root);
    }

}
