class ListNode {
    Object data;
    ListNode next;

    ListNode(Object data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}

public class Stack {
    private ListNode top;

    public Stack() {              // buat stack kosong
        top = null;
    }

    public void push(Object obj) { // masukkan objek ke puncak
        top = new ListNode(obj, top);
    }

    public Object pop() {          // ambil dan hapus elemen puncak
        if (isEmpty()) throw new RuntimeException("Stack kosong");
        Object d = top.data;
        top = top.next;
        return d;
    }

    public Object top() {          // lihat elemen puncak
        if (isEmpty()) throw new RuntimeException("Stack kosong");
        return top.data;
    }

    public boolean isEmpty() {     // cek apakah stack kosong
        return top == null;
    }
}
