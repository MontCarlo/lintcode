
public class ReverseLinkedList {
    /**
     * 翻转链表，三个节点迭代向后走
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode before = null;
        ListNode temp = head;
        ListNode after = head.next;
        while (after != null) {
            temp.next = before;
            before = temp;
            temp = after;
            after = after.next;
        }
        temp.next = before;
        return temp;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode result = r.reverseBetween(head, 1, 4);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    /**
     * 翻转链表指定的段位
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        int index = 1;
        ListNode before = null;
        ListNode first = head;
        ListNode last = null;

        ListNode temp = head;
        ListNode tempBefore = null;
        while (temp != null) {
            if (index == m) {
                first = temp;
                before = tempBefore;
            }
            if (index == n) {
                last = temp;
                break;
            }
            tempBefore = temp;
            temp = temp.next;

            index++;
        }

        temp = first;
        for (; m < n; m++) {
            ListNode next = temp.next;
            ListNode lastNext = last.next;
            if (before != null) {
                before.next = next;

            }
            temp.next = lastNext;
            last.next = temp;
            temp = next;
        }
        if (before != null) {
            return head;
        } else {
            return temp;
        }
    }
}

class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

}
