package twopointers;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * <p>
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 */
public class IntersectionTwoLinkedLists {

    public static void main(String[] args) {
/*        System.out.println(new IntersectionTwoLinkedLists().getIntersectionNode(
                        Helper.fromArray(new int[]{4, 1, 8, 4, 5}),
                        Helper.fromArray(new int[]{5, 6, 1, 8, 4, 5})
                )
        );*/

        System.out.println(new IntersectionTwoLinkedLists().getIntersectionNode(
                        Helper.fromArray(new int[]{1}),
                        Helper.fromArray(new int[]{1})
                )
        );
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
