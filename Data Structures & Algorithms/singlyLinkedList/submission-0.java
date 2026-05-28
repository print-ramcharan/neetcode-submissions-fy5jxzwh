class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
        this.next = null;
    }
}
class LinkedList {

    
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = new Node(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        
        Node temp = head.next;

        int i = 0;
        while(temp != null && i != index){
            temp = temp.next;
            i ++;
        }
        if(temp == null) return - 1;
    
        return temp.val;
    }

    public void insertHead(int val) {

        Node temp = new Node(val);

        temp.next = head.next;
        head.next = temp;

        if(tail == head){
            tail = temp;
        }
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);

        tail.next = newNode;
        tail = newNode;
    }

    public boolean remove(int index) {
        Node temp = head;

        for(int i = 0; i < index && temp != null; i ++){
            temp = temp.next;
        }

        if(temp != null && temp.next != null){
            if(temp.next == tail) tail = temp;

            temp.next = temp.next.next;
            return true;
        }
        
        return false;
    }

    public ArrayList<Integer> getValues() {
        
        ArrayList<Integer> res = new ArrayList<>();

        Node temp = head.next;

        while(temp != null){
            res.add(temp.val);
            temp = temp.next;
        }
        return res;
    }
}
