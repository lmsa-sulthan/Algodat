public class Stack {

    private static class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }

    private Node top;
    private int total;

    public Stack() {
        top = null;
        total = 0;
    }

    public void push(Object item) {
        Node baru = new Node(item);
        baru.next = top;
        top = baru;
        total++;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack masih kosong");
        }

        Object hasil = top.value;
        top = top.next;
        total--;
        return hasil;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack masih kosong");
        }
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return total;
    }
}
