public class BinaryByInandPre {

    private Node root;

    private class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public void buildTree(int[] inorder, int[] preorder) {
        root = buildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    private Node buildTree(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        Node root = new Node(rootVal);

        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                k = i;
                break;
            }
        }

        root.left = buildTree(inorder, inStart, k - 1, preorder, preStart + 1, preStart + k - inStart);
        root.right = buildTree(inorder, k + 1, inEnd, preorder, preStart + k - inStart + 1, preEnd);

        return root;
    }

    public void printInorder(Node node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        BinaryByInandPre tree = new BinaryByInandPre();

        int[] inorder = { 4, 2, 5, 1, 6, 3, 7 };
        int[] preorder = { 1, 2, 4, 5, 3, 6, 7 };

        tree.buildTree(inorder, preorder);
        tree.printInorder(tree.root);
    }
}
