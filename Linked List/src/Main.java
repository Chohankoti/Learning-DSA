public class Main {
    public static void main(String[] args) {
        SLL list = new SLL();

        list.insertFirst(2);
        list.insertFirst(1);

//        list.display();

        list.insertLast(4);

//        list.display();

        list.insert(3,2);

        list.display();

//        System.out.println("Deleted val: "+list.deleteFirst());

//        list.deleteLast();
//        list.delete(0);

        list.reverse();

        list.display();

    }
}