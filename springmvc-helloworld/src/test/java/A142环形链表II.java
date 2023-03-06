import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * A142环形链表II
 *
 * @author TomLuo
 * @date 2023年02月28日 3:23
 */
public class A142环形链表II {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode faster = head, slow = head;
        boolean isExist = false;
        while (faster.next != null && faster.next.next != null) {
            slow = slow.next;
            faster = faster.next.next;
            if (slow == faster) {
                isExist = true;
                break;
            }
        }
        if (isExist) {
            slow = head;
            while (faster != slow) {
                faster = faster.next;
                slow = slow.next;
            }
            return faster;
        }
        return null;
    }

    @org.junit.Test
    public void name() {
        //输入：head = [3,2,0,-4], pos = 1
        //输出：true
        A142环形链表II a = new A142环形链表II();
        ListNode listNode = a.detectCycle(A141环形链表.buildLink(new int[]{3, 2, 0, -4}, 1));
        assertNotNull(listNode);
        assertEquals(listNode.val, 2);
        listNode = a.detectCycle(A141环形链表.buildLink(new int[]{1, 2}, 0));
        assertNotNull(listNode);
        assertEquals(listNode.val, 1);
        listNode = a.detectCycle(A141环形链表.buildLink(new int[]{1}, -1));
        assertNull(listNode);

    }

}