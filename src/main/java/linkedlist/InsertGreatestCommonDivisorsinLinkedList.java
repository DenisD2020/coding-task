package linkedlist;

import twopointers.ListNode;

/**
 * https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/
 */
public class InsertGreatestCommonDivisorsinLinkedList {

    public static void main(String[] args) {
        System.out.println(new InsertGreatestCommonDivisorsinLinkedList().insertGreatestCommonDivisors(Helper.fromArray(new int[]{18, 6, 10, 3}))); // 18,6,6,2,10,1,3
        System.out.println(new InsertGreatestCommonDivisorsinLinkedList().insertGreatestCommonDivisors(Helper.fromArray(new int[]{7}))); // 7
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curNode = head;
        while (curNode != null && curNode.next != null) {
            ListNode newNode = new ListNode(gcd(curNode.val, curNode.next.val));
            newNode.next = curNode.next;
            curNode.next = newNode;
            curNode = newNode.next;
        }
        return head;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

   /* public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curNode = head;
        while (curNode != null && curNode.next != null) {
            ListNode newNode = new ListNode(gcd(curNode.val, curNode.next.val));
            newNode.next = curNode.next;
            curNode.next = newNode;
            curNode = newNode.next;
        }
        return head;
    }*/
}
