import java.util.*;

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

    public static int nofn(Node root) {
        if (root == null) {
            return 0;
        }
        int ln = nofn(root.left);
        int rn = nofn(root.right);

        return (ln + rn + 1);
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

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static boolean search(Node root, int val) {
        if (root == null) {
            return false;
        }
        if (root.data == val) {
            return true;
        }
        if (val > root.data) {
            return search(root.right, val);
        } else {
            return search(root.left, val);
        }

    }

    public static Node delete(Node root, int val) {
        if (val < root.data) {
            root.left = delete(root.left, val);
        } else if (val > root.data) {
            root.right = delete(root.right, val);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Node IS = findInorder(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static Node findInorder(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static Node balancedBST(ArrayList<Integer> arr, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(arr.get(mid));
        root.left = balancedBST(arr, start, mid - 1);
        root.right = balancedBST(arr, mid + 1, end);
        return root;
    }

    public static void sortedarr(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }

        sortedarr(root.left, inorder);
        inorder.add(root.data);
        sortedarr(root.right, inorder);
    }
    // pub

    public static Node convertBSTtoBalancedBST(Node root) {
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        sortedarr(root, inorder);

        return balancedBST(inorder, 0, inorder.size() - 1);
    }

    // }
    public static void main(String args[]) {
        // int val[] = { 9, 4, 5, 2, 3, 8, 6, 7, 3, 1 };
        // Node root = null;

        // for (int i = 0; i < val.length; i++) {
        // root = BST(root, val[i]);
        // }
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
        convertBSTtoBalancedBST(root);
        preorder(root);
    }

}
