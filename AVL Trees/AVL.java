public class AVL {
    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    public static int getheight(Node root) {
        if (root == null) {
            return 0;
        }

        return root.height;
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static Node rightrotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        x.height = max(getheight(x.left), getheight(x.right)) + 1;
        y.height = max(getheight(y.left), getheight(y.right)) + 1;

        return x;
    }

    public static Node leftrotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = max(getheight(x.left), getheight(x.right)) + 1;
        y.height = max(getheight(y.left), getheight(y.right)) + 1;

        return y;
    }

    public static int getbalance(Node root) {
        if (root == null) {
            return 0;
        }

        return (getheight(root.left) - getheight(root.right));
    }

    public static Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);

        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);
        else
            return root;

        root.height = 1 + max(getheight(root.left), getheight(root.right));
        int bf = getbalance(root);
        // LL case

        if (bf > 1 && key < root.left.data) {
            return rightrotate(root);
        }
        // RR case

        if (bf < -1 && key > root.right.data) {
            return leftrotate(root);
        }

        // LR case

        if (bf > 1 && key > root.left.data) {
            root.left = leftrotate(root.left);

            return rightrotate(root);
        }

        // RL case
        if (bf < -1 && key < root.right.data) {
            root.right = rightrotate(root.right);

            return leftrotate(root);
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

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String args[]) {

        // Node root = insert(root, 1);
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 60);
        root = insert(root, 70);
        root = insert(root, 80);

        // inorder(root);
        preorder(root);
    }

}
