/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
       ListNode slow = head;
       ListNode fast = head.next;

       while(fast !=null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
       }

       ListNode second = slow.next;
       ListNode prev = slow.next = null;

       while (second != null) {
            ListNode nextTemp = second.next;
            second.next = prev;
            prev = second;
            second = nextTemp;
        }
        ListNode secondHalf = prev; // This is the reversed second half

        ListNode first = head, secondMerged = secondHalf;
        while (secondMerged != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = secondMerged.next;
            
            first.next = secondMerged; // Connect first to second
            secondMerged.next = temp1; // Connect second to the next of first
            
            first = temp1; // Move first pointer
            secondMerged = temp2; // Move second pointer
        }
    }
    }

