class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find length and tail
        int n = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // Step 2: Reduce k
        k = k % n;
        if (k == 0) {
            return head;
        }

        // Step 3: Make it circular
        tail.next = head;

        // Step 4: Find new tail (n - k - 1 steps from head)
        ListNode newTail = head;
        for (int i = 1; i < n - k; i++) {
            newTail = newTail.next;
        }

        // Step 5: New head
        ListNode newHead = newTail.next;

        // Step 6: Break the circle
        newTail.next = null;

        return newHead;
    }
}