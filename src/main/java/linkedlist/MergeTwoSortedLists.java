package linkedlist;

import twopointers.Helper;
import twopointers.ListNode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        System.out.println(new MergeTwoSortedLists().mergeTwoLists(
                        Helper.fromArray(new int[]{1, 2, 4}),
                        Helper.fromArray(new int[]{1, 3, 4})
                )
        );
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {


        ListNode start = new ListNode(-1);
        ListNode last = start;


        while (list1 != null || list2 != null) {

            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    last.next = list1;
                    list1 = list1.next;
                    last = last.next;
                } else {
                    last.next = list2;
                    list2 = list2.next;
                    last = last.next;
                }
            } else if (list1 != null) {
                last.next = list1;
                list1 = list1.next;
                last = last.next;
            } else if (list2 != null) {
                last.next = list2;
                list2 = list2.next;
                last = last.next;
            }
        }
        return start.next;
    }
}
