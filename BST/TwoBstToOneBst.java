import java.util.*;

public class TwoBstToOneBst {
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

    public static Node balancedbst(ArrayList<Integer> arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr.get(mid));
        root.left = balancedbst(arr, start, mid - 1);
        root.right = balancedbst(arr, mid + 1, end);

        return root;
    }

    public static Node TwoToOne(Node n1, Node n2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(n1, arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(n2, arr2);
        ArrayList<Integer> ls = new ArrayList<>();
        for (int i = 0; i < arr1.size(); i++) {
            ls.add(arr1.get(i));
        }
        for (int i = 0; i < arr2.size(); i++) {
            ls.add(arr2.get(i));
        }
        Collections.sort(ls);

        return balancedbst(ls, 0, ls.size() - 1);
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static void main(String args[]) {

        Node n1 = new Node(2);
        n1.left = new Node(1);
        n1.right = new Node(4);

        Node n2 = new Node(9);
        n2.left = new Node(3);
        n2.right = new Node(12);

        Node n3 = TwoToOne(n1, n2);

        inorder(n3);
    }

}