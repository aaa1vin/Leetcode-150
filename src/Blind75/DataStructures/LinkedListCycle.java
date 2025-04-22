package Blind75.DataStructures;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

//        ListNode curr = head;
//        while (curr != null) {
//            System.out.print(curr.val + " ");
//            curr = curr.next;
//        }
        System.out.println(hasCycle(head));
    }

    // Floyd’s algorithm
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // move 1 step
            fast = fast.next.next;     // move 2 steps

            if (slow == fast) {        // cycle detected
                return true;
            }
        }

        return false; // no cycle
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }
}