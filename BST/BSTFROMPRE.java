public class BSTFROMPRE {
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

    public static Node pre(int arr[], int start, int end) {

        if (start > end) {
            return null;
        }

        Node root = new Node(arr[start]);

        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] > root.data) {

                break;
            }
        }

        root.left = pre(arr, start + 1, i - 1);
        root.right = pre(arr, i, end);

        return root;
    }

    public static void postorder(Node root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    public static void main(String args[]) {
        int val[] = { 40, 30, 35, 80, 100 };

        Node root = pre(val, 0, val.length - 1);

        postorder(root);

    }

}
