/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
      
      Node temp = head;
    
      while(temp != null){
        Node copy = new Node(temp.val);
        copy.next = temp.next;
       
        temp.next = copy;
        temp = copy.next;
      }
       temp = head;
       while (temp != null) {
    if (temp.next != null) {
        temp.next.random = (temp.random != null) ? temp.random.next : null;
    }
    temp = temp.next.next;
}


       temp = head;
        Node copyHead = head.next; 
        Node copyTemp = copyHead;

        while (temp != null) {
            temp.next = temp.next.next;  
            if (copyTemp.next != null) {
                copyTemp.next = copyTemp.next.next; 
            }
            temp = temp.next;
            copyTemp = copyTemp.next;
        }

        return copyHead;
    }
}