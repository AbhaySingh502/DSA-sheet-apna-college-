import java.util.*;

public class recursion {
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

    static class Binarytree {
        static int idx = -1;

        public static Node buildtree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node n = new Node(nodes[idx]);
            n.left = buildtree(nodes);
            n.right = buildtree(nodes);

            return n;
        }
    }

    public static int nofn(Node root) {
        if (root == null) {
            return 0;
        }
        int ln = nofn(root.left);
        int rn = nofn(root.left);

        return (ln + rn + 1);
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int leftsum = sum(root.left);
        int rightsum = sum(root.right);

        return (leftsum + rightsum);
    }

    public static void main(String[] args) {
        // int n[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.left.right = new Node(7);

        // System.out.println(nofn(root));
        System.out.println(sum(root));
    }

}
