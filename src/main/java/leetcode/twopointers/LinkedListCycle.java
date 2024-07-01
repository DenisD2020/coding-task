package leetcode.twopointers;

/**
 * https://leetcode.com/problems/linked-list-cycle/description/
 * <p>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        new LinkedListCycle().hasCycle(new ListNode());
    }

    public boolean hasCycle(ListNode head) {
        boolean ans = false;
        ListNode l = head, r = head;
        while (l != null && r.next != null) {
            l = l.next;
            r = r.next.next;
            if (l == r) {
                ans = true;
                break;
            }
        }
        return ans;
    }
}
