public class LinkedList {
    Node kepala = null;
    Node ekor = null;

    public void tambah(Data dataBaru) {
        Node nodeBaru = new Node(dataBaru);
        
        if (kepala == null) {
            kepala = nodeBaru;
            ekor = nodeBaru;
        } else {
            ekor.lanjut = nodeBaru;
            ekor = nodeBaru;
        }
    }

    public void tampilkan() {
        if (kepala == null) {
            System.out.println("Data masih kosong.");
            return;
        }
        
        Node saatIni = kepala;
        while (saatIni != null) {
            System.out.println("- " + saatIni.data.toString());
            saatIni = saatIni.lanjut;
        }
    }

    public void hapus(Data kunciHapus) {
        if (kepala == null) return;

        if (kepala.data.equals(kunciHapus)) {
            kepala = kepala.lanjut;
            if (kepala == null) {
                ekor = null;
            }
            System.out.println(kunciHapus.getNama() + " berhasil dihapus.");
            return;
        }

        Node sebelum = kepala;
        Node saatIni = kepala.lanjut;

        while (saatIni != null) {
            if (saatIni.data.equals(kunciHapus)) {
                sebelum.lanjut = saatIni.lanjut; 
                if (saatIni == ekor) {
                    ekor = sebelum;
                }
                System.out.println(kunciHapus.getNama() + " berhasil dihapus.");
                return;
            }
            sebelum = saatIni;
            saatIni = saatIni.lanjut;
        }
        System.out.println("Data tidak ditemukan.");
    }
}