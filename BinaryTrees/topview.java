import java.util.*;

public class topview {
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

    static class info {
        int Hd;
        Node node;

        public info(int hd, Node node) {
            this.Hd = hd;
            this.node = node;
        }
    }

    public static void topView(Node root) {
        Queue<info> q = new LinkedList();

        int min = 0;
        int max = 0;
        HashMap<Integer, Node> map = new HashMap<>();
        q.add(new info(0, root));
        q.add(null);

        while (!q.isEmpty()) {
            info cur = q.remove();
            if (cur == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(cur.Hd)) {
                    map.put(cur.Hd, cur.node);
                }

                if (cur.node.left != null) {
                    q.add(new info(cur.Hd - 1, cur.node.left));
                    min = Math.max(cur.Hd - 1, min);
                }
                if (cur.node.right != null) {
                    q.add(new info(cur.Hd + 1, cur.node.right));
                    max = Math.max(cur.Hd + 1, max);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.println(map.get(i).data + " ");
        }

    }
}
