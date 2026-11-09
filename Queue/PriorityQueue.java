public class PriorityQueue {

    private static class Node {
        Object value;
        int level;
        Node next;

        Node(Object value, int level) {
            this.value = value;
            this.level = level;
        }
    }

    private Node head;
    private int total;

    public PriorityQueue() {
        head = null;
        total = 0;
    }

    public void add(Object item, int priority) {
        Node baru = new Node(item, priority);

        if (head == null || priority > head.level) {
            baru.next = head;
            head = baru;
        } else {
            Node posisi = head;

            // Prioritas yang sama tetap mengikuti urutan kedatangan.
            while (posisi.next != null && posisi.next.level >= priority) {
                posisi = posisi.next;
            }

            baru.next = posisi.next;
            posisi.next = baru;
        }
        total++;
    }

    public Object remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue kosong");
        }

        Object hasil = head.value;
        head = head.next;
        total--;
        return hasil;
    }

    public Object getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue kosong");
        }
        return head.value;
    }

    public int getFrontPriority() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue kosong");
        }
        return head.level;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return total;
    }

    public static void main(String[] args) {
        PriorityQueue daftar = new PriorityQueue();

        daftar.add("Tugas A", 2);
        daftar.add("Tugas B", 5);
        daftar.add("Tugas C", 1);
        daftar.add("Tugas D", 5);
        daftar.add("Tugas E", 3);

        System.out.println("Prioritas teratas: " + daftar.getFront()
                + " (nilai " + daftar.getFrontPriority() + ")");

        System.out.print("Urutan pelayanan: ");
        while (!daftar.isEmpty()) {
            System.out.print(daftar.getFront() + "["
                    + daftar.getFrontPriority() + "] ");
            daftar.remove();
        }
        System.out.println();
    }
}
