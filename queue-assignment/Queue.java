public class Queue {

    private static class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int total;

    public Queue() {
        head = null;
        tail = null;
        total = 0;
    }

    public void add(Object item) {
        Node baru = new Node(item);

        if (isEmpty()) {
            head = baru;
        } else {
            tail.next = baru;
        }

        tail = baru;
        total++;
    }

    public Object remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue masih kosong");
        }

        Object hasil = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        total--;
        return hasil;
    }

    public Object getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue masih kosong");
        }
        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return total;
    }

    public static void main(String[] args) {
        Queue antrean = new Queue();

        antrean.add('a');
        antrean.add('b');
        antrean.add('c');
        antrean.add('d');

        System.out.println("Elemen depan : " + antrean.getFront());
        System.out.println("Dikeluarkan  : " + antrean.remove());

        antrean.add('e');
        antrean.add('f');

        System.out.println("Dikeluarkan  : " + antrean.remove());
        System.out.println("Depan terbaru: " + antrean.getFront());
        System.out.println("Jumlah data  : " + antrean.size());

        System.out.print("Sisa antrean : ");
        while (!antrean.isEmpty()) {
            System.out.print(antrean.remove() + " ");
        }
        System.out.println();
    }
}
