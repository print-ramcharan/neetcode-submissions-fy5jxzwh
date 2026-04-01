class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }

        if (count == k) {
            ListNode prev = null;
            ListNode next = null;
            ListNode tempHead = head;
            count = 0;
            while (count < k) {
                next = tempHead.next;
                tempHead.next = prev;
                prev = tempHead;
                tempHead = next;
                count++;
            }

            if (next != null) {
                head.next = reverseKGroup(next, k);
            }

            return prev; 
        }

        return head; 
    }
}
