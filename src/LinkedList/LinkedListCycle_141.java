package LinkedList;

public class LinkedListCycle_141 {
        public static void main(String[] args) {
            ListNode head = createList(new int[]{3,2,0,-4,10,11,12,13});

            ListNode curr = head;
            while (curr != null && curr.next != null) {
                curr = curr.next;
            }
            curr.next = head.next;

            System.out.println(hasCycle(head));
        }

        public static boolean hasCycle(ListNode head) {
            //initialise both fast and slow pointer at the head
            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;

                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }

        public static ListNode createList(int[] values) {
            if (values.length == 0) return null;
            ListNode head = new ListNode(values[0]);
            ListNode curr = head;
            for (int i = 1; i < values.length; i++) {
                curr.next = new ListNode(values[i]);
                curr = curr.next;
            }
            return head;
        }

        private static class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
                next = null;
            }
        }
}
