package LikedList;

import java.util.*;

public class reverseLinkedList {
    public static void RLL(LinkedList m) {
        for (int i = m.size() - 1; i >= 0; i--) {
            System.out.println(m.get(i));
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 1; i < 6; i++) {
            ll.add(i);
        }

        RLL(ll);
    }
}
