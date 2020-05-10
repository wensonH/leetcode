import java.util.List;

public class AddTwoNumbers {
    public static ListNode solution(ListNode l1, ListNode l2) {
        int carry = 0, tmp = 0;
        ListNode head = new ListNode(0), cur = head;
        while (true) {
            if (l1.val + l2.val + carry >= 10) {
                tmp = (l1.val + l2.val + carry) - 10;
                carry = 1;
            } else {
                tmp = l1.val + l2.val + carry;
                carry = 0;
            }

            l1 = l1.next;
            l2 = l2.next;

            cur.val = tmp;
            if (l1 == null || l2 == null) {
                cur.next = null;
                break;
            } else {
                cur.next = new ListNode(0);
                cur = cur.next;
            }
        }


        while (l1 != null) {
            if ((l1.val + carry) == 10) {
                l1.val = 0;
                cur.next = new ListNode(0);
                cur = cur.next;
                cur.val = l1.val;
                carry = 1;
            } else {
                l1.val += carry;
                cur.next = l1;
                carry = 0;
                break;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            if ((l2.val + carry) == 10) {
                l2.val = 0;
                cur.next = new ListNode(0);
                cur = cur.next;
                cur.val = l2.val;
                carry = 1;
            } else {
                l2.val += carry;
                cur.next = l2;
                carry = 0;
                break;
            }

            l2 = l2.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(1);

        }

        return head;
    }
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        ListNode node;
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//        l2.next.next.next = new ListNode(5);
//        l2.next.next.next.next = new ListNode(5);


        node = solution(l1, l2);


        System.out.println("output: ");
        printList(node);
    }
}


class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public ListNode getNext() {
        return next;
    }



    public boolean hasNext() {
        return this.next != null;
    }
}