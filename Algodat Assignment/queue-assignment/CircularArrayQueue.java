public class CircularArrayQueue {

    private Object[] elemen;
    private int awal;
    private int jumlah;
    private int batas;

    public CircularArrayQueue(int kapasitas) {
        if (kapasitas < 1) {
            throw new IllegalArgumentException("Kapasitas minimal 1");
        }

        batas = kapasitas;
        elemen = new Object[batas];
        awal = 0;
        jumlah = 0;
    }

    public CircularArrayQueue() {
        this(8);
    }

    public void add(Object item) {
        if (isFull()) {
            throw new IllegalStateException("Circular queue sudah penuh");
        }

        int posisiAkhir = (awal + jumlah) % batas;
        elemen[posisiAkhir] = item;
        jumlah++;
    }

    public Object remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Circular queue kosong");
        }

        Object hasil = elemen[awal];
        elemen[awal] = null;
        awal = (awal + 1) % batas;
        jumlah--;
        return hasil;
    }

    public Object getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Circular queue kosong");
        }
        return elemen[awal];
    }

    public boolean isEmpty() {
        return jumlah == 0;
    }

    public boolean isFull() {
        return jumlah == batas;
    }

    public int size() {
        return jumlah;
    }

    public int capacity() {
        return batas;
    }

    public static void main(String[] args) {
        CircularArrayQueue antrean = new CircularArrayQueue(4);

        antrean.add('a');
        antrean.add('b');
        antrean.add('c');
        antrean.add('d');

        System.out.println("Elemen terdepan: " + antrean.getFront()
                + " (" + antrean.size() + "/" + antrean.capacity() + ")");

        System.out.println("Keluar: " + antrean.remove());
        System.out.println("Keluar: " + antrean.remove());

        antrean.add('e');
        antrean.add('f');

        System.out.print("Isi akhir: ");
        while (!antrean.isEmpty()) {
            System.out.print(antrean.remove() + " ");
        }
        System.out.println();
    }
}
