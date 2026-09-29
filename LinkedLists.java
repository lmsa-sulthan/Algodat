public class LinkedLists {
    Node head;

    public void tambah(int nilai){
        Node nodeBaru = new Node(nilai);

        if (head == null){
            head = nodeBaru;
        } else {
            Node posisiSaatIni = head;
            while (posisiSaatIni.selanjutnya != null){
                posisiSaatIni = posisiSaatIni.selanjutnya;
            }
            posisiSaatIni.selanjutnya = nodeBaru;
        }
    }

    public void tampilkanList(){
        Node posisiSaatIni = head;
        System.out.print("Elemen di dalam list: ");
        while(posisiSaatIni != null){
            System.out.print(posisiSaatIni.nilai + " => ");
            posisiSaatIni = posisiSaatIni.selanjutnya;
        }
        System.out.println("KOSONG");
    }
}