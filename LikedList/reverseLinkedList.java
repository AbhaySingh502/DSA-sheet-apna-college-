
import java.util.*;

public class reverseLinkedList {
    public static void RLL(LinkedList<Integer> m) {
        for (int i = m.size() - 1; i >= 0; i--) {
            System.out.println(m.get(i));
        }
    }
    // from scratch...
    // public ListNode reverseList(ListNode head) {
    // ListNode currnode = head;
    // ListNode prv = null;
    // while(currnode!= null){
    // ListNode forward = currnode.next;
    // currnode.next = prv;
    // prv = currnode;
    // currnode = forward;

    // }
    // return prv;
    // }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 1; i < 6; i++) {
            ll.add(i);
        }

        RLL(ll);
        sc.close();
    }
}
