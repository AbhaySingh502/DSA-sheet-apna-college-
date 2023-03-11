package BinaryTrees;

// import java.util.*;
import java.math.MathContext;

public class ScratchBinaryTrees {
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
        int rn = nofn(root.right);

        return (ln + rn + 1);
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int leftsum = sum(root.left);
        int rightsum = sum(root.right);

        return (leftsum + rightsum + root.data);
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        return (Math.max(lh, rh) + 1);
    }

    public static int diameter1(Node root) {
        if (root == null) {
            return 0;
        }
        int ldia = diameter1(root.left);
        int rdia = diameter1(root.right);
        int lh = height(root.left);
        int rh = height(root.right);
        int selfdiameter = lh + rh + 1;

        return (Math.max(selfdiameter, Math.max(rdia, ldia)));
    }

    static class Info {
        int dia;
        int ht;

        public Info(int dia, int ht) {
            this.dia = dia;
            this.ht = ht;
        }
    }

    public static Info diameter2(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info lf = diameter2(root.left);
        Info rf = diameter2(root.right);

        int finaldiameter = Math.max(Math.max(lf.dia, rf.dia), lf.ht + rf.ht + 1);
        int fianalheight = Math.max(lf.ht, rf.ht) + 1;

        return new Info(finaldiameter, fianalheight);
    }

    public static void main(String[] args) {
        // int n[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // System.out.println(nofn(root));
        System.out.println(diameter1(root));
        System.out.println(diameter2(root).dia);
    }

}
