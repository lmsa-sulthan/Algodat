public class DoublyLinkedListQueue {

    private static class Node {
        Object value;
        Node before;
        Node after;

        Node(Object value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int total;

    public DoublyLinkedListQueue() {
        head = null;
        tail = null;
        total = 0;
    }

    public void add(Object item) {
        Node baru = new Node(item);

        if (isEmpty()) {
            head = baru;
            tail = baru;
        } else {
            baru.before = tail;
            tail.after = baru;
            tail = baru;
        }
        total++;
    }

    public Object remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue masih kosong");
        }

        Object hasil = head.value;
        head = head.after;

        if (head == null) {
            tail = null;
        } else {
            head.before = null;
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

    public Object getEnd() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue masih kosong");
        }
        return tail.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return total;
    }

    public static void main(String[] args) {
        DoublyLinkedListQueue antrean = new DoublyLinkedListQueue();

        antrean.add('a');
        antrean.add('b');
        antrean.add('c');

        System.out.println("Data pertama : " + antrean.getFront());
        System.out.println("Data terakhir: " + antrean.getEnd());
        System.out.println("Dihapus      : " + antrean.remove());
        System.out.println("Depan baru   : " + antrean.getFront());

        antrean.add('d');
        System.out.println("Ujung baru   : " + antrean.getEnd());

        System.out.print("Isi antrean  : ");
        while (!antrean.isEmpty()) {
            System.out.print(antrean.remove() + " ");
        }
        System.out.println();
    }
}
