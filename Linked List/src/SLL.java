public class SLL {

    private Node head;
    private Node tail;
    private int size;

    public SLL(){
        this.size = 0;
    }

    private class Node {
        private int val;
        private Node next;

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val);
            System.out.print(" -> ");
            if (temp.next == null) {
                System.out.println("END");
            }
            temp = temp.next;
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val);

        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size++;
    }

    public void insertLast(int val){
        Node node = new Node(val);

        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public void insert(int val, int index){

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if(index == 0){
            insertFirst(val);
            return;
        }

        if(index == size){
            insertLast(val);
            return;
        }

        Node temp = head;

        for(int i=0; i<index-1; i++){
            temp = temp.next;
        }

        Node node = new Node(val,temp.next);

        temp.next = node;

        size++;
    }

    public int deleteFirst(){
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }

        int val = head.val;

        head = head.next;

        if(head == null){
            tail = null;
        }

        size--;

        return val;
    }

    public int deleteLast(){

        if (size == 0) {
            throw new RuntimeException("List is empty");
        }

        int val = tail.val;
        if(size == 1){
            head = null;
            tail = null;
        }else{
            Node temp = head;

            for(int i=0; i<size-2; i++){
                temp = temp.next;
            }

            tail = temp;
            tail.next = null;
        }

        size--;

        return val;
    }

    public int delete(int index){
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if(index == 0){
            return deleteFirst();
        }
        if(index == size-1){
            return deleteLast();
        }

        Node temp = head;
        for(int i=0; i<index-1; i++){
            temp = temp.next;
        }

        int val = temp.next.val;

        temp.next = temp.next.next;

        size--;

        return val;
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;

        tail = head; // old head becomes new tail

        while (curr != null) {
            next = curr.next;   // store next
            curr.next = prev;   // reverse link
            prev = curr;        // move prev
            curr = next;        // move curr
        }

        head = prev; // new head
    }
}
