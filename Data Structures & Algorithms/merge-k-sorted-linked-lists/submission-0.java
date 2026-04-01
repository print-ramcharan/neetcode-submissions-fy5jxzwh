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
    public ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)-> a.val - b.val) ;
       ListNode fnl = new ListNode(0);
       
       for(ListNode list : lists){
        if(list != null){
            minHeap.offer(list);
        }
       }
       ListNode temp = fnl;

        while(! minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            temp.next = node;
            temp = temp.next;

            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
       
       return fnl.next;
    }
}
