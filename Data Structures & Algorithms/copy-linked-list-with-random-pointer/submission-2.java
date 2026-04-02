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
    //creating copies and adding to orignal list only
      while(temp != null){
        Node copy = new Node(temp.val);
        copy.next = temp.next;
        temp.next = copy;
        temp = copy.next;
      }
     
     Node copyHead = head.next;
     temp = head;
    //updating random pointer same as in the original list.
     while(temp != null){

        if(temp.random != null){
            temp.next.random = temp.random.next;
        }
        temp = temp.next.next;
     }
     temp = head;
     Node fnl = copyHead;
    while(temp != null ){
        
        temp.next = temp.next.next;
        if(fnl.next != null){
            fnl.next = fnl.next.next;
        }
        fnl = fnl.next;
        temp = temp.next;
    }
    return copyHead;

    }
}
