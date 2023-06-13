import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * A141环形链表
 *
 * @author TomLuo
 * @date 2023年02月28日 2:51
 */

public class A141环形链表 {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode faster = head, slow = head;
        while (faster.next != null && faster.next.next != null) {
            slow = slow.next;
            faster = faster.next.next;
            if (slow == faster) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void name() {
        //输入：head = [3,2,0,-4], pos = 1
        //输出：true
        A141环形链表 a = new A141环形链表();
        assertTrue(a.hasCycle(buildLink(new int[]{3, 2, 0, -4}, 1)));
        assertTrue(a.hasCycle(buildLink(new int[]{1,2}, 0)));
        assertFalse(a.hasCycle(buildLink(new int[]{1}, -1)));
    }

    public static ListNode buildLink(int[] ary, int pos) {
        ListNode head = new ListNode(ary[0]);
        ListNode node = head, linkedNode = null;
        if (pos != -1 && pos == 0) {
            linkedNode = node;
        }
        for (int i = 1; i < ary.length; i++) {
            node.next = new ListNode(ary[i]);
            node=node.next;
            if (pos != -1 && pos == i) {
                linkedNode = node;
            }

        }
        if (linkedNode != null) {
            node.next = linkedNode;
        }
        return head;
    }
}
